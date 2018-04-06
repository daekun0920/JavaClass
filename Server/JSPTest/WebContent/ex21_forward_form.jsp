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
	<!-- ex21_forward_form.jsp -->
	<h1>입력 페이지</h1>
	
	<form method = "post" action = "ex21_forward_process.jsp">
		<div>
			이름 : <input type = "text" name = "name">
		</div>
		
		<div>
			나이 : <input type = "text" name = "age">
		</div>
		
		<div>
			<input type = "submit" value = "보내기">
		</div>
	</form>
	
</body>
</html>