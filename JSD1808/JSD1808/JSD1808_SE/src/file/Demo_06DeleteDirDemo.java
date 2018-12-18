package file;

import java.io.File;

/**
 * 删除目录
 * @author OldFarHigh
 *
 */
public class Demo_06DeleteDirDemo {
	public static void main(String[] args) {
		/*
		 * 将当前目录下的text目录删除
		 */
		File dir = new File("text");
		if(dir.exists()) {
			/*
			 * delete方法在删除目录时要求该目录必须是一个空目录
			 */
			dir.delete();
			System.out.println("删除！");
		}else {
			System.out.println("不存在！");
		}
	}
}
