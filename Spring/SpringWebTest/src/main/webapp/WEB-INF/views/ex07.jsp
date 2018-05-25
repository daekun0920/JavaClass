<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력</h1>
	
	<form method = "post" action="/spring/ex07ok.action">
	
		<div> 이름 : <input type = "text" name = "name"></div>
		<div> 나이 : <input type = "text" name = "age"></div>
		<div> 주소 : <input type = "text" name = "address"></div>
		<div> 전화 : <input type = "text" name = "tel"></div>
	
		<input type = "submit" value = "보내기">
	</form>
	
</body>
</html>