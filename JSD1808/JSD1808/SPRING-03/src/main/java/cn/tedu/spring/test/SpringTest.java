package cn.tedu.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.spring.dao.UserDao;
import cn.tedu.spring.service.UserService;
/**
 * 通用注解共4个，其功能、用法都是完全相同的只是表达的语义不同，
 * @author OldFarHigh
 *
 */

public class SpringTest {
	
	public static void main(String[] args) {
		
		//1、添加spring配置文件，获取spring容器
		System.out.println("准备加载Spring的配置文件。。。");
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("完成加载Spring的配置文件！");
		//2、获取对象
		System.out.println("准备获取对象。。。");
		UserDao dao = (UserDao) ac.getBean("userDao");
		UserDao dao1 = (UserDao) ac.getBean("userDao");
		UserDao dao2 = (UserDao) ac.getBean("userDao");
		UserDao dao3 = (UserDao) ac.getBean("userDao");
		UserService service = (UserService) ac.getBean("userService");
		UserService service1 = (UserService) ac.getBean("userService");
		service.login();
		System.out.println("获取对象完毕！");
		//3、测试输出
		System.out.println("dao:"+dao);
		System.out.println("dao1:"+dao1);
		System.out.println("dao2:"+dao2);
		System.out.println("dao3:"+dao3);
		System.out.println("service:"+service);
		System.out.println("service1:"+service1);
		//4、释放资源
		System.out.println("准备释放资源。。。");
		ac.close();
		
	}
}
