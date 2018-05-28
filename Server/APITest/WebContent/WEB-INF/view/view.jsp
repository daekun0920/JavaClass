<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/header.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/header.js"></script>
<script src="js/bootstrap.js"></script>
<jsp:include page="/header.jsp"></jsp:include>
<style>
	#tbl1 {
	
		width:900px;
		margin:0px auto;
		margin-top:30px;
		
	}	
	#container {
	margin:0px auto;
	
		width:900px;
	}
	
</style>
<script>

</script>
</head>
<body>	
	<div id = "container">
	<table id = "tbl1" class = "table table-striped">
		<tr>
			<td>제목</td>
			<td>${dto.subject }</td>
		</tr>
		<tr>
			<td>작성시간</td>
			<td>${dto.regdate }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.name }</td>
		</tr>
		
		<tr style = "height:500px;"s>
			<td style = "height:500px;">내용</td>
			<td style = "height:500px;">${dto.content }</td>
		</tr>
	</table>
	<c:if test = "${dto.naver_seq == naver_seq }">
		<a class = "btn btn-danger" style = "display:block;margin:0px auto;">글 삭제</a>
	</c:if>
	</div>
	<input type = "hidden" value = "${dto.naver_seq }">
</body>
</html>