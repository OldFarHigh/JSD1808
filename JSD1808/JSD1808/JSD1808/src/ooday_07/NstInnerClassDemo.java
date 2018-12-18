package ooday_07;

public class NstInnerClassDemo {
	public static void main(String[] args) {
		//1)������Aoo��һ�������࣬����û������
		//2)Ϊ�������ഴ����һ��������Ϊo1
		//3)�������е�Ϊ�����������
//		Aoo o1 = new Aoo() {
			
		};
		
		//1)������Aoo��һ�������࣬����û������
		//2)Ϊ�������ഴ����һ��������Ϊo2
		//3)�������е�Ϊ�����������
		Aoo o2 = new Aoo() {
			
		};
		
		int num = 5;
		//1)������Boo��һ�������࣬����û������
		//2)Ϊ�������ഴ����һ��������Ϊo3
		//3)�������е�Ϊ�����������
		Boo o3 = new Boo() {
			void show() {
				System.out.println("showshow");
				System.out.println(num); //jdk1.8֮ǰ��Ҫ��num������final��
			}
		};
//		o3.show();
		
	}
//}

abstract class Boo{
	abstract void show();
}

abstract class Aoo{
}





























