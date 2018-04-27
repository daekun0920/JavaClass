<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>
	body {
		margin-bottom:200px;
	}
</style>
<script>
	var page = 1;
	
	function more() {
		
		page++;
		
		$.ajax({

			type:"GET",
			url:"/ajax/ex11data.do",
			data:"page=" + page, // 주고
			dataType: "json",
			success: function(result) { // 받고(다음 페이지의 레코드들..)
			
				
				$(result).each(function (index, item) {
					$("#tb1").append("<tr><td>" + item.seq + 
									 "</td><td>" + item.subject + 
									 "</td><td>" + item.id + 
									 "</td><td>" + item.regdate + 
									 "</td><td>" + item.readcount + 
									 "</td></tr>");
				});
			},
			error: function() {
				alert("더 이상 페이지가 없습니다.");
				$("#btn1").css("visibility", "hidden");

			}

		});

	}
	
</script>
</head>
<body>
	<!--  -->
	
	<div class = "container">
		<h2 class = "page-header">게시판</h2>
		<table class = "table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>아이디</th>
					<th>날짜</th>
					<th>읽음</th>
				</tr>
			</thead>
			<tbody id = "tb1">
				<c:forEach items = "${list}" var = "dto">
				<tr>
					<td>${dto.seq }</td>
					<td>${dto.subject }</td>
					<td>${dto.id }</td>
					<td>${dto.regdate }</td>
					<td>${dto.readcount}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
			<button type = "button" id = "btn1" class = "btn btn-default btn-block" onclick = "more();">
				게시물 더 가져오기<br>
				<span class = "glyphicon glyphicon-triangle-bottom"></span>
			</button>
		</div>
	</div>
	
</body>
</html>