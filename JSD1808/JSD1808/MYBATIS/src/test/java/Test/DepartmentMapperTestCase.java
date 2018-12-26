package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.mybatis.mapper.DepartmentMapper;
import cn.tedu.mybatis.vo.DepartmentVO;

public class DepartmentMapperTestCase {

	private AbstractApplicationContext ac;
	private DepartmentMapper departmentMapper;
	
	@Before
	public void doBefore() {
		ac = new ClassPathXmlApplicationContext(
			"spring-dao.xml");
	
		departmentMapper = ac.getBean(
			"departmentMapper", DepartmentMapper.class);
	}
	
	@After
	public void doAfter() {
		ac.close();
	}

	@Test
	public void findById() {
		Integer id = 2;
		DepartmentVO departmentVO = departmentMapper.findById(id);
		System.out.println(departmentVO);
	}
	
}