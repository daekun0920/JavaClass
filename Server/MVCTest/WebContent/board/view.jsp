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
	
	#cform {
		width:700px;
		margin:0px auto;
		margin-top:20px;
		
	}
	
	#cform #ccontent {
		width:600px;
		height:100px;
	}
	
	#cform input {
		height:100px;
	}
	
	#tbl2 {
		width:700px;
		margin:0px auto;
		margin-top:20px;
	}
	
	#tbl2 td:nth-child(1) {
		width: 500px;
	}
	
	#tbl2 td:nth-child(2) {
		width: 200px;
		border-left:1px dashed #ddd;
		text-align:center;
	}
	
	#tbl2 td:nth-child(2) div:last-child {
		cursor:pointer;		

	}
	
	#good {
		text-align:center;
		margin:0px;
		padding-bottom:0;
		margin:20px;
		
	}
	
	#btngood, #btnbad {
		font-size:30px;
		margin:20px;
		
		cursor:pointer;
	}
	
	#good > div {
		display:inline-block;
		margin-top:200px;
	}
	
	#labelgood, #labelbad {
		color:#999;
		font-weight:bold;
		font-size:18px;
		margin:0px;
	}
	
	#good .good #btngood {
		color:cornflowerblue;
	}
	
	#good .bad #btnbad {
		color:#DC354D;
	}
	
	/* 이렇게도 사용 가능 */
	#div1 {
	
		position:relative;
		left:0px;
		top:0px;
	
	}
	
	#btnSort {
		
		position:absolute;
		top:0px;
		right:150px;
		border:1px solid;
		background-color:#F9F9F9;
		padding:7px;
		cursor:pointer;
	}
	
	#url {
		width:1px;
		height:1px;
		border:0;
		padding:0;
		margin:0;
	}
</style>
<script>
	$(function() {

		$("#btngood").click(function() {

			location.href = "/mvc/board/good.do?state=g&seq=${dto.seq}";
			
		});

		$("#btnbad").click(function() {

			location.href = "/mvc/board/good.do?state=b&seq=${dto.seq}";
		
		});

		$("#btnSort").click(function() {
			
			location.href = "/mvc/board/view.do?seq=${dto.seq}&sort=${sort}#tbl2";

			
			
						
		});

		// $("#url").hide(); 
		
	});


	function cdel(seq, pseq) {

		location.href = "/mvc/board/delcomment.do?seq=" + seq + "&pseq=" + pseq;

	}

	function edit(seq) {

		// <span>
		var comment = $(event.srcElement).parent().parent().parent().children().eq(0).text().trim();

		//alert(comment);
		$("#ccontent").val(comment);
		$("#btn1").val("수정하기");
		$("#cform").prop("action", "/mvc/board/editcomment.do");
		$("#seq").val(seq); // 수정할 댓글 seq
		
	}

	function search() {

		// #태그 클릭
		var tag = $(event.srcElement).text();
		// alert(tag);

		location.href = "/mvc/board/list.do?column=hashtag&word=" + tag;
		
	}

	function copy() {

		// Ctrl + C
		$("#url").val(location.href);
		$("#url").select();
		
		document.execCommand("copy"); /* 카피를 해준다 */

	}
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
				<td id = "content">
					${dto.content}
					<div id = "good">
						<div class = "<c:if test = '${gdto.good > 0}'>good</c:if>">
							<span class = "glyphicon glyphicon-thumbs-up" id = "btngood"></span>
							<div id = "labelgood">${gdto.good}</div>
						</div>
						<div class = "<c:if test = '${gdto.bad > 0}'>bad</c:if>">
							<span class = "glyphicon glyphicon-thumbs-down" id = "btnbad"></span>
							<div id = "labelbad">${gdto.bad}</div>
						</div>
					</div>
				</td>
				
			</tr>
			<tr>
				<th>날짜</th>
				<td>${dto.regdate}</td>
			</tr>
			<tr>
				<th>읽음</th>
				<td>${dto.readcount}</td>
			</tr>
			
		
			<tr>
				<th>파일</th>
				<td>
				<c:if test = "${!empty dto.orgfilename}">
				<a href = "/mvc/board/download.do?filename=${dto.filename}&orgfilename=${dto.orgfilename}&seq=${dto.seq}">
					${dto.orgfilename}
				</a> 
				(download : ${dto.downloadcount})
				</c:if>
				<c:if test = "${empty dto.orgfilename}">
				첨부파일이 없습니다.
				</c:if>
				</td>
			</tr>
			
			<tr>
			<th>해시태그</th>
			
			<td>
				<c:forEach items = "${tlist}" var = "tag">
				<span class = "btn btn-warning" style = "padding:3px;font-size:13px;" onclick = "search();">
				${tag}			
				</span>
				</c:forEach>
			</td>
			
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
				
				<c:if test = "${dto.notice == 0}">
				<input type = "button" value = "답글달기" class = "btn btn-primary"
					onclick = "location.href='/mvc/board/add.do?mode=reply&thread=${dto.thread}&depth=${dto.depth}';">
				</c:if>
				
				<input type = "button" value = "공유하기" class = "btn btn-warning"
					onclick = "copy();">
				<input type = "text" id = "url">
				
				
				<!-- 댓글 -->
				<form class = "form-inline" id = "cform" method = "post" action="/mvc/board/addcomment.do">
					<textarea name = "ccontent" id = "ccontent" required class = "form-control"></textarea>
					<input type = "submit" value = "댓글 쓰기" class = "btn btn-primary" id = "btn1">
					<input type = "hidden" name = "pseq" value = "${dto.seq}">
					<input type = "hidden" name = "seq" id = "seq">
				</form>
				
		
				
				<!-- <div>댓글목록</div> -->
				<div id = "div1">
					<table id = "tbl2" class = "table table-striped">
						<c:forEach items = "${clist}" var = "cdto">
						<tr>
							<td style = "vertical-align:middle;">
								${cdto.content}
							</td>
							<td>
								<div>${cdto.name}</div>
								<div>${cdto.regdate}</div>
								<c:if test = "${cdto.id == auth}">
									<div>
										<span class = "glyphicon glyphicon-edit" onclick = "edit(${cdto.seq});"></span>
										<span class = "glyphicon glyphicon-trash" onclick = "cdel(${cdto.seq}, ${dto.seq});"></span>
									</div>
								</c:if>
							</td>
						</tr>
						</c:forEach>
					</table> <!-- 댓글 리스트 테이블 -->
					
					<!-- 댓글 정렬 버튼 -->
					<c:if test = "${clist.size() > 0 && sort == 'desc'}">
					
					<span class = "glyphicon glyphicon-sort-by-attributes-alt" id = "btnSort"></span>
					
					</c:if>
					
					<c:if test = "${clist.size() > 0 && sort == 'asc'}">
					
					<span class = "glyphicon glyphicon-sort-by-attributes" id = "btnSort"></span>
					
					</c:if>
					
				</div>
				
		</div>
	
			
		
	</div>
</body>
</html>