<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>用户注册</title>
</head>
<body style="font-size:30px;">
	<form action="handle_reg.do" method="post">
		<fieldset>
			<legend>注册页面</legend>
			用户名：<input name="username"/><br/>
			密码：<input name="password"/><br/>
			年龄：<input name="age"/><br/>
			手机号码：<input name="phone"/><br/>
			电子邮箱：<input name="email"/><br/>
			<input type="submit" value="注册"/>
		</fieldset>
	</form>
</body>
</html>