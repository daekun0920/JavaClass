<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mugle.org - 게시판</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/header.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/header.js"></script>
<script src="js/bootstrap.js"></script>
<jsp:include page="/header.jsp"></jsp:include>
<style>
#tbl1 {
	width: 900px;
	margin: 0px auto;
	margin-top: 100px;
}

#pagebar {
	
	text-align:center;

}

.container {

	width:900px;

}

th,td {

	text-align:center;

}
</style>
<script>
	
</script>
</head>
<body>
	<div class = "container">
		<table id="tbl1" class="table table-striped">
			<tr>
				<th style = "width:60px;">번호</th>
				<th style = "width:300px;">제목</th>
				<th style = "width:60px;">작성자</th>
				<th style = "width:60px;">작성시간</th>
				<th style = "width:60px;">조회 수</th>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.board_seq}</td>
					<td><a href = "/APITest/view.do?seq=${dto.board_seq }">${dto.subject }</a></td>
					<td>${dto.name }</td>
					<td>${dto.regdate }</td>
					<td>${dto.views }</td>
				</tr>
			</c:forEach>
		</table>
				
			<a style = "display:block;margin:0px auto;margin-top:30px;width:900px;text-align:center;" class="btn btn-info" href = "/APITest/write.do">글 쓰기</a>
			
	
		${pagebar }
	</div>
</body>
</html>