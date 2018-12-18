package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection
 * 
 * 集合框架
 * Collection接口是所有集合的頂級接口，規定了所有集合都應當具備的功能
 * 其下常見的分類：
 * java.util.List:可重複集合，有序集
 * java.util.Set:不可重複集合
 * 重複指的是元素是否重複，而標準是元素自身equals比較的結果
 * @author OldFarHigh
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection<String>c = new ArrayList<String>();
		/*
		 * boolean add(E e)
		 * 向當前集合中添加給定元素，成功添加則返回true
		 */
		
		c.add("有人問我你究竟是哪裏好");
		c.add("這麼多年我還忘不掉");
		c.add("春風再美也比不上你的笑");
		c.add("沒見過你的人不會明了");
		System.out.println(c);
		/*
		 * int size()
		 * 返回當前集合的元素個數
		 */
		int size = c.size();//集合的元素個數
		System.out.println("size:"+size);
		/*
		 * boolean isEmpty()
		 * 判斷集合是否爲空集（不含有任何元素）
		 */
		boolean isEmpty = c.isEmpty();
		System.out.println("isEmpty:"+isEmpty);
		
		c.clear();//清空集合元素
		System.out.println("集合已清空");
		System.out.println(c);
		System.out.println("size:"+c.size());
		isEmpty = c.isEmpty();
		System.out.println("isEmpty:"+isEmpty);
		
		
		
		
	}
}
