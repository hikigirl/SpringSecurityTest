package com.test.java.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
public class AddMember {
	
	//의존 주입의 타입 -> 인터페이스 + 상속 구현한 클래스 2개 이상
	//1. @Qualifier
	//2. 딱 1개의 클래스만 구현하고, 나머지는 삭제
	@Autowired
	//@Qualifier("bCryptPasswordEncoder")
	private PasswordEncoder encoder;
	
	@Test
	public void testEncoder() {
		assertNotNull(encoder); //fail
//		No qualifying bean of type
//		'org.springframework.security.crypto.password.PasswordEncoder' available:
//		expected single matching bean but found 2:
//		customNoOpPasswordEncoder,bCryptPasswordEncoder
		String pw = "1111";
		System.out.println("[ENCODED PASSWORD] " + encoder.encode(pw));
		//[ENCODED PASSWORD] $2a$10$EZYPKidxGV0Y5Cr3WIJ/o..AB5MjcIk2XJL0DuaIbcRYoARSDukwy
	}
}
