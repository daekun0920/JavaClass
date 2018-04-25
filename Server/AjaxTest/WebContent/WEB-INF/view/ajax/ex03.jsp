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
		
		//방법1. X
		/* $("#btnCheck").click(function() {
			location.href = "/ajax/idcheck.do?id=" + $("#id").val();
		}); */
		
		
		//방법2. O
		/* $("#btnCheck").click(function() {
			window.open("/ajax/idcheck.do?id=" + $("#id").val(), "idcheck"
										, "width=300, height=250");
		}); */
		
		
		//방법3. O -> Ajax
		$("#btnCheck").click(function() {
			$("#iframe1").attr("src", "/ajax/idcheck2.do?id=" + $("#id").val());
		});
		
	});
	
</script>
</head>
<body>
	<!-- ex03.jsp -->
	
	<iframe id="iframe1" style="display: none;"></iframe>
	
	<div class="container">
		<h2 class="page-header">회원 가입</h2>
		<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<td class="form-inline"><input type="text" name="name" id="name" class="form-control"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td class="form-inline"><input type="text" name="age" id="age" class="form-control"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td class="form-inline">
					<input type="text" name="id" id="id" class="form-control">
					<input type="button" value="중복 검사하기"
						id="btnCheck" class="btn btn-info">
					<span class="text-danger" id="result"></span>
				</td>
			</tr>
			<tr>
				<th>암호</th>
				<td class="form-inline"><input type="text" name="pw" id="pw" class="form-control"></td>
			</tr>
		</table>		
	</div>
</body>
</html>


























 