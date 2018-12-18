package cn.tedu.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {

	public static void main(String[] args) {
		//1、加载Spring配置文件，获取Spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("已经完成加载Spring配置文件！");
		//2、通过Spring获取对象
		System.out.println("准备获取对象。。。");
		Student s1 = (Student) ac.getBean("student");
		Student s2 = (Student) ac.getBean("student");
		Student s3 = (Student) ac.getBean("student");
		System.out.println("已经完成获取对象！");
		//3、执行测试
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		//4、释放资源
		System.out.println("准备释放资源。。。");
		ac.close();
		System.out.println("已经完成释放资源！");
	}

}
