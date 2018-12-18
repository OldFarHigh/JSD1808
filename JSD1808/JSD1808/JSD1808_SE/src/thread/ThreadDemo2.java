package thread;
/**
 * 第二种创建线程的方法：
 * 实现Runnable接口，单独定义线程任务
 * @author OldFarHigh
 *
 */
public class ThreadDemo2 {

	public static void main(String[] args) {
		//实例化任务
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		
		//创建多线程
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	

	}

}

class MyRunnable1 implements Runnable{
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我真的还想再活500年！");
		}
	}
}

class MyRunnable2 implements Runnable{
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("好啊！");
		}
	}
}