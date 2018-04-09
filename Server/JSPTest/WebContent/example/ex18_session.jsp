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
	<!-- ex18_session -->
	<!-- 
	
	첫번째 페이지로 접속한 A는 session과 application 값을 둘다 받을 수 있지만,
	두번째 페이지로 바로 접속한 B는 공용공간인 application의 값만 취할 수 있다.
	
	-->
	<%
	
	// session vs application
	session.setAttribute("num", 100);
	application.setAttribute("name", "홍길동");
	
	%>
	
	
</body>
</html>