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
			url:"/ajax/api/ex01data.do",
			data:"query=" + $("#query").val(),
			dataType:"json",
			success: function(result) {

				/* for (var prop in result.items) { // 객체의 프로퍼티(멤버변수)를 알려준다.
					console.log(prop);


				}*/
				$("table tbody").html("");
				
				$(result.items).each(function(index, item) {
					// item -> JSON item 객체 -> 책 1권
					/* for (var prop in item) {
						//console.log(prop);	
					} */
					//console.log(item.title, item.price, item.publisher);
					var row = "<tr><td><img src= '" + item.image + "'></td><td><a href = '" + item.link + "'>" + item.title + "</a></td><td>" + item.author + "</td><td>" + item.price + "</td><td>" + item.publisher + "</td><td>" + item.pubdate + "</td></tr>";

					$("table tbody").append(row);
				});
			}
		});

	}
</script>
</head>
<body>
	<!-- ex01.jsp -->
	<div class = "container">
		<h2 class = "page-header">Open API - 네이버 책 검색</h2>
		
		<form id = "search" class = "form-inline">
			키워드 : <input type = "text" name = "query" id = "query" class = "form-control">
			<input type = "button" value = "검색하기" class = "btn btn-default" onclick = "search();">
		</form>
		
		
		<table class = "table table-striped">
			<thead>
				<tr>
					<th>표지</th>
					<th>제목</th>
					<th>저자</th>
					<th>가격</th>
					<th>출판사</th>
					<th>출판일</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>
</body>
</html>