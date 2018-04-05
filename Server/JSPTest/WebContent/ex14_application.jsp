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
	<h1>Application</h1>
	
	<h2>컨테이너 정보</h2>
	<%= application.getServerInfo() %>
	
	<h2>서블릿 버전(톰캣버전에 따라 결정)</h2>
	<%= application.getMajorVersion() %> <%= application.getMinorVersion() %>
	
	<h2>JSP 버전</h2>
	<%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
	
	<h2>현재 물리 경로(상대경로 넣으면 -> 절대경로)</h2>
	<%= application.getRealPath(".") %>
</body>
</html>