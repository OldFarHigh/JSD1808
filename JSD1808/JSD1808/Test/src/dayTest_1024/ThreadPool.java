package dayTest_1024;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 线程池
 * @author OldFarHigh
 *线程的集合称为线程池，当服务器接收到请求后，就从线程池中取出一个空闲的线程为之服务，
 *服务完后不关闭线程，而是回到线程池
 */
public class ThreadPool {
	public static void main(String[] args) {
		/**
		 * 懒汉模式  饿汉模式
		 */
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for (int i = 0; i <5; i++) {
			Runnable r = new Runnable() {//创建线程
				public void run() {//重写run方法
					Thread t = new Thread();
					System.out.println(t.getName()+"正在执行任务。。。");
					try {
						t.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(t.getName()+"任务执行完毕！");
			}
				
		};
		threadPool.execute(r);
		System.out.println("加载任务....");
		
}
		threadPool.shutdown();
		System.out.println("任务中止！");
}
}
