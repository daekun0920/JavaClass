<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/css/jquery-ui.css">
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/jquery-ui.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>
	#btnAdd {
	
		font-size:3em;
		border:1px solid #CCC;
		padding:5px;
		border-radius:50%;
		position:fixed;
		right:10px;
		top:10px;
		cursor:pointer;
		
	}
</style>
<script>
	var n = ${list.size() + 1}; // 고양이 번호


$(function() {
	
	// 고양이 초기 위치 지정
	<%--
	$("#cat1").css("left", "${list.get(0).left}px");
	$("#cat1").css("top", "${list.get(0).top}px");
	--%>
	 $(".cat").draggable({
			stop: function(event, ui) {
				

				var id = this.id;
		
				var left = ui.position.left;
				var top = ui.position.top;
				
				// console.log(left, top);
				$.ajax({
					type:"POST",
					url:"/ajax/ex13data.do",
					data: {
						"id":id,
						"left":left,
						"top":top
					},
					dataType:"json",
					success: function(result) {
						if (result == 0) {
							alert("고양이 위치 저장 실패");
						}
					},
					error: function(a, b, c) {
						console.log(a, b, c);
					}
				}) 
				
			}
		}); 
	
	<c:forEach items = "${list}" var = "dto">
		$("#${dto.id}").css("left", "${dto.left}px");
		$("#${dto.id}").css("top", "${dto.top}px");
	</c:forEach>

	
	
	$("#btnAdd").click(function() {

		
		$(document.body).append("<img src = '/ajax/images/catty01.png' id = 'cat" + n + "' class = 'cat'>");
		n++;

		// 새로 추가된 고양이들
		 $(".cat").draggable({
				stop: function(event, ui) {
					

					var id = this.id;
			
					var left = ui.position.left;
					var top = ui.position.top;
					
					// console.log(left, top);
					$.ajax({
						type:"POST",
						url:"/ajax/ex13data.do",
						data: {
							"id":id,
							"left":left,
							"top":top
						},
						dataType:"json",
						success: function(result) {
							if (result == 0) {
								alert("고양이 위치 저장 실패");
							}
						},
						error: function(a, b, c) {
							console.log(a, b, c);
						}
					}) 
					
				}
			}); 
	});
	
});
</script>
</head>
<body>
	<!--  -->
	<!-- <img src = "/ajax/images/catty01.png" id = "cat1"> -->
	<c:forEach items = "${list}" var = "dto">
		<img src = "/ajax/images/catty01.png" id = "${dto.id}" class = "cat">	
	</c:forEach>
	<span class = "glyphicon glyphicon-plus" id = "btnAdd" class = "cat"></span>
</body>
</html>