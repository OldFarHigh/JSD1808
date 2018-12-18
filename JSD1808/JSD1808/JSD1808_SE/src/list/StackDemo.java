package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈： 栈可以保存一组元素，存取遵循先进后出(FILO First In Last Out)原则。
 * 使用栈一般是为了实现如“后退”这样的功能。
 * @author OldFarHigh
 *
 */
public class StackDemo {
		public static void main(String[] args) {
			Deque<String> stack = new LinkedList<String>();
			stack.push("one");
			stack.push("two");
			stack.push("three");
			stack.push("four");
			System.out.println(stack);//[four, three, two, one]
			
			String str = stack.pop();
			System.out.println(str);//four
			System.out.println(stack);//[three, two, one]
			//新循环遍历栈内的内容three
			//									two
			//									one
			for (String string : stack) {
				System.out.println(string);
			}
			//自定义循环用pop实现three
			//									two
			//									one
			while(stack.size()>0) {
				String string= stack.pop(); 
				System.out.println(string);
			}
		}
}
