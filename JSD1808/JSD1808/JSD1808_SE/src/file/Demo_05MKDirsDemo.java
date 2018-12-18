package file;

import java.io.File;

/**
 * 创建一个多级目录
 * @author OldFarHigh
 *
 */
public class Demo_05MKDirsDemo {	
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建a/b/c/d/e/f目录
		 */
		File dir = new File("a/b/c/d/e/f");
		if(!dir.exists()) {
			/*
			 * mkdir()方法要求创建的目录所在的父目录必须存在
			 * mkdirs()方法则会将不存在的父目录一起创建出来
			 */
			dir.mkdirs();
			System.out.println("创建！");
		}else {
			System.out.println("存在！");
		}
	}
}
