<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>

</style>
<script>

$(function() {
	alert("잘못된 접근입니다.");
	location.href = "/enter/index_main.do";

});
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header.jsp"></jsp:include>
	
	
	
	<jsp:include page="/inc/footer.jsp"></jsp:include>
	
</body>
</html>