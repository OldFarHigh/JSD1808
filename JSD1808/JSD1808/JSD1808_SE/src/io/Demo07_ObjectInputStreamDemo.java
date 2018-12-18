package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象输入流
 * @author OldFarHigh
 *
 */
public class Demo07_ObjectInputStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		 * 读取person.obj文件，将其中的对象读取回来
		 */
		FileInputStream fis = new FileInputStream("person.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		/*
		 * 对象输入流在读取了一组字节后按照其表示的结构将其还原为对象的过程称为：对象的反序列化
		 * 
		 * 
		 * ObjectInputStream 读取对象数据时，
		 * Object readObject() 返回值时Object 需要向下转型才能使用
		 * 还会抛出异常，要用ClassNotFoundException接收
		 */
		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
	}
}
