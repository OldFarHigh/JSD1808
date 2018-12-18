package thread;


/**
 * 守护线程、
 * 
 * 守护线程又称后台线程，默认创建出来的线程都是普通线程或称为前台线程
 * 只有调用线程的setDaemon方法后，才会将该线程设置为守护线程
 * 
 * 守护线程使用上与前台线程一样，但是在结束时机上有一点不同：
 * 当进程结束时，所有正在运行的守护线程都会被强制中断。
 * 
 *进程的结束：当一个进程中没有任何前台线程时即结束
 * @author OldFarHigh
 *
 */
public class DaemonThreadDemo {
	public static void main(String[] args) {
		Thread tai = new Thread() {
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("海哥，叫我起床！");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
			}
			System.out.println("起床失败！");	
			System.out.println("侦测到在途的聚变打击！");
			System.out.println("骚太瞬间爆炸！");
		}	
		};
		
		Thread hai = new Thread() {
			public void run() {
				while(true) {
						System.out.println("太哥起床了!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {	
					}
				}
			}
		};
		tai.start();
		/*
		 * 设置守护线程必须要在start方法之前进行
		 */
		hai.setDaemon(true);
		hai.start();
		
		
	}
	
}

