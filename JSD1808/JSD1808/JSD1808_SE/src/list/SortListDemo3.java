package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 中文排序
 * @author soft01
 *
 */
public class SortListDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("戒色");
		list.add("戒小空");
		list.add("戒小小欲");
		list.add("戒小能");
		System.out.println(list);
		//Collections.sort(list);
		//System.out.println(list);
		sortString(list);
		
		List<Point> point = new ArrayList<Point>();
		point.add(new Point(2,3));
		point.add(new Point(4,5));
		point.add(new Point(5,6));
		point.add(new Point(6,8));
		point.add(new Point(7,9));
		point.add(new Point(6,5));
		System.out.println(point);
		/*
		 * 编译不通过，因为Collections的这个sort方法要求集合元素必须实现Comparatable接口。
		 * java提供的常用数据类型，比如包装类，字符串都实现了这个接口并定义了比较规则，所以可以直接使用。
		 * 但是我们定义的类Point并没有实现该接口。
		 * 
		 * 当我们定义的类，如：Point，它并没有实现Comparable接口，
		 * 若我们想使用该sort方法排序，就需要实现这个接口，并重写其中的比较方法，
		 * 但是这样做是不推荐的，因为这样做具有侵入性，写程序时应当尽量避免侵入性，
		 * 这样有利于程序的扩展和重构。
		 * 
		 * 所谓侵入性指的是：
		 * 当我们使用某个功能方法时，除了调用该功能方法的语句之外，
		 * 该功能方法要求我们为其额外的添加其他的代码，
		 * 比如这里要求Point类实现接口并重写方法，
		 * 那么这时该功能就对我们的程序具有侵入性。
		 */
		//Collections.sort(point);
		//System.out.println(point);
		sortPoint(point);
	}
	/**
	 * Collections 的重载sort方法，由于可以传入一个额外的比较规则，
	 * 所以这个sort方法不强制要求元素必须实现Comparable接口
	 * @param list
	 */
public static void sortPoint(List<Point> list) {
	Collections.sort(list, new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			int len1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
			int len2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();

			return len1 - len2;
		}
//		Comparator<Point> comparator = new  Comparator<Point>() {
//
//			@Override
//			public int compare(Point o1, Point o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		};
	});
	System.out.println("排序为："+list);
}
	/**
	 *利用Collections重载的sort方法，额外的传入一个比较规则（Comparator比较器实现类）
	 *来对已经实现了Comparable接口并定义了比较规则的元素按照我们定义的比较规则重新排序。
	 *@param list
	 */
public static void sortString(List<String> list) {
	/*
	 * 定义额外的比较规则
	 * 为字符串提供了一种比较规则：字符少的小，字符多的大
	 */

	Collections.sort(list,new Comparator<String>() {
		/**
		 * 该方法是用来定义o1与o2比较大小的规则
		 * 而返回值是一个int值，该值不关注具体取值，只关注取值范围：
		 * 当返回值>0:表示o1大于o2;
		 * 当返回值<0:表示o1小于o2;
		 * 当返回值=0:表示o1等于o2;
		 * 
		 */
		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
		});
	System.out.println("自定义排序效果："+list);
}
}
