<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/memo/resources/css/memo.css">
<link rel="stylesheet" href="/memo/resources/css/bootstrap.css">
</head>
<body>
	<!--  -->

	<div class="container">
		<h2 class="page-header">메모장</h2>

		<section>

			<nav>메모 > 메모목록</nav>
			<table class="table table-striped">
				<tr>
					<th>메모</th>
					<th>이름</th>
					<th>분류</th>
					<th>시각</th>
					<th>주작</th>
				</tr>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.memo }</td>
						<td>${dto.name }</td>
						<td>${dto.categoryName }</td>
						<td>${dto.regDate }</td>
						<td>
							<input type = "button" value = "수정" class = "btn btn-default" onclick = "location.href='/memo/edit.memo?seq=${dto.seq}'">
							<input type = "button" value = "삭제" class = "btn btn-default" onclick = "location.href='/memo/del.memo?seq=${dto.seq}'">
						</td>
					</tr>
				</c:forEach>
			</table>

			<div id="btns">
				<input type="button" value="메모 쓰기" class="btn btn-default"
					onclick="location.href='/memo/add.memo'">
			</div>
		</section>

	</div>

</body>
</html>