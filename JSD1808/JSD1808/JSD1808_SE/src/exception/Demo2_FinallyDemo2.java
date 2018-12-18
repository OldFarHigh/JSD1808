package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 在IO操作中使用异常处理机制
 * 
 * @author OldFarHigh
 *
 */
public class Demo2_FinallyDemo2 {
	public static void main(String[] args) {
		FileOutputStream fos =null;//声明文件流
		try {
			fos = new FileOutputStream("fos.dat");//创建文件
			fos.write(1);//文件写入
		}catch(Exception e){//处理异常
			System.out.println("出错了！");
		}finally {
			try {
				if(fos!=null) {//文件不为空
					fos.close();//关闭文件
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} 
	
}
