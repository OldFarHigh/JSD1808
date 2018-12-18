package dayTest_1201;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection
 * 集合框架
 * Collection接口是所有集合的顶级接口。规定了所有集合都应当具备的功能
 * 其下常见的分类：
 * java.util.list:可重复的集合，有序集
 * java.util.set:不可重复的集合
 * 重复指的是元素是否重复，而标准是元素自身equals比较的结果
 * @author OldFarHigh
 *
 */
public class CollectioonDemo01 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		/*
		 * boolean add(E e)
		 * 向当前集合中添加给定元素，成功添加则返回true； 
		 */
		c.add("一闪一闪亮晶晶");
		c.add("满天都是小星星");
		c.add("挂在天上放光明");
		c.add("好像天上的小眼睛");
		System.out.println(c);
		/*
		 * int size()
		 * 返回当前集合的元素个数
		 */
		int size = c.size();
		System.out.println(size);
		/*
		 * boolean isEmpty();
		 * 判断集合是否为空
		 */
		boolean b =c.isEmpty();
		System.out.println("isEmpty:"+b);
		/*
		 * clear()
		 * 清空集合
		 */
		c.clear();//清空集合元素
		size = c.size();
		System.out.println(size);
		b=c.isEmpty();
		System.out.println(b);
		
	}
}
