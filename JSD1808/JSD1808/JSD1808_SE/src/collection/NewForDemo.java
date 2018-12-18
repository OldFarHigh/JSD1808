package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK5推出时，推出了一个新的特性
 * 增强型for循环，也称为新循环，for each
 * 
 * 新循环不取代传统循环的工作，只用来遍历集合或数组
 * 
 * 注：新循环的语法jJVM不认可，而只是编译器认可。
 * 编译器在编译源程序时会将新循环遍历改为传统方式遍历
 * 
 *语法：
 *for(元素类型 e： 集合或数组){
 *			循环体
 *}
 * @author OldFarHigh
 *
 */
public class NewForDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("java");
		c.add("c++");
		c.add("c");
		c.add("python");
		System.out.println("Collection："+c);
		System.out.println("我是可爱的分界线=======================我是可爱的分界线");
		Iterator it  = c.iterator();//迭代器遍历
		while (it.hasNext()) {//问：
			String str = (String)it.next();//取：
			//删it.remove()
			System.out.println("Collection1："+str);
		}
		System.out.println("我是可爱的分界线=======================我是可爱的分界线");
		/*
		 * 新循环遍历集合就是迭代器集合，所以在遍历的过程中不要通过集合的方法增删元素，否则会抛出异常
		 */
		for (Object o : c) {//增强型for循环
			String str = (String)o;
			System.out.println("Colleciton3："+str);
		}
		System.out.println("我是可爱的分界线=======================我是可爱的分界线");
		String[] array = {"1","2","3","4"};
		for (int i = 0; i < array.length; i++) {//传统循环遍历数组
			String str = array[i];
			System.out.println("array1："+str);
		}
		System.out.println("我是可爱的分界线=======================我是可爱的分界线");
		//实际上编译器会将新循环遍历数组改为传统for循环形式遍历
		for (String string : array) {//增强型循环遍历数组
			System.out.println("array2："+string);
		}
			}
}
