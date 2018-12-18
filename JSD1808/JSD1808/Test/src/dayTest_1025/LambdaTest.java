package dayTest_1025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * lambda表达式
 * @author OldFarHigh
 *
 */
public class LambdaTest {
	public static void main(String[] args) {
		//匿名类创建比较器
		List<String> list = new ArrayList<String>();
		list.add("一");
		list.add("三四个");
		list.add("两个");
		Collections.sort(list,(o1,o2)->o1.length()-o2.length());
		System.out.println(list);
		//forEach创建
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("桃花朵朵开", 1);
		map.put("时间都去哪了", 2);
		map.put("童年", 3);
		map.forEach((k,v)->System.out.println(k+":"+v));
		
		
	}
}
