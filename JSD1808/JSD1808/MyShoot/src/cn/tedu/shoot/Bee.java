package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;
/** 小蜜蜂是飞行物*/
public class Bee  extends FlyingObject implements Award{
/**获取图片属性的方法*/
	private static BufferedImage[ ] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("bee"+i+".png");
		}
	}
	private int xSpeed;//x坐标移动速度
	private int ySpeed;//y坐标移动速度
	private int awardType;//奖励类型
	/** 小蜜蜂的构造方法*/
	public Bee(){
		super(60,50);
		this.xSpeed = 1;
		this.ySpeed = 2;
		Random rand = new Random();//随机数对象
		this.awardType = rand.nextInt(2);//从0-1之间的随机数
	}
	/**重写step()移动*/
	public void step() {
		x+=xSpeed;//x+(向左或者向右)
		y+=ySpeed;//y+向下
		if(x<=0 || x>=World.WIDTH-this.width) {//到边界后
			xSpeed*=-1;//切换方向(正变负，负变正)
		}
		}
	/**重写getImage()获取图片*/
	int index = 1;
	public BufferedImage getImage() {
		if(isLife()) {
			return images[0];
		}else if(isDead()) {
			BufferedImage img = images[index++]; 
			if (index == images.length) {//如果到了最后一张了
				state =  REMOVE; //将当前状态修改为ROMOVE
			}
			return img;
		}
	return null;//删除状态返回null
	}
	/*
	 * 									    index=  1;
	 * 10ms    img = images[1];	   index = 2;	  			 返回images[1]
	 * 20ms   img = images[2];  	  index = 3; 	   		     	 返回images[2]
	 * 30ms  img = images[3]; 	 index = 4;	 			 返回images[3]
	 * 40ms img = images[4];	 	index = 5;(REMOVE)	 返回images[4] 
	 * 50ms  state = REMOVE     返回null
	 * 
	 */
	/**重写getAwardType方法获取奖励类型 */
	public int getAwardType() {
		return awardType;//返回奖励类型
	}
}
