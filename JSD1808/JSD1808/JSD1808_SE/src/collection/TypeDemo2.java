package collection;
/**
 * 泛型常见面试题
 * @author OldFarHigh
 *
 */
public class TypeDemo2 {
	public static void main(String[] args) {
		Type<Integer> t1 = new Type<Integer>(1,2);
		t1.setX(2);
		int x = t1.getX();
		System.out.println("x="+x);//x=2
		
		Type t2 = t1;//不指定则默认为原型Object
		t2.setX("一");//将x指向的Integer类型改为指向String类型
		/*
		 * 这里会出现造型异常Excepyion:java.lang.ClassCastException
		 */
		//x =t1.getX();//x=(Integer)ti.getX();//Excepyion:java.lang.ClassCastException
		//x = t2.getX();
		System.out.println("x="+x);
	}
}
