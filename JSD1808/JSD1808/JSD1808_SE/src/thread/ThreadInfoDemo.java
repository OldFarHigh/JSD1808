package thread;
/**
 * 线程提供了一系列获取当前线程信息的方法
 * @author OldFarHigh
 *
 */
public class ThreadInfoDemo {
	public static void main(String[] args) {
		//获取主线程
		Thread main = Thread.currentThread();
		
		long id = main.getId();//获取该线程的唯一标识符
		System.out.println("ID："+id);
		
		//获取线程名
		String  name = main.getName();
		System.out.println("name:"+name);
		//获取线程的优先级
		int priority = main.getPriority();
		System.out.println("priority:"+priority);
		//测试线程是否处于活动状态
		boolean isAlive = main.isAlive();
		System.out.println("isAlive:"+isAlive);
		//测试线程是否为守护状态
		boolean isDaemon = main.isDaemon();
		System.out.println("isDaemon:"+isDaemon);
		//测试线程是否被中断
		boolean isInterrupted = main.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
		
		main.interrupt();;
		
		System.out.println("isInterrupted:"+main.isInterrupted());
		
		//main.stop();
	}
}
