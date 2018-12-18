package cn.tedu.shoot;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
//import java.awt.Graphics;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import java.util.Arrays;
//import java.util.TimerTask;


/** 主窗口 */ 
public class World  extends JPanel{
	public static final int WIDTH= 400;//静态常量，窗口的宽
	public static final int HEIGHT = 700;//静态常量，窗口的高
	
	public static final int START =0;//启动状态
	public static final int RUNNING =1;//运行状态
	public static final int PAUSE=2;//暂停状态
	public static final int GAME_OVER =3;//游戏结束状态
	private int state = START;//当前状态(默认为启动状态)
	
	private static BufferedImage start;//启动图
	private static BufferedImage pause;//暂停图
	private static BufferedImage gameover;//游戏结束图
	static {//初始化静态资源
		start = FlyingObject.loadImage("start.png");
		pause = FlyingObject.loadImage("pause.png");
		gameover = FlyingObject.loadImage("gameover.png");
	}
	
	private Sky sky = new Sky();//天空对象
	private Hero hero = new Hero() ;//英雄机
	private FlyingObject []  enemies   = {}; //创建敌人数组，包括，小敌机、大敌机、小蜜蜂
	private Bullet[] bullets = {};//子弹数组
	/**随机生成敌人（大敌机，小敌机，小蜜蜂）对象*/
	public FlyingObject nextOne() {
		Random rand = new Random();//随机数组对象
		int type = rand.nextInt(20);//生成0-19之内的随机数
		if(type<5) {
			return new Bee();//0-4，返回小蜜蜂
		}else if (type<12) {
			return new Airplane();//5-11，返回小敌机
		}else {
			return new BigAirplane();//其余的返回大敌机
		}
	}
	int enterIndex = 0;//敌人入场计数
	/**控制敌人（大敌机，小敌机，小蜜蜂）入场*/
	public void enterAction() {//每10ms走一次
		enterIndex++;//每10ms增1
		if(enterIndex%40==0) {//每400ms（10*40）走一次
			FlyingObject obj = nextOne();//获取敌人对象
			enemies = Arrays.copyOf(enemies,enemies.length+1);//敌人数组扩容
			enemies[enemies.length-1] = obj;//将敌人对象装进数组的最后
		}
	}
	/**子弹入场*/
	int shootIndex = 0;//子弹入场的计数
	public void shootAction() {//每10ms走一次
		shootIndex++;//每30ms走一次
		if(shootIndex%30 == 0) {//每300ms（10*30）走一次
			Bullet[] bs = hero.shoot();//获取子弹对象
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length);//子弹数组的扩容
			System.arraycopy(bs,0,bullets, bullets.length-bs.length, bs.length);//数组的追加
		}
	}
	/**飞行物移动的方法*/
	public void  stepAction() {//每10ms走一次
		sky.step();//天空移动
		for (int i = 0; i < enemies.length; i++) {//遍历所有敌人
			enemies[i].step();//敌人移动
		}
		for (int i = 0; i < bullets.length; i++) {//遍历所有子弹
			bullets[i].step();//子弹移动
		}
		
	}
	/**删除越界的敌人和子弹*/
	public void  outOfBoundsAction() {//每10ms走一次
		int index =0;//1)不越界敌人数组的下标2）不越界敌人个数
		FlyingObject [] enemyLives = new  FlyingObject[enemies.length];//创建不越界敌人数组，长度为初始敌人数组长度
		for (int i = 0; i < enemyLives.length; i++) {//遍历敌人数组
			FlyingObject f  = enemies[i];//获取每一个敌人
			if(!f.outOfBounds() && !f.isRemove()) {//不越界的并且非删除状态
				enemyLives[index] = f;//将不越界的敌人装载进敌人数组
				index ++;//个数加1
			}
		}
		enemies = Arrays.copyOf(enemyLives,index);//装填敌人
		
		index =0 ;//将敌人个数清零，用于子弹数组中
		Bullet[] bulletLives = new Bullet[bullets.length];//创建数组，收集不越界的子弹，用来装填进子弹数组
		for (int i = 0; i < bulletLives.length; i++) {//遍历子弹数组
			Bullet b = bullets[i];//获取每一个子弹
			if(!b.outOfBounds() && !b.isRemove()) {//不越界的并且是非删除状态的
				bulletLives[index] = b;//将不越界的子弹收集到数组中
				index ++;//个数加1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//将收集的子弹
//		index = 0;//清零
		
	}
	/**子弹与敌人相撞*/
	int score = 0;
	public void bulletBangAction() {//每10ms走一次
		for (int i = 0; i < bullets.length; i++) {//遍历整个子弹数组
			Bullet b = bullets[i];//获取每个子弹
			for (int j = 0; j < enemies.length; j++) {//遍历整个敌人数组
				FlyingObject f  =enemies[j];//获取每个敌人
			if(b.isLife() && f.isLife() && f.hit(b)) {//如果子弹和敌人是活着状态,发生了相撞
				b.goDead();//子弹去死
				f.goDead();//敌人去死
				
			if(f  instanceof Enemy) {//如果敌人是得分类型(小敌机,大敌机)
				Enemy e = (Enemy) f;//将敌人强转为得分接口,用来调用得分接口所拥有的方法
				score += e.getScore();//分数增加,调用增加分数的方法
			}
			if(f instanceof Award) {//如果敌人是奖励类型(小蜜蜂)
				Award a = (Award) f;//将敌人强转为奖励类型
				int type = a.getAwardType();//获取奖励类型
				switch(type) {//判断奖励类型
				case Award.Doubule_FIRE://如果奖励类型是增加火力值
					hero.addDoubleFire();//英雄机执行增加火力值的方法
					break;//跳出
				case Award.LIFE://如果奖励类型是增加生命
					hero.addLife();//英雄机执行增加生命的方法
					break;//跳出
				}
			}
			}
			}
		}
	}
	/**英雄机和敌人碰撞*/
	public void heroBangAction() {//每10ms走一次
		for (int i = 0; i < enemies.length; i++) {//遍历所有敌人
			  FlyingObject f = enemies[i];//获取每一个敌人
			  if(f.isLife() && hero.isLife() && f.hit(hero)) {//如果敌人是活的,并且英雄机是活的，两者相撞
				  f.goDead();
				  hero.subtractLife();
				  hero.clearDoubleFire();
			  }
		}
	}
	/**检测游戏结束*/
	public void checkGameOverAction() {//每10ms走一次
		if(hero.getLife() <= 0) {//游戏结束
			state = GAME_OVER;//将当前状态修改为游戏结束状态
		}
	}
	/**启动程序的执行*/
	public void action() { 
		MouseAdapter l = new MouseAdapter() {
			/**重写mouseMoved()鼠标移动*/
			public void mouseMoved(MouseEvent e) {
				if(state == RUNNING) {//启动状态时执行
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的y坐标
					hero.moveTo(x, y);//英雄机随着鼠标移动
				}
			}
			/**重写mouseClicked()鼠标点击*/
			public void mouseClicked(MouseEvent e) {
				switch (state) {//根据当前状态做出处理
				case START://启动状态时
						state = RUNNING;//修改为运行状态
						break;
				case GAME_OVER://游戏结束状态时
					score = 0;	//清理现场
					sky = new Sky();
					hero = new Hero();
					enemies = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;//修改为启动状态
					break;
				}
			}
			/**重写mouseExited()鼠标移出*/
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING) {//运行状态时
					state = PAUSE;//修改为暂停状态
				}
			}
			/**重写mouseEntered()鼠标移入*/
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE) {//暂停状态时
					state = RUNNING;//修改为运行状态
				}
			}
		};//侦听器对象
		this.addMouseListener(l);//处理鼠标操作事件
		this.addMouseMotionListener(l);//处理鼠标滑动事件
		Timer timer = new Timer();//创建定时器对象
		int interval = 10;//以毫米为单位
		timer.schedule(new TimerTask() {
			public void run() {//定时干的事，每10ms执行一次	
				if(state == RUNNING) {//启动状态时执行
					enterAction();//敌人（小敌机，大敌机，小蜜蜂）进场
					shootAction();//子弹入场
					stepAction();//飞行物移动
					outOfBoundsAction();//删除越界的敌人和子弹
//			打桩		System.out.println(enemies.length+","+bullets.length);
					bulletBangAction();//子弹和敌人的碰撞
					heroBangAction();//英雄机碰撞方法
					checkGameOverAction();//检测游戏结束
				}
				
				repaint();//重画（重新调用paint）
				
			}
		},interval,interval);//定时的计划
		
		}
	/**重写paint()画g:画笔*/
	public void paint(Graphics g) {
		sky.paintObject(g);//画天空
		hero.paintObject(g);//画英雄机
		for (int i = 0; i < enemies.length; i++) {//遍历所有敌人
			enemies[i].paintObject(g);//画敌人
		}
		for (int i = 0; i < bullets.length; i++) {//遍历所有子弹
			bullets[i].paintObject(g);//画子弹
		}
		g.drawString("SCORE:"+score,10,20);//画分
		g.drawString("LIFE:"+hero.getLife(),10 ,30 );//画命
		switch(state) {//根据当前状态画不同的图
		case START://启动状态时画启动图
			g.drawImage(start,0,0,null);
			break;
		case PAUSE://暂停状态时画暂停图
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://游戏结束时画结束图
			g.drawImage(gameover,0,0,null);
			break;	
		}
	}
	/**主方法*/
	public static void main(String[] args) {
		JFrame frame = new JFrame("world");
		World world = new World();
		frame.add(world);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT );
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); //1)设置窗口可见 2）尽快调用调用paint()
		world.action();
	}

}
