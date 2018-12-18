<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">

	username:<%=request.getParameter("username") %>
	<br/>
	username:${param.username }<br/>
	
	city:<%
	
	String[] city=request.getParameterValues("city"); 
	if(city != null){
		for(String str :city){
			out.println(str+"<br/>");
		}
	}
	%>
	<br/>
	city:${paramValues.city[0]}<br/>
	<c:forEach  items="${paramValues.city}" var="s" >
		${s}
	</c:forEach>
	
	
</body>
</html>