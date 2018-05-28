<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "/memo/resources/css/memo.css">
<link rel = "stylesheet" href = "/memo/resources/css/bootstrap.css">
</head>
<body>	
	<!--  -->
	
	<div class = "container">
		<h2 class = "page-header">메모장</h2>
		
		<section>
			
			<nav>메모 > 메모쓰기</nav>
			
			<form method = "post" action = "/memo/addok.memo">
				
				<table id = "tbl" class = "table table-bordered">
					<tr>
						<th>작성자</th>
						<td>${auth }</td>
					</tr>
					<tr>
						<th>카테고리</th>
						<td>
							<select name = "category" class = "form-control">
								<option value = "1">할일</option>
								<option value = "2">스터디</option>
								<option value = "3">업무</option>
								<option value = "4">서비스</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>메모</th>
						<td><textarea name = "memo" class = "form-control" style = "height:150px;"></textarea></td>
					</tr>
				</table>
				<input type = "submit" class = "btn btn-info">
			</form>
			
		</section>
	
	</div>
	
</body>
</html>