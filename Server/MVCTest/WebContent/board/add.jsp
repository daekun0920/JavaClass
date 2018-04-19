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

	#tbl1 th {
		width:150px;
		
		text-align:right;
		
		vertical-align:middle;
		padding-right:15px;
	}

	#tbl1 td {
		width:750px;
		padding-right:50px;
	}
	
	
	#tbl1 #content {
		height:450px;
		
	}
</style>
<script>
	
</script>
</head>
<body>
	<!--  -->
	<div class="container">
	
	<jsp:include page="/inc/header.jsp"></jsp:include>
	
	
	<h2 class = "page-header">게시판 <small>글쓰기</small></h2>
	
	<form method = "post" action = "/mvc/board/addok.do" enctype = "multipart/form-data">
		<table id = "tbl1" class = "table table-striped">
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "subject" id = "subject" class = "form-control" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name = "content" id = "content" class = "form-control" required></textarea></td>
			</tr>
			<tr>
				<th>태그</th>
				<td>
					<select name = "tag" id = "tag" class = "form-control">
						<option value = "n">적용안함</option>
						<option value = "y">적용함</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>파일</th>
				<td><input type = "file" class = "form-control middle" name = "attach"></td>
			</tr>
		</table>
		
		<div id = "btns">
				<input type = "button" value = "뒤로가기" class = "btn btn-default"
					onclick = "history.back();"> 
			
				<input type = "submit" value = "글쓰기" class = "btn btn-primary"> 	
		</div>
		
		<input type = "hidden" name = "mode" value = "${mode}">
		<input type = "hidden" name = "thread" value = "${thread}">
		<input type = "hidden" name = "depth" value = "${depth}">
		
		
	</form>
	</div>
</body>
</html>