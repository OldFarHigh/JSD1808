package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**天空*/
public class Sky  extends FlyingObject{
	private static BufferedImage image;
	static {
		image = loadImage("background.png");
	}
	private int speed;//移动速度
	private int y1;//第二张图的Y坐标
	public  Sky(){
		super(World.WIDTH,World.HEIGHT,0,0);
		this.speed = 1;
		this.y1  =  - World.HEIGHT;
	}
	/**重写step()移动*/
	public void step()
	{
		y+=speed;//y+向下
		y1+=speed;//y1+向下
		if(y>=World.HEIGHT) {//当y>=窗口的高
			y=-World.HEIGHT;//则修改y的值为负的窗口的高
		}if(y1>=World.HEIGHT) {//当y1>=窗口的高
			y1=-World.HEIGHT;//则修改y1的值为负的窗口的高
		}
		//System.out.println("y="+y+",y1="+y1);
	}
	/**重写getImage()获取图片*/
	public BufferedImage getImage() {
		return image;//直接返回image 即可
	}
	/**重写paintObject()画对象*/
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);//不要求掌握
		g.drawImage(getImage(),x,y1,null);//加载图片
	}
}
