<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 - ${dto.subject}</title>
<jsp:include page = "/inc/asset.jsp">
	<jsp:param value="1" name="board"/>
</jsp:include>
<style>
#tbl1 th {
		width:150px;
		
		text-align:right;
		border-right:1px solid #EEE;
		
		vertical-align:middle;
		padding-right:15px;
	}

	#tbl1 td {
		width:750px;
		padding-right:50px;
	}
	
	
	#tbl1 #content {
		height:450px;
		
		vertical-align:middle;
	}
</style>
<script>
	
</script>
</head>
<body>
	<!-- view.jsp -->
	<div class="container">
	
	<jsp:include page="/inc/header.jsp"></jsp:include>
	
	
	<h2 class = "page-header">게시판 <small>상세보기</small></h2>

		<table id = "tbl1" class = "table table-striped">
			<tr>
				<th>번호</th>
				<td>${dto.seq}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${dto.name}(${dto.id })</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.subject}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td id = "content">${dto.content}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${dto.regdate}</td>
			</tr>
			<tr>
				<th>읽음</th>
				<td>${dto.readcount}</td>
			</tr>
		</table>
		<div id = "btns">
				
				<c:if test = "${empty word}"> <!-- empty : 비거나 값이 없을때 -->
					<input type = "button" value = "뒤로가기" class = "btn btn-default"
							onclick = "location.href='/mvc/board/list.do';"> 
				</c:if>
				
				<c:if test = "${!empty word }">
					<input type = "button" value = "뒤로가기" class = "btn btn-default"
							onclick = "location.href='/mvc/board/list.do?column=${column}&word=${word}';"> 
				</c:if>
						
				<c:if test = "${dto.id == auth}">
					<input type = "button" value = "수정하기" class = "btn btn-primary"
						onclick = "location.href='/mvc/board/edit.do?seq=${dto.seq}';"> 
					<input type = "button" value = "삭제하기" class = "btn btn-primary"
						onclick = "location.href='/mvc/board/delok.do?seq=${dto.seq}';">
				</c:if>
				
				<c:if test = "${dto.id != auth}"> 
					<input type = "button" value = "수정하기" class = "btn btn-primary"
						onclick = "alert('권한이 없습니다.');"> 
					<input type = "button" value = "삭제하기" class = "btn btn-primary"
						onclick = "alert('권한이 없습니다.');"> 	
				</c:if>
		</div>
	
			
		
	</div>
</body>
</html>