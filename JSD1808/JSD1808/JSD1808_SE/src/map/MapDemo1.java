package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map  查找表
 * Map体现的结构是一个多行两列的表格
 * 左列名为key，右列名为value
 * value是保存要查找的值，而对应的key是查询条件
 * 
 * 在一个Map中key是不允许重复的
 * 
 * 常用实现类：java.util.HashMap也称为散列表或哈希表
 * 当今世界上查询速度最快的数据结构。
 * @author OldFarHigh
 * 
 *V put(K k ,V v)
 * 将给定的Key - Value对保存在Map中
 * 
 * V get(Object key)
* 根据给定的可以获取对应的value，若给定的key不存在，则返回值为null
* 
*  V remove(Object key)
* 将给定的key所对应的键值对删除，删除后会将该key对应的value返回。
* 
* int size()  :返回键值对的个数
* 
* boolean containsKey(Object key)
* 若Map中包含给定的key则返回true，否则返回false。
* boolean containsValue(Object value)
* 若Map中包含给定的value则返回true，否则返回false.
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer>  map  = new HashMap<String,Integer>();
		
		/*
		 * 	V put(K k ,V v)
		 * 将给定的Key - Value对保存在Map中
		 * 
		 * 由于Map要求key不允许重复，那么当使用一个已有的key保存新的value时，那么是做替换value操作
		 * 这时put方法会将被替换的value返回。否则返回值为null
		 * 注：若value是包装类类型时，接收put方法返回值时要使用包装类类型而不要用基本类型，
		 * 避免因为自动拆箱导致空指针出现。
		 */
		Integer num = map.put("小学", 100);
		System.out.println(num);//null
		map.put("幼儿园", 99);
		map.put("初中", 95);
		map.put("高中", 90);
		map.put("大学", 70);
		
		System.out.println(map);//{大学=70, 幼儿园=99, 高中=90, 初中=95, 小学=100}
		
		num = map.put("小学", 99);
		System.out.println(num);//null
		/*
		 * V get(Object key)
		 * 根据给定的可以获取对应的value，若给定的key不存在，则返回值为null
		 */
		num = map.get("小学");
		System.out.println("小学的值为："+num);//99
		num = map.get("社会");
		System.out.println("社会的值为："+num);//null
		/*
		 * V remove(Object key)
		 * 将给定的key所对应的键值对删除，删除后会将该key对应的value返回。
		 */
	    num   = 	map.remove("大学");
	    System.out.println(num);//70
	    System.out.println(map);//{幼儿园=99, 高中=90, 初中=95, 小学=99}
		//int size()  :返回键值对的个数
	    int size = map.size();
	    System.out.println("键值对个数size:"+size);//键值对个数size:4
		/*
		 * boolean containsKey(Object key)
		 * 若Map中包含给定的key则返回true，否则返回false。
		 * boolean containsValue(Object key)
		 * 若Map中包含给定的value则返回true，否则返回false.
		 */
		boolean b =map.containsKey("小学"); 
		System.out.println(b);//true
		
		b = map.containsValue(90);
		System.out.println(b);//true
		
		/*
		 * V
		 */
		
	}
}
