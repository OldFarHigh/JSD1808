package thread;
/**
 * join 方法可以协调线程之间的同步运行
 * 
 * 异步运行：代码之间运行没有先后顺序，各干各的。
 * 同步运行：代码运行有先后顺序
 * 
 * @author OldFarHigh
 *
 */
public class JoinDemo {
	public static boolean isFinish =false;//标示图片是否下载完毕 
	public static void main(String[] args) {
		Thread download = new Thread() {
			public void run() {
				System.out.println("Downloading。。。");
				for (int i = 0; i <= 100; i++) {
					System.out.println("Downloaded："+i+"%");
					try {
						Thread.sleep(50);
				
				}catch (InterruptedException e) {
				}
			}
				System.out.println("图片下载完成！");
				isFinish =true;
			}
		};
		
		Thread show = new Thread() {
			public void run() {
				System.out.println("开始显示图片！");
				/*
				 * 先等在下载线程将图片下载完毕
				 */
				try {
					/*
					 * 当show线程调用dowload线程额join方法后就进入了阻塞状态
					 * 直到download线程结束才会解除阻塞
					 */
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!isFinish) {
					throw new RuntimeException("图片加载失败！");
				}
				System.out.println("图片显示完毕！");
				//System.err.println("");//打印错误信息
			}
		};
		download.start();
		show.start();
	}
}
