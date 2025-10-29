package com.test.java.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	//8-1. AccessDeniedHandler를 직접 구현
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// 403 발생 -> handle() 호출
		// 403 에러 발생과 연관된 여러가지 업무 처리
		System.out.println("403 에러 관련 처리 진행");
		
		response.sendRedirect("/java/accesserror.do");
	}

}
