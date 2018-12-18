package thread;
/**
 * 互斥锁
 * 当synchronized同时锁定多段代码片段时，并且他们指定的同步监视器对象是【同一个】时，
 * 那么这些代码片段之间就是互斥的，即：多个线程不能同时执行这些代码片段
 * @author OldFarHigh
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
	final	 Foo f = new Foo();
		Thread t1 = new Thread() {
			public void run() {
				f.methosA();
			}
	};
		Thread t2 = new Thread() {
		public void run() {
			f.methosB();
		}
};
		t1.start();
		t2.start();
}
}

class Foo{
	public synchronized void methosA(){
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":我正在运行A方法");
			Thread.sleep(500);
			System.out.println(t.getName()+":我正在运行A方法");
			Thread.sleep(500);
		} catch (Exception e) {
		}
	}
	public  void methosB(){
		synchronized(this) {
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+":我正在运行B方法");
				Thread.sleep(500);
				System.out.println(t.getName()+":我正在运行B方法");
		} catch (Exception e) {
		}
		}
		
}
}
