<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>choose</title>
</head>
<body style="font-size:30px;">
	<%
		User user = new User();
		user.setGender("m");
		user.setAge(22);
		request.setAttribute("user", user);
	%>
	性别：
	<c:choose>
		<c:when test="${user.gender == 'm'}">男</c:when>
		<c:when test="${user.gender == 'f'}">女</c:when>
		<c:otherwise>保密</c:otherwise>
	</c:choose>
	年龄：
	<c:choose>
		<c:when test="${user.age<=18 }">少年</c:when>
		<c:when test="${user.age>=80 }">老年</c:when>
		<c:otherwise>中年</c:otherwise>
	</c:choose>
	
</body>
</html>