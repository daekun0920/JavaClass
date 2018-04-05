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
	<!-- ex15_out.jsp -->
	<%
	int dan = 2;
	
	
	
	%>
	<h1><%= dan %>단</h1> - 스크립틀릿 + 표현식
	
	<% for (int i = 1; i <= 9; i++) { %>
		<div> <%= dan %> x <%= i %> = <%= dan * i %></div>
	<% } %>
	
	<h1><%= dan %>단 - out 내장 객체</h1>
	
	<%
	
	for (int i = 1; i <= 9; i++) {
		
		// HTML 출력
		// writer.println(); - PrintWriter와 같은 역할
		out.println(String.format("<div> %d x %d = %d</div>", dan, i, dan * i));
		
	}
	
	%>
	
</body>
</html>