package cn.tedu.shoot;
import java.awt.image.BufferedImage;
public class Hero extends FlyingObject {
	private static BufferedImage[ ] images;
	static {
		images  = new BufferedImage[2] ;
		images [0] =loadImage("hero0.png");
		images[1] = loadImage("hero1.png");
	}
	private int life;
	private int doubleFire;
	/** 英雄机随着鼠标移动而移动*/ 
	public Hero(){
		super(97,124,140,400);
		this.life = 3;
		this.doubleFire = 0;
		
	}
	/**英雄机随着鼠标的移动而移动*/
	public void moveTo(int x,int y ) {
		this.x = x-this.width/2;
		this.y = y-this.height/2;
	}
	/**重写step()移动*/
	public void step() {
	}
	/**重写getImage()获取图片*/
	int index = 0;//活着的下标
	public BufferedImage getImage() {
		if(isLife()) {
			return images[index++%images.length];
		}
		return null;//死了或者删除状态返回null
		/*
		 * 								index=0;
		 * 10ms 返回image[0]  	index=1;
		 * 20ms 返回image[1]		index=2;
		 *30ms 返回image[0]		index=3;
		 *40ms 返回image[1]		index=4;
		 *50ms 返回image[0]		index=5;
		 * 
		 */
	}
	/**英雄机发射子弹(生成子弹对象)*/
	public Bullet[] shoot() {
		int xStep = this.width/4;//1/4英雄机的宽
		int yStep = 20;//固定的20距离
		if (doubleFire>0) {//双
			Bullet[] bs = new Bullet[2];//两发子弹
			bs[0] = new Bullet(this.x+1*xStep,this.y-yStep);//x的
			bs[1] = new Bullet(this.x+3*xStep,this.y-yStep);//x的
			doubleFire-=2;//发射一次双倍火力，则火力值清零
			return bs;
		} else {//单
			Bullet[] bs = new Bullet[1];//一发子弹
			bs[0] = new Bullet(this.x+2*xStep,this.y-yStep);
			return bs;
		}
	}
	/**英雄机增命*/
	public void addLife() {
		life++;
	}
	/**获取英雄机的命*/
	public int getLife() {
		return life;
	}
	/**英雄机减命*/
	public void subtractLife() {
		life--;//命数减1
	}
	/**英雄机增火力*/
	public void addDoubleFire() {
		doubleFire+=40;
	}
	/**火力值清零*/
	public void clearDoubleFire() {
		doubleFire = 0;//火力值归零
	}
}

