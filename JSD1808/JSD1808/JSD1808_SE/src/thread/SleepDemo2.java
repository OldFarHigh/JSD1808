package thread;
/**
 * 当一个线程调用sleep方法处于阻塞状态时，其他线程调用该线程的中断方法时，
 * 那么该线程的sleep方法会立即抛出中断异常并打断睡眠阻塞。
 * @author OldFarHigh
 *
 */
public class SleepDemo2 {
	public static void main(String[] args) {
		/*
		 * JDK8之前，有一个要求，即：
		 * 当一个方法中的局部内部类想引用这个方法的其他局部变量，那么这个变量必须是final的
		 * 好在main方法中的局部内部类hai中的run方法里引用了main方法的局部变量hui，
		 * 那么这个变量就必须声明为final的
		 */
	/*	final */Thread h1 =  new Thread() {
			public void run() {
				System.out.println("大家好，我叫骚灰，今天我要早睡！");
				try {
					/*
					 * 当一个线程调用sleep阻塞时，被其他线程中断时会抛出中断异常
					 */
					Thread.sleep(10000000);
				} catch (InterruptedException e) {
					System.out.println("辉哥说：醒是不可能醒的，我要继续睡！");
				}
				System.out.println("辉哥：我要7：40醒");
			}
		};
		
		Thread h2 = new Thread() {
			public void run() {
					System.out.println("老衲要开始睡觉，5：40去叫辉哥起床！");
					for (int i = 0; i <8; i++) {
						System.out.println("睡了一个小时！");	
						try {
						Thread.sleep(1000);
					}
					 catch (InterruptedException e) {
				}		
			}
					System.out.println("老衲要去叫辉哥起床了");
					h1.interrupt();//中断此方法
			}
		};
		h1.start();
		h2.start();
	}
}
