package cn.tedu.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.ajax.entity.User;
import cn.tedu.ajax.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	//业务方法，被Controller调用的方法
	//只调用自己的方法，绝不直接调用持久层对象的方法
	public Integer reg(User user) {
		//1、判断用户名是否被占用
		//根据user.getUsername()查询用户
		User data = findByUsername(user.getUsername());
		//判断查询结果是否为null
		if(data == null) {
			//是：用户名没有被占用，执行注册
			Integer rows = insert(user);
			if(rows ==1) {
				//注册成功
				return 1;
			}else {
				//注册失败
				return 3;
			}
		}else {
			//否：用户名已经被占用，返回错误代码
			return 2;
		}
		
	}
	private Integer insert(User user) {
		return userMapper.insert(user); 
	}
	
    private	 User findByUsername(String username) {
    	return userMapper.findByUsername(username);
	}
}
