<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 객체 생성 및 참조
Random rnd = new Random();


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
	<!-- ex07_request_form.jsp -->
	
	<h1>데이터를 전송하는 역할(POST, GET)</h1>
	
	<form method = "GET" action = "ex07_request_process.jsp">
		<table style = "width:500px" class = "table table-bordered">
			<tr>
				<th style = "width:150px;">이름</th>
				<td style = "width:400px;">
					<input type = "text" name = "name" class = "form-control">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<select name = "gender" class = "form-control">
						<option value = "m">남자</option>
						<option value = "f">여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<input type = "number" name = "age" min = "0" max = "100" class = "form-control">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type = "text" name = "address" class = "form-control">
				</td>
			</tr>
		</table>
		<hr>
		<input type = "submit" value = "보내기" class = "btn btn-default">
	</form>
	
</body>
</html>