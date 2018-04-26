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

		$(function() {
		
			$("#department > input").click(function() {

				// 클라이언트 -> 부서명 -> 서버 -> 직원명단 -> 클라이언트 -> 화면 출력
				// location.href = "/ajax/ex09data.do?department=" + $(this).val();


				$.ajax ({
					type:"GET",
					url:"/ajax/ex09data.do",
					data: "buseo=" + $(this).val(),
					dataType:"xml",
					success: function(result) {
						// alert(result);
					
					/* <tr>
						<td>100</td>
						<td>홍길동</td>
						<td>기획부</td>
						<td>부장</td>
						<td>010-1234-5678</td>
					</tr> */
						
						$("table tbody").html("");
					
						$(result).find("item").each(function(index, item) {
							
							$("table tbody").append("<tr> <td>" + $(item).find("num").text() + "</td> <td>" + $(item).find("name").text() + "</td> <td>" + $(item).find("jikwi").text() + "</td> <td>" + $(item).find("tel").text() + "</td> </tr>");	
								
						});
							
					},
					error: function() {
						alert("오류 발생");
					}

				});
					
		
			});
			
		});

</script>
</head>
<body>
	<!-- ex09.jsp -->
	<div class = "container">
		<h2 class = "page-header">직원 목록</h2>
		
		<div class = "well" id = "department">
			<input type = "button" value = "기획부" class = "btn btn-default">
			<input type = "button" value = "영업부" class = "btn btn-default">
			<input type = "button" value = "개발부" class = "btn btn-default">
			<input type = "button" value = "총무부" class = "btn btn-default">
			<input type = "button" value = "인사부" class = "btn btn-default">
			<input type = "button" value = "자재부" class = "btn btn-default">
			<input type = "button" value = "홍보부" class = "btn btn-default">
		</div>
		
		
		<table class = "table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>직원명</th>
					<th>직위</th>
					<th>연락처</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan = "4">위의 부서를 선택하세요.</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>