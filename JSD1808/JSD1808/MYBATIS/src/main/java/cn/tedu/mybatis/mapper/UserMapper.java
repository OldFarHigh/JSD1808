package cn.tedu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.mybatis.entity.User;

/**
 * 通常接口文件的数量与xml映射文件的数量是相同的，是一一对应的！
 * @author OldFarHigh
 *使用myBaties执行的增删改操作均返回`Integer`，表示受影响的行数
 *
 *功能：
 *
 *业务：
 */
public interface UserMapper {
	Integer insert(User user);
	
	List<User> findAll();
	
	User findByUsername(String username);
	
	Integer getCount();
	
	Integer del(String username);
	
	Integer updatePasswordByAge(@Param("age") Integer age, @Param("password") String password);
	
	List<User> findAllOrderedList(@Param("where") String where,@Param("orderBy") String orderBy);
	
	Integer deleteByIds(Integer[] ids);
}
