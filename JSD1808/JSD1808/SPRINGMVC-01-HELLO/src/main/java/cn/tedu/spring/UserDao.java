package cn.tedu.spring;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author OldFarHigh
 *
 */
@Repository
public class UserDao {

	public UserDao() {
		System.out.println("已经加载Spring配置文件！");
	}
	
}
