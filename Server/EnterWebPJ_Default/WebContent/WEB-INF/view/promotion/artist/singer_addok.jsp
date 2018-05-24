<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>

</style>
<script>
	<c:if test="${result==1}">
	location.href = "/enter/promotion/artist/index_singer.do";	
	</c:if>
	
	<c:if test="${result != 1}">
	alert("글쓰기를 실패했습니다.");
	history.back();
	</c:if>


</script>
</head>
<body>
	<!--  -->
		<jsp:include page="/inc/header_main.jsp"></jsp:include>
	
	<div id="container">Singer_ADDOK</div>	
	
	<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>