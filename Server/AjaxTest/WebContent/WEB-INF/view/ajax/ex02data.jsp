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
	/* ex02.jsp에게 데이터 전달 */
	
	/* iframe 문서가 부모 문서 객체에 접근 */
	//top.document.title = "테스트";
	//top.document.getElementById("question").innerText 
	//		= "${dto.question}"; 
	$(top.document).find("#question").text("${dto.question}");
	$(top.document).find("#item1 span").eq(0).text("${dto.answer1}");
	$(top.document).find("#item1 span").eq(1).text("${dto.cnt1}");
	$(top.document).find("#item2 span").eq(0).text("${dto.answer2}");
	$(top.document).find("#item2 span").eq(1).text("${dto.cnt2}");
	$(top.document).find("#item3 span").eq(0).text("${dto.answer3}");
	$(top.document).find("#item3 span").eq(1).text("${dto.cnt3}");
	$(top.document).find("#item4 span").eq(0).text("${dto.answer4}");
	$(top.document).find("#item4 span").eq(1).text("${dto.cnt4}");
	$(top.document).find("#item1").css("width", "${dto.cnt1*40}px");
	$(top.document).find("#item2").css("width", "${dto.cnt2*40}px");
	$(top.document).find("#item3").css("width", "${dto.cnt3*40}px");
	$(top.document).find("#item4").css("width", "${dto.cnt4*40}px");
	
	setTimeout(function() {
		location.reload();
	}, 5000);
	
</script>
</head>
<body>
	<!-- ex02data.jsp -->
	<input type="button" value="새로고침"
		onclick="location.reload();">
</body>
</html>


























 