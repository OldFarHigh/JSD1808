<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="a6.jsp"%>
<html>
<head>
<title>a5</title>
</head>
<body style="font-size:30px;">
	<!-- http://ip:port/day11/a5.jsp?number=100 -->
	<%
		String number = request.getParameter("number");
		
		Integer.parseInt(number);
	%>
</body>
</html>