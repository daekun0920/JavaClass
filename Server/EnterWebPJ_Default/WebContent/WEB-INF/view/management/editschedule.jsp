<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>

</style>
<script>
	$(function() {
		
		if (${result} == 1) {
			
			alert("수정을 완료했습니다.");
			location.href = "/enter/management/scheduleview.do?art_seq=" + "${artseq}" + "&name=" + "${starname}";
			
		} else {
			
			alert("수정에 실패했습니다.");
			location.href = "/enter/management/scheduleview.do?art_seq=" + "${artseq}" + "&name=" + "${starname}";
			
			
			
		}
		
		
	});
	
	
</script>
</head>
<body>
	
</body>
</html>