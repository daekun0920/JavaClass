<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>
	#bigCont {
	
		width:900px;
		margin:0px auto;
	
	}
	
	hr {
	
	margin:10px;
	
	}
	
	#btns {
	
		text-align:center;
	
	}
</style>
<script>

</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header_main.jsp"></jsp:include>
	<form method = "post" action = "/enter/company/addnoticeok.do" enctype = "multipart/form-data">
		<div id = "bigCont">
			공지
			<br>
			<input type = "checkbox" id = "check" name = "check" value = "notice">
			<br>
			<hr style = "border-color:#CCC;">
			제목 
			<input type = "text" id = "title" name = "title" class = "form-control">
			<hr style = "border-color:#CCC;">
			첨부파일 
			<input type = "file" name = "file" >
			<hr style = "border-color:#CCC;">
			내용 
			<textarea id = "content" name = "content"  class = "form-control" style = "margin-bottom:30px;height:300px;"></textarea>
			<input type = "hidden" value = "${seq }" name = "seq">
			<div id = "btns">
				<a class = "btn btn-default" href = "/enter/company/notice.do">돌아가기</a>
				<button type = "submit" class = "btn btn-info">작성</button>
			</div>
		</div>
	</form>
	<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>