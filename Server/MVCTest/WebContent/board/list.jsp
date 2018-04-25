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
	
	#search {
		text-align:center;
	}
	
	#search #word {
		width:300px;
	}
	
	#pagebar {
		text-align:center;
	}
</style>
<script>
	$(function() {

		// 검색중이라면.. 컨트롤들을 이전 상태와 동일하게 유지
		<c:if test = "${map.isSearch == true}">
			$("#column").val("${map.column}");
			$("#word").val("${map.word}");
		</c:if>

		
	});
</script>
</head>
<body>
	<!-- list.jsp -->
	<div class="container">
	
		<jsp:include page="/inc/header.jsp"></jsp:include>
		
		
		<h2 class = "page-header">
		
		게시판 
		
		<c:if test = "${map.isSearch == 'false' }">
		<small>목록보기</small>
		</c:if>
		
		<c:if test = "${map.isSearch == 'true' }">
		<small>검색하기</small>
		</c:if>
		
		</h2>
		
		<c:if test = "${map.isSearch == 'true'}">
		
		<div id = "message" style = "text-align:center; color:#444; font-size:13px;">'${map.column}'에서 '${map.word}'(으)로 검색된 결과 '${map.totalcount}' 건 입니다.</div>
		
		</c:if>
		
		
		<%-- <div class = "form-inline" style = "text-align:right;">
			
			<input type = "range" style = "width:900px;margin:0px auto;" min = "1" max = "${map.totalpage}" value = "${map.page}" onchange = "location.href='list.do?page=' + this.value">
			
			<form method = "get" action = "/mvc/board/list.do">
			
			
				페이지 : <input type = "number" name = "page" id = "page" class = "form-control" value = "${map.page}" min = "1" max = "${map.totalpage}">
				<input type = "submit" value = "이동하기" class = "btn btn-default" required>
				
				<c:if test="${map.isSearch == true}">
					<input type = "hidden" name = "column" value = "${map.column}">
					<input type = "hidden" name = "word" value = "${map.word}">
				</c:if>

			</form>
			
			
		</div> --%>
		
		<table id = "tbl1" class = "table table-striped">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>날짜</th>
				<th>읽음</th>
			</tr>
			
			<c:if test = "${list.size() == 0}">
				<tr>
					<td colspan="5">게시물이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			
				<c:forEach items = "${list}" var = "dto">
				<tr>
					<td>
						<c:if test = "${dto.depth == 0 && dto.notice == 0}">
						${dto.seq}
						</c:if>
						<c:if test = "${dto.notice == 1}">
						<span class = "btn btn-primary">공지</span>
						</c:if>
					</td>
					<td>
						
						<c:if test = "${dto.depth > 0 }">
						<span class = "btn btn-primary" style = "margin-left:${dto.depth * 20}px; font-size:8px; padding:3px;">ㄴ[re]</span>
						</c:if>
						
						<c:if test = "${dto.secret == 1}">
						<span class = "glyphicon glyphicon-lock"></span>
						</c:if>
						
						<c:if test = "${map.isSearch == false}">
						<a href = "/mvc/board/view.do?seq=${dto.seq}">${dto.subject}</a>
						</c:if>
						
						<c:if test = "${map.isSearch == true}">
						<a href = "/mvc/board/view.do?seq=${dto.seq}&column=${map.column}&word=${map.word}">${dto.subject}</a>
						</c:if>
						
						<!-- 첨부 파일 여부 표시 -->
						<c:if test = "${!empty dto.orgfilename}">
						<span style = "font-size:11px;" class = "glyphicon glyphicon-floppy-disk" title = "${dto.orgfilename}"></span>
						</c:if>
						
						
						<!-- 댓글 수 표시 -->
						<c:if test = "${dto.ccount != 0}">
							<span style = "font-family:D2coding;font-size:7px;" class = "badge">${dto.ccount}</span>
						</c:if>
						
						<!-- 새로운 글  -->
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
			
			${pagebar}
			
			<div id = "search">
				<form class = "form-inline" action="/mvc/board/list.do" method = "get"> <!-- form 태그를 get으로 넘겨야하는 경우중 한가지 -->
						<select name = "column" id = "column" class = "form-control" style = "width:100px;">
							<option value = "subject">제목</option>
							<option value = "content">내용</option>
							<option value = "name">이름</option>
						</select>
						<input type = "text" name = "word" id = "word" class = "form-control">
						<input type = "submit" value = "검색하기" class = "btn btn-default">
				</form>
			</div>
			
			<div id = "btns">
				<input type = "button" value = "목록보기" class = "btn btn-default"
					onclick = "location.href = '/mvc/board/list.do';"> 
			
				<input type = "button" value = "글쓰기" class = "btn btn-primary"
					onclick = "location.href = '/mvc/board/add.do?mode=new';"> 
			</div>
		
		
			
	</div>
</body>
</html>