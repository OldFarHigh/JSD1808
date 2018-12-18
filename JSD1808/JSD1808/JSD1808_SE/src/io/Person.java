package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 使用该类测试对象流的对象读写操作
 * 
 * 一个类的实例若希望被对象流读写，那么必须实现接口
 * java.io.Serializable ---签名接口
 * 
 * 该接口不需要重写任何方法，但是实际上编译器在编译当前类时若发现其
 * 实现了可序列化接口时会隐含的添加一个方法
 * 作用是将当前类实例转换为一组字节，而该方法不需要体现在源代码中
 * 添加序列化版本号 serialVersionUID  影响反序列化成功与否的标志
 * @author OldFarHigh
 *
 */
public class Person implements Serializable {
	/*
	 * 当一个类实现了序列化接口后，需要定义一个常量
	 * serialVersionUID 序列化版本号
	 * 若不指定，则当前类在编译时，编译器会结合当前源代码生成一个版本号，
	 * 但这意味着当前类的源码作出改动时，版本号就会改变，而版本号影响着反序列化的结果、
	 * 当对象输入流在读取一个对象进行反序列化时，会检查该对象与当前类的版本号是否一致
	 * 一致则可以反序列化，但是不一致则会抛出异常
	 */
	private static final long serialVersionUID = 1L;
		private String name;
		private int age;
		private String gender;
		private transient String[] otherInfo;
		/*
		 * transient 
		 * 当一个属性被transient修饰后，在进行对象序列化时该属性的值会被忽略。
		 * 这意味着反序列化时的得不到该属性的值
		 * 忽略不必要的属性，可以做到对象序列化时的”瘦身“效果，减少资源开销 
		 */
		
		public Person(String name, int age, String gender, String[] otherInfo) {
			super();
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.otherInfo = otherInfo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String[] getOtherInfo() {
			return otherInfo;
		}
		public void setOtherInfo(String[] otherInfo) {
			this.otherInfo = otherInfo;
		}
		/*
		public String  toString() {
			return name+","+age+","+gender+","+Arrays.toString(otherInfo);
		}
		*/
		@Override
		public String toString() {
			return "Demo06_Person [name=" + name + ", age=" + age + ", gender=" + gender + ", otherInfo="
					+ Arrays.toString(otherInfo) + "]";
		}
		
		
	}
