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
	<h1>두번째 페이지</h1>
	
	<jsp:useBean id="item" class = "com.test.jsp.Item" scope = "application"></jsp:useBean>
	
	<jsp:getProperty property = "name" name = "item" />
	-
	<jsp:getProperty property = "nick" name = "item" />
	
	<%-- <jsp:forward page = "ex25_bean_three.jsp"></jsp:forward> --%> <!-- request를 가져간다 -->
	<a href = "ex25_bean_three.jsp">세번째 페이지</a> <!-- 안가져간다 -->
	
</body>
</html>