package dayTest_1201;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合操作
 * boolean addAll(Collection<? extends E> c ):将给定集合中的所有元素添加到当前的元素中
 * boolean containsAll(Collection<?> c ):判断当前集合是否包含给定集合的所有元素
 * boolean removeAll(Collection<?> c):从当前集合中删除与给定集合共有的所有元素
 * @author OldFarHigh
 *
 */
public class CollectionTest03 {
	public static void main(String[] args) {
		Collection<String> c1 = new ArrayList<String>();
		c1.add("醒来明月，醉时春风");
		c1.add("酒肉穿肠过");
		c1.add("佛祖心中留");
		c1.add("世人若学我");
		c1.add("如同入魔道");
		System.out.println("c1:"+c1);
		
		Collection<String> c2 = new ArrayList<String>();
		c2.add("酒肉穿肠过");
		c2.add("佛祖心中留");
		System.out.println("c2:"+c2);
		
		/*c1.addAll(c2);
		System.out.println("c1:"+c1);*/
		/*c1.removeAll(c2);
		System.out.println("c1:"+c1);*/
		boolean b = c1.containsAll(c2);
		System.out.println("boolean:"+b);
		
		
		
		
		
		
	}
}
