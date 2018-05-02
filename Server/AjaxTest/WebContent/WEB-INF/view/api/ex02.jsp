<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>

</style>
<script>
function search() {
	$.ajax({
		type:"GET",
		url:"/ajax/api/ex02data.do",
		data:"query=" + $("#query").val(),
		dataType:"json",
		success: function(result) {

			$("#tblResult tbody").html("");
			
			$(result["job-search"].jobs.job).each(function(index, item) {
			    // item -> 구직 1개
			    // active : 진행 여부(1:진행중, 0:마감)        			
				// position.title : 제목
				// position.location : 지역
				// position["job-type"] : 정규직
				// position["experience-level"] : 신입/경력

				var row = "";

				console.log(result);
				if (item.active == "1") {
					row += "<tr class = \"success\">"; 
						
				} else {
					row += "<tr class = \"danger\">"; 
				}
			
					row += "<td>" + item.position.title + "</td><td>" + item.position.location.content + "</td><td>" + item.position["job-type"].content + "</td><td>" + item.position["experience-level"].content + "</td></tr>"; 
				$("#tblResult tbody").append(row);
					
			});
		}
		
	});

}
</script>
</head>
<body>
	<!--  -->
	<div class = "container">
		<h2 class = "page-header">구직 정보 검색</h2>
		
		<form id = "search" class = "form-inline">
			키워드 : <input type = "text" name = "query" id = "query" class = "form-control">
			<input type = "button" value = "검색하기" class = "btn btn-default" onclick = "search();">
		</form>
		
		<table id = "tblResult" class = "table table-striped">
			<thead>
				<th>제목</th>
				<th>지역</th>
				<th>고용형태</th>
				<th>경력유무</th>
			</thead>
			<tbody>
				
			</tbody>
		</table>
		
	</div>
</body>
</html>