package com.test.java.auth;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomNoOpPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		// 사용자가 입력한 암호 - 암호화 - 반환
		System.out.println("원래 암호: " + rawPassword);
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// 사용자가 입력한 암호 vs 인코딩된 암호 비교
		System.out.println("암호 비교: " + rawPassword + ", " + encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}

}
