package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map的遍历
 * Map提供了三种遍历方式
 * 1：遍历所有的key
 * 2：遍历所有的键值对（Entry）
 * 3：遍历所有的value  （相对不常用）
 * @author OldFarHigh
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
	//	Map<String,Integer> map = new HashMap<String,Integer>();
		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		/*
		 * V put(Key key,Value value)
		 * 添加key 和 value
		 */
		map.put("语文",100);
		map.put("数学", 90);
		map.put("英语", 98);
		map.put("物理", 99);
		map.put("化学", 92);
		System.out.println(map);
		/*
		 * 遍历所有的key
		 * Set<K> keySet()
		 * 将当前Map中所有的key以一个Set集合形式返回遍历该集合等同于遍历了所有的key
		 */
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println("key："+key);
		}
		/*
		 * 遍历每一组键值对
		 * Set<Entry>  entrySet()
		 * 
		 * java.util.Map.Entry
		 * Entry的每一个实例用于表示当前Map的一组键值对器有两个常用方法
		 * getKey,getValue
		 */
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> e : entrySet) {
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		/*
		 * 遍历所有的value值(相对不常用)
		 */
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println("value:"+value);
		}
	}
}
