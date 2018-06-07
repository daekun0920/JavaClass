<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- add.jsp -->
	
	<h1>단일 파일 업로드</h1>
	
	<form method="POST" action="${pageContext.request.contextPath}/addok.action" enctype="multipart/form-data">
		
		<p>파일 : <input type="file" name="attach"></p>
		<p>데이터 : <input type="text" name="data"></p>
		<p><input type="submit" value="업로드"></p>		
		
	</form>
	
</body>
</html>


























    