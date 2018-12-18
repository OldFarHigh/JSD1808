package ooday_05;
public class Aoo {
	public int a;    //
	protected int b; //
	int c;           //
//	private int d;   //
	void show() {
		a = 1;
		b = 2;
		c = 3;
//		d = 4;
	}
}

class Boo{ //----------------
	void show() {
		Aoo o = new Aoo();
		o.a = 1;
		o.b = 2;
		o.c = 3;
		//o.d = 4;
	}
}













