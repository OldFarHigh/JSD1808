<%@page import="java.util.*"  contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!--import指定要导的包名，如果有多个包，用“，”号分隔开  -->
<!--concententType 设置response.setContentType的内容  -->
<!--pageEncoding ：容器在读取jsp文件的内容时，需要解码。pageEncoding就是告诉容器该使用哪种字符集解码  -->
<html>
<head></head>
<body style="font-size: 30px;">
	吃了吗？
	time:<%=new Date() %>>
	time:
	<%
		Date date = new Date();
		out.println(date);
	%>
	<br/>
	<%
		for(int i=0;i<100;i++){
			out.println("Hello Kitty <br/>");
		}
	%>
</body>

</html> 