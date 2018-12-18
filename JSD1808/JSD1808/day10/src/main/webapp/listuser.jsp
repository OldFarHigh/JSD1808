<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据列表</title>
</head>
<body style="font-size:30px;">
	<%
		List<User> users = (List<User>)application.getAttribute("users");
	%>
	<table border="1" width="60%" cellpadding="0" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>密码</td>
			<td>邮箱</td>
		</tr>
		<%
			for(int i=0;i<users.size();i++){
				User user = users.get(i);
			%>
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getUsername()%></td>
				<td><%=user.getPassword()%></td>
				<td><%=user.getEmail()%></td>
			</tr>
			<%
			}
		%>
	</table>
</body>
</html>