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

	#tbl1 th:nth-child(1) {
		text-align:center;
		width:70px;	
	}
	#tbl1 th:nth-child(2) {
		text-align:center;
		width:540px;
	}
	#tbl1 th:nth-child(3) {
		text-align:center;
		width:120px;
	}
	#tbl1 th:nth-child(4) {
		text-align:center;
		width:140px;
	}
	#tbl1 th:nth-child(5) {
		text-align:center;
		width:70px;
	}
	
	#tbl1 td {
		text-align:center;
		vertical-align:middle;
	}
	
	#tbl1 td:nth-child(2) {
		text-align:left;
	}
	
	#tbl1 td span.label {
		font-size:.5em;
	}
	
	
	
</style>
<script>
	
</script>
</head>
<body>
	<!-- list.jsp -->
	<div class="container">
	
		<jsp:include page="/inc/header.jsp"></jsp:include>
		
		
		<h2 class = "page-header">게시판 <small>목록보기</small></h2>
		
		<table id = "tbl1" class = "table table-striped">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>날짜</th>
				<th>읽음</th>
			</tr>
			
			<c:forEach items = "${list}" var = "dto">
			<tr>
				<td>${dto.seq}</td>
				<td>
					<a href = "/mvc/board/view.do?seq=${dto.seq}">${dto.subject}</a>
					<c:if test="${dto.gap < 60}">
						<span class = "label label-danger">new</span>
					</c:if>
				</td>
				<td>${dto.name}</td>
				<td>${dto.regdate}</td>
				<td>${dto.readcount}</td>
			</tr>
			</c:forEach>
		</table>
			
			<div id = "btns">
				<input type = "button" value = "목록보기" class = "btn btn-default"
					onclick = "location.href = '/mvc/board/list.do';"> 
			
				<input type = "button" value = "글쓰기" class = "btn btn-primary"
					onclick = "location.href = '/mvc/board/add.do';"> 
			</div>
		
		
			
	</div>
</body>
</html>