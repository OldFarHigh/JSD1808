package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 遍历集合元素
 * 
 * Collection提供了一个方法：
 * Iterator iterator()
 * 该方法可以获取一个用于遍历当前集合元素的迭代器。
 * 
 * java.util.Itertor接口
 * 该接口是所有迭代器的顶级接口，规定了迭代器遍历集合的统一操作。
 * 不同的集合实现类都实现了一个用于遍历自身元素的迭代器实现类。
 * 我们无需记住它们，用接口接收它们并调用相应遍历方法即可。
 * @author OldFarHigh
 *
 */
public class IteratorDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("java");
		c.add("#");
		c.add("c++");
		c.add("#");
		c.add("c");
		c.add("#");
		c.add("python");
		c.add("#");
		System.out.println("c："+c);
		/*
		 * 使用迭代器遍历集合遵循的原则
		 * 问hasNext()、取next()、删remove()
		 * 其中删除元素操作不是必须的
		 * 
		 * boolean hasNext():通过迭代器判断集合是否还有元素可以遍历
		 * 
		 * E next():获取下一个元素
		 */
		Iterator i = c.iterator();
		//一个集合中元素最好是同中类型的，取出时方便
		while(i.hasNext()) {//问：hasNex()判断是否还有元素可以取
			String str =(String) i.next();//取：有元素的话可以用next()取出元素
			System.out.println(str);
			if("#".equals(str)) {
			/*
			 *迭代器要求在遍历过程中不得使用集合的方法增删元素，否则会抛出异常
			 */
				//c.remove(str);// java.util.ConcurrentModificationException
			/*
			 * 可以通过迭代器提供的remove方法删除，通过迭代器next出来的元素
			 * 在调用remove()方法必须先next()方法迭代过元素，才能删除这个元素
			 * 并且不能再次调用remove()方法，除非再次调用next()后才可以	
			 */
				i.remove();
			}
		}
	System.out.println(c);
	}
}
