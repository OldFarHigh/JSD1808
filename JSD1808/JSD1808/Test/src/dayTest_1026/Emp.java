package dayTest_1026;



public	class Emp{
	public static void main(String[] args) {
		Thread t = new Thread(new Thread1());
		t.start();
		}
		}
		class Thread1 implements Runnable{
		public void run() {
		System.out.println("haha");
		}
		}
	
		




