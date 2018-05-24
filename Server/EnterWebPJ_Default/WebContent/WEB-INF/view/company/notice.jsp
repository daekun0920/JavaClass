<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>
	#div_head, #div_body {
	
		width:900px;
		margin:0px auto;
	
	}
	
	#pagebar {
	
		text-align:center;
	
	}
	
	th{
	
		background-color:#072946;
		color:white;
	
	}
</style>
<script>
	function writenotice() {
		
		location.href = "/enter/company/addnotice.do";
		
	}
	
	function search() {
		
		
		location.href = "/enter/company/notice.do?issearch=1&category=" + $("#selbox").val() + "&keyword=" + $("#keyword").val();
		
		
	}
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header_main.jsp"></jsp:include>
	
	<div id = "div_head" style = "position:relative;margin-bottom:30px;">
		<h1>공지사항</h1>
		<div id = "search" style = "margin-bottom:30px;right:0;top:0;position:absolute;">
			<select class = "form-control" style = "width:100px;display:inline;" id = "selbox">
				<option value = "stitle">제목</option>
			</select>
			<input type = "text" id = "keyword" class = "form-control" style = "width:300px;display:inline;">
			<button class = "btn btn-info" onclick = "search();"><span class = "glyphicon glyphicon-search"></span></button>
		</div>
		
	</div>
	<div id = "div_body" style = "position:relative;">
		<table id = "board1" class = "table striped-table">
			<tr>
				<th style = "text-align:center;width:50px;" >번호</th>
				<th style = "text-align:center;">
			
					제목
				</th>
				<th style = "text-align:center;">작성자</th>
				<th style = "text-align:center;">조회 수</th>
				<th style = "text-align:center;">작성시간</th>
			</tr>
			<c:forEach items = "${list}" var = "dto">
			<tr>
				<td style = "text-align:center;">	
					<c:if test = "${dto.check == 1}">
						<span class = "btn btn-info" style = "height:35px;font-size:15px;">공지</span>
					</c:if>
					<c:if test = "${dto.check == 0}">
						${dto.seq }
					</c:if>
				</td>
				<td style = "text-align:center;">
					<a href = "/enter/company/view.do?seq=${dto.seq }" style = "text-decoration: none;color:#AAA;">${dto.title }</a>
				</td>
				<td style = "text-align:center;width:60px">
					${dto.staffname }
				</td>
				<td style = "text-align:center;width:70px;">${dto.visitors }</td>
				<td style = "text-align:center;width:120px;">${dto.time }</td>
			</tr>
			</c:forEach>
		</table>
		${pagebar }
		<button class = "btn btn-info" style = "position:absolute;bottom:30px;right:0;float:right;" onclick = "writenotice();">글 쓰기</button>
		<div style = "clear:both;"></div>
		
	</div>
	<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>