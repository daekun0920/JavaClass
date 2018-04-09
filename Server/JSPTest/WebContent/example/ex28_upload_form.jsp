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
	<!-- ex28_upload_form.jsp -->
	
	<h1>파일 업로드</h1>
	
	<!-- 
		1. 파일 업로드 > 대량의 데이터 > 반드시 POST 
		2. enctype 지정
			- application/x-www-form-urlencoded : 전송되는 데이터가 문자열로 구성
			- 바이너리 데이터(첨부 파일)이 그냥 전송되지않음 -> enctype -> multipart/form-data
			
	-->
	<form method = "post" action = "ex28_upload_process.jsp" enctype = "multipart/form-data">
		<div>제목 : <input type = "text" name = "subject"></div>
		<div>이름 : <input type = "text" name = "name"></div>
		<div>파일 : <input type = "file" name = "attach"></div> <!-- 파일 업로드 컨트롤 -->
		<div><input type = "submit" value = "보내기"></div>
	</form>
	
</body>
</html>