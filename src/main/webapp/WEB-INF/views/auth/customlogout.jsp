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
	<!-- customlogout.jsp -->
	<%@ include file = "/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Logout Page(Custom)</h2>
	<form action="/java/customlogout.do" method="POST">
	
	<div>
		<button class="out">로그아웃</button>
	</div>
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>