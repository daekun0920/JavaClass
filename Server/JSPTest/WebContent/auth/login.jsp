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
	
	<%@ include  file = "../code/inc/header.jsp"%>
	<h1>로그인</h1>
	
	<form method = "post" action = "loginok.jsp">
		<table class = "table table-bordered">
			<tr>
				<th>아이디</th>
				<td><input type = "text" name = "id"></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type = "password" name = "pw"></td>
			</tr>
		</table>
		<div>
			<input type = "submit" value = "로그인하기">
		</div>
	</form>


</body>
</html>