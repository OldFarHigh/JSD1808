package cn.tedu.shoot;
import java.awt.image.BufferedImage;
public class Bullet extends FlyingObject {
/**获取图片属性*/
	private static BufferedImage image;
	static {
		image = loadImage("bullet.png");
	}
/**成员变量*/
	private int speed;//移动速度
/**构造方法*/
	public Bullet( int x,int y ){
		super(8,14,x,y);
		this.speed= 3;	
	}
/**重写step()方法*/
	public void step() {
		y-=speed;//y-(向上)
	}
/**重写getImage()获取图片*/
	public BufferedImage getImage() {
		if(isLife()) {//若活着的，返回image
			return image;
		}else if (isDead()) {//若死了的，当前状态改为删除状态
			state = REMOVE;
		}
		return null;//若死了或删除状态，返回 null
		}
	/**敌人的越界检查(适用于子弹)*/
	public boolean outOfBounds() {
		return this.y <= -this.height;//子弹的y<=负的子弹的高
	}
}
