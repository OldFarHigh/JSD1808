package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 有参数的方法
 * @author OldFarHigh
 *
 */
public class LambdaDemo2 {
	public static void main(String[] args) {
		List<String> list  = new ArrayList<String>();
		list.add("柳明昆");
		list.add("骚太");
		list.add("金焘阳君");
		//匿名内部类形式创建比较器
//		Comparator<String> com = new Comparator<String>() {
//			public int compare(String o1,String o2) {
//				return o1.length()-o2.length();
//			}
//		};
//		Collections.sort(list,(o1,o2)->{
//			return o1.length()-o2.length();
//		});
//		Collections.sort(list, com);
		Collections.sort(list, (o1,o2)->o1.length()-o2.length());
		/*
		 * 如果方法只有一句代码，那么在删除“{}”的同时，
		 * 若方法要求返回值时，“return"关键字也必须省略
		 */
		System.out.println(list);
	}
}
