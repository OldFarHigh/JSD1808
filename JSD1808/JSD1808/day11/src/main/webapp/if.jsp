<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<%
		User user = new User();
		user.setGender("x");
		request.setAttribute("user", user);
	%>
	<%-- 性别:${user.gender }<br/> --%>
	性别：
	<c:if test="${user.gender == 'm'}">男</c:if>
	<br/>
	性别：
	<c:if test="${user.gender != 'm' }">女</c:if>
	<br/>
	性别：
	<c:if test="${user.gender == 'm' }" var="rs" scope="page">男</c:if>
	<c:if test="${!rs}">女</c:if>
	
</body>
</html>