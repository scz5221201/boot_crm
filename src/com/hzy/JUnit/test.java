package com.hzy.JUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hzy.core.po.BaseDict;
import com.hzy.core.service.BaseDictService;
import com.hzy.core.service.impl.BaseDictServiceImpl;

public class test {
	@Test
	public void test() {
		
//		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
//		JdbcTemplate jdbcTemplate=(JdbcTemplate) applicationContext.getBean("jdbcTemplate");
//		jdbcTemplate.execute("select * from base_dict where dict_type_code=?");
		
		BaseDictServiceImpl baseDictServiceImpl = new BaseDictServiceImpl();
		List<BaseDict> list = baseDictServiceImpl.findBaseDictByTypeCode("001");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
