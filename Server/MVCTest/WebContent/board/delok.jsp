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

	<c:if test="${result == 1}">
	alert("삭제를 완료 하였습니다.");
	location.href="/mvc/board/list.do";
	</c:if>

	<c:if test="${result == 0}">
	alert("글 삭제를 실패했습니다");
	history.back();
	</c:if>

	<c:if test="${result == 2}">
	history.back();
	alert("삭제 권한이 없습니다");
	</c:if>

		
</script>
</head>
<body>
	<!--  -->
	<div class="container">
	
	<jsp:include page="/inc/header.jsp"></jsp:include>
	
	
	<h2 class = "page-header">게시판 <small>글 삭제</small></h2>
	
		<%-- ${result} --%>
			
	</div>
</body>
</html>