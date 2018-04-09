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
	<!--  -->
	<!-- 브라우저가 다르면 다른 사용자로 인식한다. -->
	<!-- 세션 ID가 적힌 쿠키를 서버는 클라이언트에게 준다 -->
	<!-- 재접속 후 세션 만료 시간 갱신은 브라우저가 열려있었다는 전제하에 이루어짐 -->
	<h1>Session</h1>
	
	<p><%= session.getCreationTime() %></p> <!-- 1522903853073 틱값 -->
	<p><%= session.getId() %></p> <!-- 2ABFC4A969EBFC8433766DEF42E6813A -->
	<p><%= session.getLastAccessedTime() %></p> <!-- 1522903853075 -->
	<p><%= session.isNew() %></p> <!-- false -->
	<p><%= session.getMaxInactiveInterval() %></p> <!-- 1800 -->
	
	<a href = "ex17_session_2.jsp">두번째 페이지</a>
	
	
</body>
</html>