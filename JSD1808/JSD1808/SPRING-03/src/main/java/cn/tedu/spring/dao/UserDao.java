package cn.tedu.spring.dao;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 通常，使用Spring管理的类都是组件类，实体类
 * @author OldFarHigh
 *
 */
@Component("userDao")
@Lazy(true)
public class UserDao {

	public UserDao() {
		System.out.println("UserDao的构造方法被执行。。");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("UserDao.init()");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("UserDao.destory()");
	}
	
	public void findUserByUsername() {
		System.out.println("UserDao.findUserByUsername()");
	}
}
