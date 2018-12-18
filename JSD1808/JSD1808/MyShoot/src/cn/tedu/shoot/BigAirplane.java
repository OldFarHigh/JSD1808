package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/**大敌机是飞行物*/
public class BigAirplane extends FlyingObject implements Enemy {
	private static BufferedImage[ ] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("bigplane"+i+".png");
		}
	}
	private int speed;//移动速度
	/** 大敌机移动*/
	public  BigAirplane(){
		super(69,99);
		this.speed = 2;
	}
	/**重写step()移动*/
	public void step() {
		y+=speed;//y+(向下)
		}
/**加载图片*/
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
	/**重写getScore()加分*/
	public int getScore() {
		return 3;//打掉大敌机加3分
	}
	
}
