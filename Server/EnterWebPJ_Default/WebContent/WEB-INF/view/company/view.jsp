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
	#bigCont {
	
	width:800px;
	margin:0px auto;
	
	}
</style>
<script>

</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header_main.jsp"></jsp:include>
	
	<div id = "bigCont">
		<div>제목 : ${view.title }</div>
		<hr style = "border-color:#CCC;">
		<c:if test = "${!empty view.orgfile }">
			<div>첨부파일 : <a href = "/enter/company/download.do?filename=${view.file }&orgfilename=${view.orgfile}">${view.orgfile }</a></div>
			<hr style = "border-color:#CCC;">
		</c:if>
		<div>작성자 : ${view.staffname }</div>
		<hr style = "border-color:#CCC;">
		<div>작성시간 : ${view.time }</div>
		<hr style = "border-color:#CCC;">
		<div style = "height:300px;">${view.content }</div>
		<div style = "text-align:center;">
			
			<a class = "btn btn-danger" href = "/enter/company/delnotice.do?seq=${view.seq }&staff=${view.staffseq}" style = "">삭제하기</a>
			<a class = "btn btn-default" onclick = "history.back();" style = "">뒤로가기</a>
		</div>

	</div>
	
	
	<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>