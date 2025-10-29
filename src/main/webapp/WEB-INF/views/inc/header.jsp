<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<!-- header.jsp -->
<header>
	<sec:authorize access="isAnonymous()">
	<h1>Spring Security <small>Anonymous</small></h1>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
	<h1>Spring Security <small style="color: cornflowerblue;"><sec:authentication property="principal.username"/></small></h1>
	</sec:authorize>
	
	<!--
	<div>
	<sec:authentication property="principal"/>
	</div>
	
		org.springframework.security.core.userdetails.User@30f500: 
		Username: hong; 
		Password: [PROTECTED]; 
		Enabled: true; 
		AccountNonExpired: true; 
		credentialsNonExpired: true; 
		AccountNonLocked: true; 
		Granted Authorities: ROLE_MEMBER
	-->
	
	
	<ul>
		<!-- <li><a href="/java/"></a></li> -->
		<li><a href="/java/index.do">Index</a></li>
		
		<sec:authorize access="hasRole('ROLE_MEMBER')">
		<li><a href="/java/member.do">Member</a></li>
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="/java/admin.do">Admin</a></li>
		</sec:authorize>
		<li class="divider"></li>
		
		<sec:authorize access="isAnonymous()">
		<li><a href="/java/customlogin.do">Login</a></li>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
		<li><a href="/java/customlogout.do">Logout</a></li>
		</sec:authorize>
		
	</ul>
</header>