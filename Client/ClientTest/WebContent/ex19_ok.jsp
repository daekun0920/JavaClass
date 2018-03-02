<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name"); // <input name = "name">
	String age = request.getParameter("age");   // <input name = "age">
	
	// JDBC
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--ex19_ok.jsp-->
	<h1>결과</h1>
	입력하신 이름은 '<%=name%>'이고, 나이는 <%=age%>세입니다.
</body>
</html>