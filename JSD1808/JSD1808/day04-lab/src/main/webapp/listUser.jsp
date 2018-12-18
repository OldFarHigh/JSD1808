<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dao.*,entity.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listUser</title>
<style type="text/css">
	.row1{
		background-color:#f0f0f0;
	}
	.row2{
		background-color: #fff888;
	}
</style>
</head>
<body style="font-size: 30px;">
	<table border="1" width="60%" cellpadding="0" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>密码</td>
			<td>邮箱</td>
			<td>操作</td>
		</tr>
		<%
			UserDAO dao = new UserDAO();
			List<User> users = dao.findAll();
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
		%>
		<tr class="row<%= i % 2+1 %>">
			<td><%=user.getId() %></td>
			<td><%=user.getUsername() %></td>
			<td><%=user.getPassword() %></td>
			<td><%=user.getEmail() %></td>
			<td><a href ='del?id=<%=user.getId()%>'>删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>