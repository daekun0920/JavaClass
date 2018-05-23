<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	width:100px;
	
	}
	
	table {
		
		margin-top:40px;
		
	}
	
	#header_tr {
	
		border-top:1px solid #CCC;
		border-bottom:1px solid #CCC;
		
	}
	table {
	
		text-align:center;
	
	}
</style>
<script>
	$(function() {
	
		//alert($("#opt").val());
		
	});
	function search() {
		
		$.ajax ({
			type:"GET",
			url:"/enter/management/ScheduleSearchData.do",
			data:"keyword=" + $("#keyword").val() + "&" + "type=" + $("#opt").val(),
			dataType:"json",
			success: function(result) {
				var count = 0;
				$(result).each(function (index, item) {
					count++;
					
					$("#tb1").append("<tr><td>" + item.name + "</td><td><a href = '/enter/management/scheduleview.do?art_seq=" + item["artist_seq"] + "'>스케쥴</a></td></tr>")
					
				});
				
				$("tbl_cont").append("<p>검색 결과 '" + $("#keyword").val() + "' 총 " + count + "' 건 입니다.")
				
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
			<table class = "table table-hover">
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