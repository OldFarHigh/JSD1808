<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>用户登录</title>
</head>
<body style="font-size:30px;">
	<form action="handle_login.do" method="post">
		<fieldset>
			<legend>登录</legend>
			用户名：<input name="username"/><br/>
			密码：<input name="password"/><br/>
			<input type="submit" value="登录">
		</fieldset>
	</form>
</body>
</html>