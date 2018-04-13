<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page = "/inc/asset.jsp">
	<jsp:param value="1" name="board"/>
</jsp:include>
<style>
</style>
<script>
	
</script>
</head>
<body>
	<!--  -->
	<div class="container">
	
	<jsp:include page="/inc/header.jsp"></jsp:include>
	
	
	<h2 class = "page-header">페이지 제목입니다.</h2>
	
		내용물...
		
	</div>
</body>
</html>