<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>
#big-cont {
	margin: 0px auto;
	width: 740px;
	background-color: black;
}

#cont-cont {
	margin: 0px auto;
	width: 740px;
	margin-top:20px;
	margin-bottom:20px;
	box-shadow:2px 2px 5px;
	padding:20px;	
	position:relative;
	background-color:white;
}
#cont2 {
	
	position:absolute;
	bottom:52px;
	right:0;
	width: 350px;
	display:inline;
	
}

#board-cont{
	width: 350px;
	font-size: 11px;
	height: 100px;
	padding: 5px;
	display:inline;
}

#tbl-notice {
	border-color: white;
	border-collapse: collapse;
	background-color: white;
	box-shadow: 2px 3px 5px;
	width:350px;
}

.seq {
	width: 50px;
}

th {
	text-align: center;
	color: white;
	background-color:#072946;
}

.title, .seq, .visit {
	text-align: center;
	width: 200px;
}
</style>
<script>
	
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header_main.jsp"></jsp:include>
	<div id="big-cont">
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel" id="carcar">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" id="wrapper">
				<div class="item active">
					<img src="/enter/images/audience.jpg">
					<div class="carousel-caption"></div>
				</div>
				<div class="item">
					<img src="/enter/images/audience.jpg">
					<div class="carousel-caption"></div>
				</div>

			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>

	</div>
	<div id="cont-cont">
		<div id="board-cont">
			<h4>공지사항</h4>
		<hr style = "color:black;border-color:black;margin-left:5px;margin-right:5px;">
			<table class="table" id="tbl-notice">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>조회 수</th>
				</tr>


				<c:forEach items="${list }" var="dto">

					<tr>
						<td class="seq">${dto.seq }</td>
						<td class="title"><a
							href="/enter/company/view.do?seq=${dto.seq}">${dto.title }</a></td>
						<td class="visit">${dto.visitors }</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
		<div id = "cont2">
			<h4>이달의 뮤지션</h4>
			<hr style = "color:black;border-color:black;margin-left:5px;margin-right:5px;">
			<iframe width="340" height="353" src="https://www.youtube.com/embed/d9IxdwEFk1c" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style = "display:inline;box-shadow:2px 2px 5px;"></iframe>
		</div>
			
	</div>
	
	<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>