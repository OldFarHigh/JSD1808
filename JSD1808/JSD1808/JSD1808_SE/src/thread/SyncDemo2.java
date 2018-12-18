package thread;
/**
 * 同步块
 * 有效的缩小同步范围可以在保证并发安全的前提下尽可能的提高并发效率
 * 
 * 语法：
 * synchronized(同步监视器对象){
 * 		 需要同步运行的代码片段
 * }
 * 
 * @author OldFarHigh
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop  shop = new Shop();
		
		Thread t1 = new Thread() {
			public void run() {
				shop.buy();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				shop.buy();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Shop {
	/**
	 * 直接在方法上使用synchronized，那么同步监视器对象就是当前方法所属对象，
	 * 即方法中看到的this
	 */
//	public synchronized void buy()
	public void buy() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":挑衣服");
			Thread.sleep(500);
			/*
			 * 同步块有一个要求，多个线程看到的同步监视器
			 * 对象必须是同一个！否则没有同步运行的效果
			 * 具体使用哪个对象可以结合将来实际开发需求而定。（本项目中是同一个shop对象）
			 */
			synchronized (this) {//当前类对象
				System.out.println(t.getName()+":试衣服");
				Thread.sleep(500);
			}
			
			System.out.println(t.getName()+":结帐走人");
		} catch (Exception e) {
			
		}
	}
}