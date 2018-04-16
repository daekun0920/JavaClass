<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	<!-- list.jsp -->
	<div class = "container">
	
		<h1 class = "page-header">주소록 <small>목록보기</small></h1>
		
		<table class = "table table-bordered">
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<c:forEach items = "${list}" var = "dto">
				<tr>
					<td>${dto.name}</td>
					<td>${dto.age}</td>
					<td>
					<%-- ${dto.gender} --%>
						<img src = "images/gender_${dto.gender}.png">
					</td>
					<td>${dto.tel}</td>
					<td>${dto.address}</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	
	
</body>
</html>