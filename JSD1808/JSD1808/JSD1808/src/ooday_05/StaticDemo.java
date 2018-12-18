package ooday_05;

public class StaticDemo {
	public static void main(String[] args) {
		Loo o1 = new Loo();
		o1.show();
		Loo o2 = new Loo();
		o2.show();
		System.out.println(Loo.b); //
		
		Moo.test(); //ͨ
		
//		Noo o3 = new Noo();
//		Noo o4 = new Noo();
//		Noo o5 = new Noo();
		
	}
}
class Noo{ //
	static {
		System.out.println("��̬��");
	}
	Noo(){
		System.out.println("���췽��");
	}
}

















class Moo{ //��ʾ��̬����
	int a;
	static int b;
	void show() { //��this
		System.out.println(this.a);
		System.out.println(Moo.b);
	}
	static void test() { //û��this
		//��̬����û����ʽ��this����
		//û��this��ζ��û�ж���
		//��ʵ������a����ͨ�������������
		//System.out.println(a); //�������
		System.out.println(Moo.b);
	}
}


















class Loo{ //��ʾ��̬����
	int a;
	static int b;
	Loo(){
		a++;
		b++;
	}
	void show() {
		System.out.println(a+","+b);
	}
}























