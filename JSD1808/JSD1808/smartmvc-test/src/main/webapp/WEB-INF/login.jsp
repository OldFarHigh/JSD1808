<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>登录页面</title>
</head>
<body style="font-size:30px;">
	<form action="login.do" method="post">
		<fieldset>
			<legend>登录</legend>
			用户名：<input name="username"/>${login_failed}<br/>
			密码：<input type="password" name="pwd"/><br/>
			<input type="submit" value="确定"/>
		</fieldset>
	</form>
</body>
</html>