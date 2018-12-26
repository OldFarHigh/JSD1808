package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.mybatis.mapper.ScoreMapper;
import cn.tedu.mybatis.vo.ScoreVO;

public class ScoreTestCase {
	
	private AbstractApplicationContext ac;
	private ScoreMapper scoreMapper;
	@Before
	public void doBefore() {
		ac = new ClassPathXmlApplicationContext(
			"spring-dao.xml");
	
		scoreMapper = ac.getBean("scoreMapper", ScoreMapper.class);
	}
	
	@After
	public void doAfter() {
		ac.close();
	}
	@Test          
	public void findByStuId() {
		Integer id=2;
		ScoreVO scorevo = scoreMapper.findByStuId(id);
		System.out.println(scorevo);
	}
}
