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
	<%--
	
	$("#subject").val("${dto.subject}");
	$("#content").val("${dto.content}"); // 내용이 여러줄이거나 쌍따옴표가 들어있거나 하면 다 들어가지 않는다.(자바스크립트는 문자열에 엔터 지원 안함)
	
	--%>
</script>
</head>
<body>
	<!--  -->
	<div class="container">
	
	<jsp:include page="/inc/header.jsp"></jsp:include>
	
	
	<h2 class = "page-header">게시판 <small>수정하기</small></h2>
	
	<form method = "post" action = "/mvc/board/editok.do">
		<table id = "tbl1" class = "table table-striped">
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "subject" id = "subject" class = "form-control" value = "${dto.subject}" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name = "content" id = "content" class = "form-control" required>${dto.content}</textarea></td>
			</tr>
			<tr>
				<th>태그</th>
				<td>
					<select name = "tag" id = "tag" class = "form-control">
						<option value = "n" <c:if test = "${dto.tag == 'n'}">selected</c:if>>적용안함</option>
						<option value = "y" <c:if test = "${dto.tag == 'y'}">selected</c:if>>적용함</option>
					</select>
				</td>
			</tr>
		</table>
		
		<div id = "btns">
				<input type = "button" value = "뒤로가기" class = "btn btn-default"
					onclick = "history.back();"> 
			
				<input type = "submit" value = "글수정하기" class = "btn btn-primary"> 	
		</div>
		
		<input type = "hidden" name = "seq" value = "${dto.seq}">
	</form>
	</div>
</body>
</html>