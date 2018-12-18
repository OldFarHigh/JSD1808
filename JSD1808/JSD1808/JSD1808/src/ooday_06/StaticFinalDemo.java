package ooday_06;
//static final����
public class StaticFinalDemo {
	public static void main(String[] args) {
		System.out.println(Aoo.PI); //����������������
		//Aoo.PI = 3.1415926; //������󣬳������ܱ��ı�
		
		//1)����Boo.class����������
		//2)��̬����num�洢����������
		//3)���������л�ȡnum��ֵ�����
		System.out.println(Boo.num);
		
		//�������ڱ���ʱ������ֱ���滻Ϊ���������Ч�ʸ�
		//�൱��System.out.println(5);
		System.out.println(Boo.COUNT);
		
	}
}

class Boo{
	public static int num = 5; //��̬����
	public static final int COUNT = 5; //����
}


class Aoo{
	public static final double PI = 3.1415926;
	//public static final int COUNT; //������󣬳�����������ͬʱ��ʼ��
}



































