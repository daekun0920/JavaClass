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
	$(function () {
		
		if ("${result}" == 1) {
			
			alert("성공적으로 글을 등록 하였습니다.");
			location.href = "/enter/management/scheduleboard.do?star=${art_seq}&type=${type}";
			
		} else {
		
			alert("글을 등록 할 수 없습니다.");
			location.href = "/enter/management/scheduleboard.do?star=${art_seq}&type=${type}";
		}
		
		
	
	
	
	});
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header.jsp"></jsp:include>
	
	
	
	<jsp:include page="/inc/footer.jsp"></jsp:include>
	
</body>
</html>