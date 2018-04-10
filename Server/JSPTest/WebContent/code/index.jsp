<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.test.jsp.code.DBUtil" %>

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
	<!-- index.jsp -->
	
	<div id = "main">
		<%@ include file = "inc/header.jsp" %>
		<div id = "container">
			<h2 class = "page-header">시작 페이지</h2>
			
			<% if (session.getAttribute("auth") != null) { %>
				<input type = "button" class = "btn btn-default" value = "코드 페이지" onclick = "location.href = 'list.jsp';">
			<% } %>
		</div>
		<%@ include file = "inc/footer.jsp" %>
	</div>
	
	
	
</body>
</html>