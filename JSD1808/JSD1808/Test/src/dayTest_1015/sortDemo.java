package dayTest_1015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 1、List集合的排序（基本类型的排序）
 * 2、重载sort方法实现中文字符的排序
 * @author OldFarHigh
 *
 */
public class sortDemo {
	public static void main(String[] args) {
		//对String字符串类型的List集合排序
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("Two");
		list.add("Three");
		list.add("four");
		System.out.println(list);//[one, Two, Three, four]
		Collections.sort(list);//对字符串排序，就是对首自符的unicode编码进行比较首自符相同就比较第二个，依次类推
		System.out.println(list);//[Three, Two, four, one]
		//对int值类型数据的list集合排序
		Random random = new Random();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i <10; i++) {
			list2.add(random.nextInt(100));//将0-99随机数添加进List集合
		}
		System.out.println(list2);//[81, 67, 32, 3, 14, 46, 54, 15, 2, 58]
		Collections.sort(list2);//
		System.out.println(list2);//[2, 3, 14, 15, 32, 46, 54, 58, 67, 81]
		//中文字符的排序比较：字符串短的小，字符串长的大
		List<String> list3 = new ArrayList<String>() ;
		list3.add("两只老虎");
		list3.add("两只老虎");
		list3.add("跑得快");
		System.out.println(list3);
		sortString(list3);
	}
public static void sortString(List<String> list) {
		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {	
				return o1.length()-o2.length();
			}
		});
		System.out.println("自定义排序为："+list);
		
 	}
}
