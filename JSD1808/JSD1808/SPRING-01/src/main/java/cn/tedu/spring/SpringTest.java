package cn.tedu.spring;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		// 加载Spring的配置文件，获取Spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 通过Spring容器获取对象
		Date date = (Date) ac.getBean("date");
		User user = (User) ac.getBean("user");
		Calendar calendar = (Calendar) ac.getBean("calendar");
		HuaWeiPhone huaweiphone = (HuaWeiPhone) ac.getBean("huaweiphone");
		Car car = (Car) ac.getBean("car");
		// 测试输出
		System.out.println(date);
		System.out.println(user);
		System.out.println(calendar);
		System.out.println(huaweiphone);
		System.out.println(car);
		//释放资源
		ac.close();
	}
	
}





