<%@page import="com.test.jsp.MyCookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>

</style>
<script>
	//$(document).ready(function() {
	//	
	//});
	
	// 줄임 표현
	$(function() {
		
	});
</script>
</head>
<body>
	<!-- ex27_cookie_2.jsp -->
	<% 
	
	//다른 페이지에서 만든 쿠키를 가져오기
	String name = "";
	
	String temp = request.getHeader("Cookie");
	System.out.println(temp);
	
	Cookie[] cookies = request.getCookies();
	
	for (int i = 0; i < cookies.length; i++) {
		
		out.println(String.format("쿠키명 : %s<br>", cookies[i].getName()));
		out.println(String.format("쿠키값 : %s<br>", cookies[i].getValue()));
		
	}
	
	%>
	
	이름 : <%= MyCookie.getCookie(request.getCookies(), "name") %>
	<br>
	나이 : <%= MyCookie.getCookie(request.getCookies(), "age") %>
	
</body>
</html>