package file;

import java.io.File;

/**
 * listFiles()
 * 获取一个目录中的所有子项
 * @author OldFarHigh
 *
 */
public class Demo_07ListFilesDemo {
	public static void main(String[] args) {
		/*
		 * 获取当前目录中的所有子项
		 */
		File dir = new File(".");//获取路径
		/*
		 * boolean isFile() 判断是否为文件
		 * boolean isDirectory() 判断是否为目录
		 */
		if(dir.isDirectory()) {
			File[] subs = dir.listFiles();//装载当前对象路径下的目录列表到目录数组中
			for (int i = 0; i < subs.length; i++) {
				System.out.println(subs[i].getName());
				
			}
		}
	}
}
