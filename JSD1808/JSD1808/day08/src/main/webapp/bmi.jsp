<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<form action="bmi" method="post">
		<fieldset>
			<legend>计算BMI指数</legend>
			身高（米）：<input name="height"/><br/>
			体重（公斤）：<input name="weight"/><br/>
			性别：男<input type="radio" name="gender" value="m" checked="checked">
			女<input type="radio" name="gender" value="f"/><br/>
			<input type="submit" value="确定"/>			
		</fieldset>
	</form>	
</body>
</html>