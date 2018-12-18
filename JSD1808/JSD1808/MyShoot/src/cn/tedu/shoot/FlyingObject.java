package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Graphics;
/**小敌机*/
public  abstract class FlyingObject { //抽象类
	//静态常量
	public static final int LIFE = 0;//活着的
	public static final int DEAD = 1;//死了的
	public static final int REMOVE = 2;//删除的
	protected int state = LIFE ;//当前状态
	//实例变量
	protected  int x;//x坐标
	protected int y;//y坐标
	protected int width;//宽
	protected int height;//高 
	/**专门给英雄机，天空，子弹提供的构造方法*/
	public FlyingObject(int width,int height,int x,int y){//局部变量
		//局部变量的值传给成员变量
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	/**专门给小敌机、大敌机、小蜜蜂提供的构造方法*/
	public FlyingObject(int width,int height){//局部变量，调用时需要传递参数
		//局部变量的值传给成员变量
		this.width = width;
		this.height = height;
		Random rand = new Random();//随机数对象
		x =  rand.nextInt(World.WIDTH-this.width);//x：0到（400-小敌机的宽width）
		y = - this.height;//y:负的小敌机的高
	}
	/**飞行物的移动*/
	public abstract  void step() ;//抽象方法，会将类也抽象
	/**读取图片*/
	public static  BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName)) ;//同包下读取图片
			 return  img;
			 }catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**获取图片*/
	public abstract BufferedImage getImage();
	/**判断状态是否为活着的*/
	public boolean isLife() {
		return state == LIFE;
	}
	/**判断是否为死亡*/
	public boolean isDead() {
		return state == DEAD;
	}
	/**判断是否为删除状态*/
	public boolean isRemove() {
		return state == REMOVE;
	}
	/**画对象，画笔*/
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);//不要求掌握
	}
	/**敌人的越界检查(适用于大敌机，小敌机，小蜜蜂)*/
	public boolean outOfBounds() {
		return this.y >= World.HEIGHT;//当敌人的y>=窗口的高，即为越界
	}
	/**检测碰撞 this:代表敌人 other:子弹/英雄机*/
	public boolean hit(FlyingObject other) {
		int x1 = this.x-other.width;//x1=敌人的x-子弹的宽
		int x2 = this.x+this.width;//x2=敌人的x+敌人的宽
		int y1 = this.y-other.height;//y1=敌人的y-子弹的宽
		int y2 = this.y+ this.height;//y2=敌人的y+敌人的宽
		int x = other.x;					//x:子弹的x
		int y = other.y;					//y:子弹的y
		return x>=x1 && x<=x2 
				&&
				y>=y1 && y<=y2;//x在x1和x2之间,并且y在y1和y2之间,即为撞上了
		
	}
	/**飞行物死亡*/
	public void goDead() {
		state = DEAD;
	}
}
