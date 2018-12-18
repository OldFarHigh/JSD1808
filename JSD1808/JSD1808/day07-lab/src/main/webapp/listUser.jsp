<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entity.*,java.util.*,java.text.*"%>
<%@ page  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<%@ include file="header.jsp"%>
			<div id="content">
				<p id="whereami"></p>
				<h1>用户列表</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>用户名</td>
						<td>密码</td>
						<td>邮箱</td>
						<td>操作</td>
					</tr>
					<%
							/*强转成需要的格式  */
							List<User> users = (List<User>)request.getAttribute("users");
							for(int i=0;i<users.size();i++){
								User user = users.get(i);
						%>
					<tr class="row<%=i%2+1 %>>">
						<td><%=user.getId() %>
						</td>
						<td><%=user.getUsername() %>
						</td>
						<td><%=user.getPassword()%>
						</td>
						<td><%=user.getEmail() %>
						</td>
						<td><a href="del?id=<%=user.getId()%>" onclick="return confirm('确定删除<%=user.getUsername()%>吗？');">删除</a>&nbsp;
						</td>
					</tr>
					<%
							}
					%>
				</table>
				<p>
					<input type="button" class="button" value="添加用户"
						onclick="location='addUser.jsp'" />
				</p>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>