<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<%
		Employee emp = new Employee();
		emp.setEname("Tom");
		emp.setSalary(10000);
		emp.setAge(10);
		request.setAttribute("emp", emp);
	%>
	ename:${emp.ename}<br/>
	salary:${emp.salary}<br/> 
	age:${emp.age }<br/>
	<br>
	<%
		Employee emp1 = new Employee();
		emp1.setEname("Jerry");
		emp1.setSalary(200);
		emp1.setAge(20);
		pageContext.setAttribute("emp", emp1);
	%>
	ename:${pageScope.emp.ename}<br/>
	salary:${pageScope.emp.salary}<br/> 
	age:${pageScope.emp.age }<br/>
</body>
</html>