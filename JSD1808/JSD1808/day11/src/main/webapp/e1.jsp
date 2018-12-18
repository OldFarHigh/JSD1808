<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>e1</title>
</head>
<body style="font-size:30px;">
		<%
			User user = new User();
			user.setUsername("King");
			user.setAge(22);
			user.setInterest(new String[] {"cooking","fishing"});
			request.setAttribute("user",user);
			
			User user2 = new User();
			user2.setUsername("Eric");
			user2.setAge(33);
			session.setAttribute("user",user2);
		%>
		
		<!-- username: -->
		<%
			//User user1=(User)request.getAttribute("user1");
			//out.println(user1.getUsername());
		%>
		<br/>
		
		username:${user.username}<br/>
		指定查找范围：${sessionScope.user.username}<br/>
		username:${user['username']}<br/>
		
		<%
			pageContext.setAttribute("s1","age");
		%>
		age:${user[s1]}<br/>
		age:${user[requestScope.s1]}
		<br/>
		
		interest:${user.interest[0]}<br/>
		<c:forEach items="${user.interest}" var="i">${i}<br/></c:forEach>
</body>
</html>