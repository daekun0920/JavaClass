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
	
	$(function() {
		
		var msg = "";
		
		if (${result} == 1) {
			msg = "이미 사용중인 아이디입니다.";
		} else {
			msg = "사용 가능한 아이디입니다.";
		}
		
		$(top.document).find("#result").text(msg);
		
	});
	
</script>
</head>
<body>
	<!--  -->
	
</body>
</html>


























 