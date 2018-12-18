package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * 对象流是一对常见的高级流，作用是可以方便我们读写任何java对象
 * 
 * 对象输出流：可以将java对象转换为一组字节后写出
 * 
 * 对象输入流：可以将一组字节读入并转换为对应的对象，
 * 					  读取的字节必须是对象输出流将一个对象转换的字节。
 * @author OldFarHigh
 *
 */
public class Demo06_ObjectOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 将一个Person类型的实例写入文件person.obj
		 */
		String name = "苍老师";
		int age = 18;
		String gender = "女";
		String[] otherInfo = {"是一名演员","爱好写毛笔字","促进中日文化交流","广大男性同胞的启蒙"};
		
		Person p = new Person(name,age,gender,otherInfo);
		System.out.println(p);
		
		FileOutputStream fos = new FileOutputStream("person.obj");                                                                                                              
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		/*
		 * 对象输出流提供的特有方法：
		 * void WriteObject(Object obj);
		 * 将给定对象转换为一组字节后写出
		 * 
		 * 需要注意，该方法要求写出的对象所属类必须实现：Serializable接口，否则会抛出：
		 * NotSerializableException这个异常
		 * 
		 * 首先Person对象经过oos的writeObject方法时对象流按照Person的结构将其转换为了一组字节
		 * 而这个过程称为：对象序列化
		 * 然后这组字节再经过fos写入了文件中，那么将数据写入文件（硬盘上）
		 * 的这个过程称为：数据持久化
		 */
		oos.writeObject(p);//对象流用的写出对象的方法
		System.out.println("写出完毕！");
		
		oos.close();
	}
}
