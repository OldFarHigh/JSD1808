package cn.tedu.spring;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		// 加载Spring的配置文件，获取Spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 通过Spring容器获取对象
		/*UserDao userDao = (UserDao) ac.getBean("userDao");*/
		User user = (User) ac.getBean("user");
		UserService userService = (UserService) ac.getBean("userService");
		SampleBean sampleBean = (SampleBean) ac.getBean("sampleBean");
		ValueBean valueBean = (ValueBean)ac.getBean("valueBean");
		// 测试输出
	/*	System.out.println("userdao.username:"+userDao.username);
		System.out.println("userdao.password:"+userDao.password);*/
		System.out.println(user.name);
		System.out.println(user.from);
		userService.reg();
		System.out.println("注入的List属性的值："+sampleBean.getNames());
		System.out.println("注入的List属性的值："+sampleBean.getNames().getClass());
		System.out.println("注入的Set属性的值："+sampleBean.getCities());
		System.out.println("注入的Set属性的值："+sampleBean.getCities().getClass());
		System.out.println("注入的Map属性的值："+sampleBean.getSession());
		System.out.println("注入的Map属性的值："+sampleBean.getSession().getClass());
		System.out.println("注入的properties属性的值："+sampleBean.getDbConfig());
		
		
		System.out.println("测试spring表达式："+valueBean.getName());
		System.out.println("测试spring表达式："+valueBean.getPassword());
		
		//释放资源
		ac.close();                   
	}
	
}





