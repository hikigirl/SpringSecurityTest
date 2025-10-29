<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
	<!-- customlogin.jsp -->
	<%@ include file = "/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Login Page(Custom)</h2>
	<form action="/java/login" method="POST">
	<table class="vertical content">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="username" required="required"/></td>
		</tr>
		<tr>
			<th>암호</th>
			<td><input type="password" name="password" required="required"/></td>
		</tr>
	</table>
	<div>
		<button class="in">로그인</button>
	</div>
	<!-- 9-2. CSRF 토큰: 지금 POST(PUT, PATCH, DELETE) 요청은 내가 직접 한다는 것을 알려줌 -->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>