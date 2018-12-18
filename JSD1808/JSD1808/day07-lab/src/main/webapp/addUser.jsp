<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dao.*,java.util.*,entity.*,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						<%
						Date date = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
						out.println(sdf.format(date));
						%>
						<br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">Main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>添加用户信息:</h1>
				<form action="add" method="post">
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr>
							<td valign="middle" align="right">用户名:</td>
							<td valign="middle" align="left">
							<input type="text"	class="inputgri" name="uname" /></td>
						</tr>
						<tr>
							<td valign="middle" align="right">密码:</td>
							<td valign="middle" align="left">
							<input type="password"	class="inputgri" name="pwd" /></td>
						</tr>
						<tr>
							<td valign="middle" align="right">邮箱:</td>
							<td valign="middle" align="left">
							<input type="text" class="inputgri" name="email" /></td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="确认"  />
					</p>
				</form>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">1506183608@qq.com</div>
		</div>
	</div>
</body>
</html>