package file;

import java.io.File;

/**
 * 删除一个文件
 * @author OldFarHigh
 *
 */
public class Demo_03DeleteFileDemo {
	public static void main(String[] args) {
		/*
		 * 将当前项目目录下的test.txt文件删除
		 * 在相对路径中，“./”时可以忽略不写的，
		 * 默认就是从当前目录开始的。
		 */
		File file = new File("./test.txt");
		if(file.exists()) {
			file.delete();
			System.out.println("文件已删除！");
		}else {
			System.out.println("文件不存在！");
		}
		
	}
}
