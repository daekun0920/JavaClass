<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 지역 ~ 멤버 ~ pageContext ~ request ~ session ~ application
String name = "홍길동";

%>
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
	<!-- ex20_scope_full.jsp : 일반 페이지 -->
	<!-- ex20_scope_part.jsp : 조각 페이지 -->
	<!-- 조각 페이지와 일반페이지는 서로 자원을 공유한다(그냥 한 몸이라고 보면 됨) -->
	<h1>일반페이지</h1>
	<p>내용</p>
	<p>내용</p>
	<p>내용</p>
	<%--<p>age : <%= age %> </p> --%> <!-- 컴파일 에러 -->
	
	<%@ include file = "ex20_scope_part.jsp" %>
	
	<p>내용</p>
	<p>내용</p>
	<p>내용</p>
	<p>age : <%= age %> </p>
	
</body>
</html>