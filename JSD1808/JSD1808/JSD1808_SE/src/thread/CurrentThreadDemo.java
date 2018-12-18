package thread;
/**
 * Thread提供了一个静态方法
 * static Thread currentThread()
 * 该方法可以获取运行这个方法的线程。
 * 
 * 后期常用的一个API：ThreadlLocal里面就会用到这个方法来实现功能
 * @author OldFarHigh
 *
 */
public class CurrentThreadDemo {
	 public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("主方法："+main);
		
		Thread t = new Thread() {//匿名内部类创建新的线程，新的线程仅有一个实例化
			public void run() {
				Thread t = Thread.currentThread();
				
				System.out.println("自定义："+t);
				dosome();//在新的类中调用方法，改变线程的运行
			}
		} ;
		t.start();
		dosome();
	}
	
	 public static void dosome() {
		 Thread t = Thread.currentThread();
		 System.out.println("新方法："+t);
	 }
}
