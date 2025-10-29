<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
	<!-- member.jsp -->
	<%@ include file = "/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Member Page</h2>
	<p>회원만 접근 가능합니다.</p>
	
	<h3>회원 정보</h3>
	<div class="message" title="principal">
		<sec:authentication property="principal"/>
	</div>
	<div class="message" title="사용자 아이디">
		<sec:authentication property="principal.username"/>
	</div>
	<div class="message" title="사용자 권한">
		<sec:authentication property="principal.authorities"/>
	</div>
	
</body>
</html>