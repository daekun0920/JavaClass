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
	#keyword {
	
		width:500px;
		display:inline;
	}
	
	#search {

		
	
	}
	
	#opt {
		display:inline;
		width:100px;
	
	}
	
	#bigContainer {
	
		margin:0px auto;
	
	
	}
	
	.container {
	
		width:700px;
	
	}
	
	td {
	
	width:350px;
	
	}
	
	#tbl1 {
		width:650px;
		margin-top:40px;
		text-align:center;
	}
	
	#header_tr {
		background-color:#072946;
		color:white;
		border-top:1px solid #CCC;
		border-bottom:1px solid #CCC;
		
	}
</style>
<script>
	$(function() {
	
		//alert($("#opt").val());
		$("#keyword").on('keydown', function(event) {
			if (event.keyCode == 13) {
				$("#search").click();
			}
		}) 
	});
	function search() {
		
		$.ajax ({
			type:"GET",
			url:"/enter/management/schedulesearchdata.do",
			data:"keyword=" + $("#keyword").val() + "&" + "type=" + $("#opt").val(),
			dataType:"json",
			success: function(result) {
				var count = 0;
				$("#tb1").html("");
				
				$(result).each(function (index, item) {
					count++;
					
					$("#tb1").append("<tr><td>" + item.name + "</td><td><a href = '/enter/management/scheduleview.do?art_seq=" + item["artist_seq"] + "&name=" + item.name + "&type=" + $("#opt").val() + "'>스케쥴</a></td></tr>")
					
				});
				
				$("#tb1").append("<p style = 'margin:0px auto;'>검색 결과 '" + $("#keyword").val() + "' 총 '" + count + "' 건 입니다.")
				
			},
			error: function(a, b, c) {
				console.log(a, b, c);
				
			}
				
		
		});
		
	}
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header.jsp"></jsp:include>
	<div style = "width:700px;margin:0px auto;margin-bottom:20px;">
		<h1 style = "">스케쥴 검색</h1>
	</div>
	
	
	<div id = "bigContainer">
		<div class = "container">
				<select class = "form-control" id = "opt">
					<option value = "1">가수</option>
					<option value = "2">배우</option>
					<option value = "3">그룹</option>
				</select>
				<input type = "text" id = "keyword" class = "form-control">
				<button type = "submit" id = "search" class = "btn btn-info" onclick = "search();">
					<span class = "glyphicon glyphicon-search"></span>
				</button>
		</div>
		
		<div class = "container" id = "tbl_cont">
			<table class = "table table-hover" id = "tbl1">
				<thead>
					<tr id = "header_tr">
						<td>이름</td>
						<td>스케쥴 관리</td>
					</tr>
				</thead>
				<tbody id = "tb1">
					
				</tbody>
			</table>
		
		</div>
	</div>
	
	<jsp:include page="/inc/footer.jsp"></jsp:include>
	
</body>
</html>