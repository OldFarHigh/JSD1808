<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<html>
<head>
<title>简单运算</title>
</head>
<body style="font-size:30px;">
	算术运算：<br/>
	${1+1}<br/>
	<%-- ${'a'+'b'}<br/> --%>
	关系运算：<br/>
	${1<2 }<br/>
	<%
		request.setAttribute("s1","abc");
	%>
	${s1 == 'abc' }<br/>
	${sessionScope.s1 == 'abc' }<br/>
	逻辑运算：<br/>
	${1<2 &&  2>3}
	empty运算：<br/>
	<%
		List<String> list1=new ArrayList<String>();
		request.setAttribute("list1",list1);
		pageContext.setAttribute("s2", "");
	%>
	集合是否为空：${empty list1}<br/>
	是否是一个空字符串：${empty s2}<br/>
	null值：${empty null}<br/>
	
	${empty aaa} <br/><!--根据绑定名找不到值  -->
	
</body>
</html>