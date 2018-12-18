package file;

import java.io.File;

/**
 * 创建一个目录
 * @author OldFarHigh
 *
 */
public class Demo_04MKDirDemo {
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建一个名为demo的目录
		 */
		File dir = new File("demo");
		if(!dir.exists()) {
			dir.mkdir();	//创建该目录
			System.out.println("目录已创建！");
		}else {
			System.out.println("目录已存在！");
		}
		boolean ih = dir.isHidden();
		System.out.println("是否隐藏："+ih);
	}
}
