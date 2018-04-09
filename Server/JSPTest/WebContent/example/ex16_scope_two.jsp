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
	<!-- ex16_scope.two.jsp -->
	<h1>두번째 페이지</h1>
	
	<h2>결과</h2>
	
	<!-- 자바코드는 HTML 주석의 영향을 받지 않는다. -->
	<%-- <p>a = <%= a %></p> --%> <!-- 지역 변수 -->
	<%-- <p>b = <%= b %></p> --%> <!-- 멤버 변수 -->
	
	<p>c = <%= pageContext.getAttribute("c") %></p>
	<p>d = <%= request.getAttribute("d") %></p>
	<p>e = <%= session.getAttribute("e") %></p>
	<p>f = <%= application.getAttribute("f") %></p>
	
</body>
</html>