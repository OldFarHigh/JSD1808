<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	这是a2...<br/>
	<a href="jsp01/a1.jsp">寻找a1</a>
	<a href="<%=request.getContextPath()%>/jsp01/a1.jsp">访问a1（绝对路径）</a>
</body>
</html>