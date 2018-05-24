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
#subcont input {
	
	width: 500px;
	margin-bottom: 20px;
	display: inline-block;
}

#sel1 {
	text-align: right;
	width: 100px;
	margin-bottom: 20px;
	
}

#subcont {
	text-align: right;
	width: 700px;
	margin: 0px auto;
}

#container {
	width: 1200px;
}

.text {

	font-size:14px;
	margin-bottom:10px;
}
</style>
<script>
	$(function() {
		
		// 날짜 수정 & 인서트 시작일 끝일 대소 비교 유효성 검사
		
		
		$("#schedule_start").change(function() {
			$(this.val($(this).val().replace("T", " ")));		
			
		});
		$("#schedule_end").change(function() {
			$(this.val($(this).val().replace("T", " ")));		
			
		});
	});
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header.jsp"></jsp:include>
	<div id="div1" style="margin: 0px auto; width: 1200px; margin-bottom: 30px;">
		<h1 style="margin: 0px auto; width: 700px;">
			섭외 요청 <small>요청하기</small>
		</h1>
		<hr style = "border-color:#CCC; width:700px;">
	</div>
	<form method = "post" action = "/enter/management/addofferdata.do" id = "fm1">
		<div id="container">
			<div id="subcont">
				<div style="width: 700px; margin: 0px auto;" id = "cont">
					<select id="sel1" class="form-control" name = "seltype">
						<option value="1">드라마</option>
						<option value="2">영화</option>
						<option value="3">예능</option>
						<option value="4">녹음</option>
						<option value="5">공연</option>
						<option value="6">라디오</option>
					</select>
				</div>
				<div class = "text">행사명</div><input type="text" class="form-control" name = "schedule_name" id = "schedule_name" required><!-- 행사명, 스케줄장소, 시작시간, 종료시간, 출연료, 스케줄 타입 -->
				
				<div class = "text">장소</div><input type="text" class="form-control" name = "schedule_place" id = "schedule_place" required> 
				
				<div>
				
					<div class = "text">시작시간</div><input type="datetime-local" class="form-control" name = "schedule_start" id = "schedule_start" style = "width:270px;" required> 
			
				
					<div class = "text">종료시간</div><input type="datetime-local" class="form-control" name = "schedule_end" id = "schedule_end"  style = "width:270px;" required>
				
				</div>
				
				<div class = "text">출연료</div><input type="text" class="form-control" name = "schedule_pay" id = "schedule_pay" required>
				
				<input type = "hidden" value = "${art_seq}" name = "art_seq" id = "art_seq">
				<input type = "hidden" value = "${type}" name = "type" id = "type">
				 
			</div>
			
			<div style = "width:700px;margin:0px auto;text-align:right;">
				<button class = "btn btn-info" id = "subbtn" type = "submit">등록</button>
				<button class = "btn btn-default" onclick = "history.back();">돌아가기</button>
			</div>
		</div>
	</form>
	<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>