<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "/memo/resources/css/memo.css">
<link rel = "stylesheet" href = "/memo/resources/css/bootstrap.css">
</head>
<script>
	<c:if test = "${result == 1}">
		location.href = "/memo/index.memo";
	</c:if>
	<c:if test = "${result == 0}">
		history.back();
	</c:if>
</script>
<body>	
	<!--  -->
	
	<div class = "container">
		<h2 class = "page-header">메모장</h2>
		
		<section>
			
			<nav>메모 > 메모목록</nav>
			
			컨텐츠
			
		</section>
	
	</div>
	
</body>
</html>