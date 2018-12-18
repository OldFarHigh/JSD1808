package thread;

import java.util.Scanner;

/**
 * 睡眠阻塞
 * 
 * static void sleep(long ms)
 * 该方法会让运行这个方法的线程处于阻塞状态指定的毫秒
 * 当超时后，线程会自动回到RUNNABLE状态，等待再次获取时间片并发运行
 * 
 * 注：一个线程进入阻塞状态，CPU会立刻释放去并发执行其他线程，直到该线程解除阻塞状态为止。
 * @author OldFarHigh
 *
 */
public class SleepDemo {
	public static void main(String[] args) {
		/*
		 * 程序启动后，输入一个数字，如：100
		 * 然后每一秒钟递减一次并输出，直到0为止
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int num = Integer.parseInt(sc.nextLine());
		for (int i = num; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("BOOM！沙卡拉卡");
		sc.close();
		}
		
}
