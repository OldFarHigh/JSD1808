package cn.tedu.spring;

//通过构造方法注入属性的值
public class User {

	public String name;
	public String from;
	
	public User(String name,String from) {
		super();
		this.name = name;
		this.from = from;
	}
}
