<%@page import="java.util.*,java.text.* " contentType="text/html;charset=utf-8"%>
<html>
	<body style="font-size:30px">
		time:
		<%
			Date date = new Date();
			String str ="yyyy年-MM月-dd日";
			SimpleDateFormat sdf = new SimpleDateFormat(str);
			String line =sdf.format(date);
			out.println(line);
		%>
	</body>
</html>
