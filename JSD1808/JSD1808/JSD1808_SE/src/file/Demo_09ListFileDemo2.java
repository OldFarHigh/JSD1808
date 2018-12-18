package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 重载的ListFiles方法，允许我们传入一个文件过滤器
 * 然后将目录中满足过滤器要求的子项返回
 * @author OldFarHigh
 *
 */
public class Demo_09ListFileDemo2 {
	public static void main(String[] args) {
		/*
		 * 获取当前目录下所有名字以“.”开头的子项
		 */
		File dir = new File(".");
		/*
		 * FileFilter 文件过滤器
		 */
		FileFilter filter = new FileFilter() {//调用文件过滤器接口
			public boolean accept(File file) {
				String name = file.getName();
				System.out.println("正在过滤："+name);
				return name.startsWith(".");//用startsWith发明方法过滤
			}
		};//匿名内部类
			/*
			 * 我们将文件过滤器传递给listFiles方法，在当前代码中看似没有显示的调用过文件过滤器的accept方法
			 * 但是实际上listFiles方法在执行过程中会回调我们传递的文件过滤器的accept方法来完成其操作
			 * 而这种开发模式称为：回调模式
			 * java 23种设计模式之一
			 */
		File[] subs = dir.listFiles(filter);
		System.out.println(subs.length);
		for (int i = 0; i < subs.length; i++) {
			System.out.println(subs[i].getName());
		}
		
	}
}
