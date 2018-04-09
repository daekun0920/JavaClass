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
	<h1>주소록 추가하기</h1>
	
	<form method = "post" action = "ex24_bean_process.jsp">
		<div>
			이름 : <input type = "text" name = "name">
		</div>
		<div>
			나이 : <input type = "text" name = "age">
		</div>
		<div>
			성별 : <select name = "gender">
				<option value = "m">남자</option>
				<option value = "f">여자</option>
				</select>
		</div>
		<div>전화 : <input type = "tel" name = "tel"></div>
		<div>주소 : <input type = "text" name = "address"></div>
		<div><input type = "submit" value = "추가하기"></div>
	</form>
	
</body>
</html>