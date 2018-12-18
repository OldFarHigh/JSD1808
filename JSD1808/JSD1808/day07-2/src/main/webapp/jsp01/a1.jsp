<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	这是a1...<br/>
	<a href="../a2.jsp">寻找a2</a>
	<a href="<%=request.getContextPath()%>/a2.jsp">访问a2（绝对路径）</a>
</body>
</html>