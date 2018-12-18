package thread;
/**
 * 静态方法若使用synchronized修饰后，那么一定具有同步效果。
 * @author OldFarHigh
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
	//final Boo  b = new Boo();
		Thread t1 = new Thread() {
			public void run() {
	//			b.dosome();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
	//		b.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized static void dosome() {
		try {
			Thread  t = Thread.currentThread();
			System.out.println(t.getName()+":正在运行dosome");
			Thread.sleep(500);
			System.out.println(t.getName()+":运行dosome方法");
		} catch (Exception e) {
			e.printStackTrace();		}
	}
}