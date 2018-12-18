package dayTest_1016;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map查找表的回顾
 * @author OldFarHigh
 *put:存数据，必须key，value值同时存入。 如果key不存在,返回值为null,key值存在，会替换value值，返回值为value
 *get:获取数据，返回值为value值
 *remove:删除数据,返回值为删除的value值
 *size:返回键值对的个数
 *containsKey:判断是否含有给定key值
 *containsValues:判断是否含有给定value值
 *
 *查找表的三种遍历：
 *1、遍历所有Key值
 *2、遍历所有key和value值
 *3、遍历所有values值（不常用）
 */
public class MapDemo {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		Map<String,Integer> map1 = new TreeMap<String,Integer>();//内部排序为二叉树的TreeMap
		LinkedHashMap<String,Integer> map3 = new LinkedHashMap<String,Integer>();//哈希表和链表实现双向循环链表
		
		
		
		String str = map.put(1, "一号同学");
		map.put(2, "二号同学");
		map.put(3, "三号同学");
		map.put(4, "四号同学");
		map.put(5, "五号同学");
		System.out.println("添加："+str);
		System.out.println("操作后的查找表为："+map);//{1=一号同学, 2=二号同学, 3=三号同学, 4=四号同学, 5=五号同学}
		
		str = map.put(1, "一号老师");
		System.out.println("添加："+str);
		str = map.get(2);
		System.out.println("获取指定key值对应的value值"+str);//指定key值对应的value值二号同学
		
		str = map.remove(2);
		System.out.println("被删除的value值为:"+str);//被删除的value值为:二号同学
		System.out.println("操作后的查找表为："+map);//操作后的查找表为：{1=一号同学, 3=三号同学, 4=四号同学, 5=五号同学}
		
		int size = map.size();
		System.out.println("查找表的size为："+size);//4
		
		boolean ck = map.containsKey(1);
		System.out.println("判断给定key值是否存在查找表中："+ck);//true
		
		boolean cv = map.containsValue("二号同学");
		System.out.println("判断给定value值是否存在查找表中："+cv);//false
		
		Set<Integer> keySet =map.keySet();
		for(Integer key : keySet) {
			System.out.println("遍历的key值为："+key);
		}
		
		Set<Entry<Integer,String>>  entrySet =map.entrySet();
		for(Entry<Integer, String> entry : entrySet) {
			Integer key = entry.getKey();
			String values = entry.getValue();
			System.out.println(key+":"+values);
		}
		
		Collection<String> values = map.values();
		for(String value :values) {
			System.out.println("遍历的values值为："+value);
		}
	}

}
