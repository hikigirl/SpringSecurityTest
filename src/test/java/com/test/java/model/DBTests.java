package com.test.java.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBTests {
	//인터페이스 매퍼 테스트
	@Autowired
	private SecurityMapper mapper;
	@Test
	public void testCreateMapper() {
		assertNotNull(mapper);
		System.out.println(mapper.time());
		
	}
}
