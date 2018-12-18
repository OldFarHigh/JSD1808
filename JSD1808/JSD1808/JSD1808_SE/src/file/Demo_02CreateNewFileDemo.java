package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建文件，创建的文件所在的目录必须存在，否则会抛出异常。
 * @author OldFarHigh
 *
 */
public class Demo_02CreateNewFileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录下创建名为：tets.txt的文件
		 */
		File file = new File("./test.txt");//创建文件对象File和抽象路径
		/*
		 * boolean exists()
		 * 判断当前File表示的文件或目录是否已经存在
		 */
		if(!file.exists()) {//判断文件是否不存在
			file.createNewFile();
			/*执行创建文件操作
			 * 需要注意，创建的文件所在的目录必须存在，
			 * 否则会抛出异常。
			 */
			System.out.println("文件已创建！");
		}else {
			System.out.println("文件已存在！");
		}
	}
}
