<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.test.jsp.code.DBUtil" %>
<%@ include file = "inc/auth.jsp" %>
<%




%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코드</title>
<%@ include file = "inc/asset.jsp" %>
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
	<!-- list.jsp -->
	<div id = "main">
		<%@ include file = "inc/header.jsp" %>
		<div id = "container">
			<h2 class = "page-header">목록</h2>
			<div id = "btns">
				<input type = "button" class = "btn btn-primary" value = "코드 쓰기" onclick = "location.href='add.jsp';">
			</div>
		</div>
		<%@ include file = "inc/footer.jsp" %>
	</div>
	
	
	
</body>
</html>