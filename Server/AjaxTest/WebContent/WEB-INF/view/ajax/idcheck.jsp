<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>

</style>
<script>
	function use() {
		
		//아이디를 부모창에 복사
		$(opener.document).find("#id").val($("#id").val());
		
		//opener.document.getElementById("id").value
		//		= document.getElementById("id").value;
		
		
		//창닫기
		window.close();
		
	}
</script>
</head>
<body>
	<!-- idcheck.jsp -->
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">아이디 중복검사</div>
			<div class="panel-body">
				<form method="POST" action="/ajax/idcheck.do">
					<input type="text" id="id" name="id" class="form-control"
						value="${id}">
					<input type="submit" value="검사하기"
						class="btn btn-info">
				</form>
				
				<c:if test="${!empty result && result == 1 }">
				<div class="alert alert-danger">이미 사용중인 아이디입니다.</div>
				</c:if>
				
				<c:if test="${!empty result && result == 0 }">
				<div class="alert alert-success">사용 가능한 아이디입니다.</div>
				<input type="button" value="사용하기" class="btn btn-info"
					onclick="use();">
				</c:if>
			</div>
		</div>
		
	</div>
</body>
</html>


























 