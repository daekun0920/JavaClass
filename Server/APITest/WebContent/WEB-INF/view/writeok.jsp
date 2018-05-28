<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/header.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/header.js"></script>
<script src="js/bootstrap.js"></script>
<jsp:include page="/header.jsp"></jsp:include>
<style>

</style>
<script>
	$(function() {
		
		if (${result} == 1) {
			
			alert("글 쓰기를 완료 했습니다.");
			location.href = "/APITest/board.do";
			
		} else {
			
			alert("글 쓰기를 실패 했습니다.")
			location.href = "/APITest/board.do"
		}
		
		
	});
	
</script>
</head>
<body>

</body>
</html>