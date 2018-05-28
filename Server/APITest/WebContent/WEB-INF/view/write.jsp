<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mugle.org - 글 쓰기</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/header.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/bootstrap.js"></script>
<jsp:include page="/header.jsp"></jsp:include>
<style>
	#container {
	
		width:900px;
		margin:0px auto;
	
	}
	
	
</style>
<script>
	
</script>
</head>
<body>
	<div id = "container">
		
		<form action="/APITest/writeok.do" method = "post">
			<input name = "title" style = "margin-top:30px;" class = "form-control"type = "text" placeholder="제목">
			<textarea name = "content"  class = "form-control" placeholder = "내용" draggable="false" style = "height:500px;margin-top:30px;"></textarea>
			<input class = "btn btn-info" type = "submit" value = "글 쓰기" style = "width:900px;">
		</form>
	</div>
</body>
</html>