package com.test.java.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//11. 로그인 성공 → 후속 동작 구현
		System.out.println("CustomLoginSuccessHandler 호출됨");
		
		//모든 사용자 -> 시작 페이지로 이동(index.do)
		//response.sendRedirect("/java/index.do");
		
		//권한별 제어
		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(authority -> {
			//System.out.println(authority);
			roleNames.add(authority.getAuthority());
		});
		
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/java/admin.do");
			return;
		}
		
		if (roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/java/member.do");
			return;
		}
		
		response.sendRedirect("/java/index.do");
		
	}

}
