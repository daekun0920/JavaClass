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
	#dv1 {
		height:500px;
		width:900px;
		margin:0px auto;
		padding:0;
	}
	
	.card {
		text-align:center;
		display:inline-block;
		width:230px;
		background-color:white;
		box-shadow:4px 4px 5px #777;
		border-radius:10px;
		height:350px;
		margin:0px auto;
		margin-right:30px;
	}
	
	#cont {
	
		margin:0px auto;
		width:800px;
	
	}
</style>
<script>
	function changestaff(num) {
		
		$.ajax ({
			type:"GET",
			url:"/enter/management/currentstaff.do",
			data:"stafftype=" + num + "&star=${star}",
			dataType:"json",
			success: function(result) {
					$("#mname").html("");	
					$("#mseq").html("");	
					$(".modal-footer").html("");
					
					if (num == 1) {
						
						$("#mname").append("<span>현재 스타일리스트 : " + result["staff_name"]);
						$("#mseq").append("<span>현재 스타일리스트 번호: " + result["staff_seq"]);
						
						$(".modal-footer").append(" <button type='button' class='btn btn-default' data-dismiss='modal'>닫기</button>");
						$(".modal-footer").append("<button type='button' class='btn btn-primary' onclick = 'addstaff(1);'>스태프 지정/변경</button>");
					} else if (num == 2) {
						$("#mname").append("<span>현재 운전기사 : " + result["staff_name"]);
						$("#mseq").append("<span>현재 운전기사 번호: " + result["staff_seq"]);
						
						$(".modal-footer").append(" <button type='button' class='btn btn-default' data-dismiss='modal'>닫기</button>");
						$(".modal-footer").append("<button type='button' class='btn btn-primary' onclick = 'addstaff(2);'>스태프 지정/변경</button>");
					} else {
						$("#mname").append("<span>현재 트레이너 : " + result["staff_name"]);
						$("#mseq").append("<span>현재 트레이너 번호: " + result["staff_seq"]);
						
						$(".modal-footer").append("<button type='button' class='btn btn-default' data-dismiss='modal'>닫기</button>");
						$(".modal-footer").append("<button type='button' class='btn btn-primary' onclick = 'addstaff(3);'>스태프 지정/변경</button>");
					}
					
			
				$("#maModal").modal("show");
				
			},
			error: function(a, b) {
				console.log(a, b);
				
			}
				
		
		});
		
		
		
	}
	
	function addstaff(num) {
		$.ajax ({
			type:"GET",
			url:"/enter/management/addstaff.do",
			data:"stafftype=" + num + "&star=${star}&staff=" + $("#staffsel").val(),
			dataType:"json",
			success: function(result) {
				if (result["result"] == 1) {
					alert("스태프를 지정/변경 하였습니다.");
					
					location.href = "";
				} else {
					alert("스태프를 지정/변경 하지못했습니다.");
					
					location.href = "";
				}
				
			},
			error: function(a, b, c) {
				console.log(a,b,c);
				
			}
				
		
		});
		
	}
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header.jsp"></jsp:include>
	<div style = "margin:0px auto;width:800px; margin-bottom:30px;">
	<h1>스텝 매칭</h1>
	</div>
	
	<div id = "dv1">
		<div id = "cont">
			<div class = "card" style = "position:relative;">
				<div class = "glyphicon glyphicon-scissors" style = "font-size:70px;margin:0px auto;margin-top:50px;"></div>
					<div style = "margin-top:40px;text-shadow:none;">스타일리스트</div>
				<button class = "btn btn-info" style = "display:block;margin:0px auto;margin-top:100px;" onclick = "changestaff(1);">변경하기</button>
			</div>
			<div class = "card" style = "position:relative;">
				<div class = "glyphicon glyphicon-road" style = "font-size:70px;margin:0px auto;margin-top:50px;"></div>
					<div style = "margin-top:40px;text-shadow:none;">운전기사</div>
				<button class = "btn btn-info" style = "display:block;margin:0px auto;margin-top:100px;" onclick = "changestaff(2);">변경하기</button>
			</div>
			<div class = "card" style = "position:relative;">
				<div class = "glyphicon glyphicon-scale" style = "font-size:70px;margin:0px auto;margin-top:50px;"></div>
					<div style = "margin-top:40px;text-shadow:none;">트레이너</div>
				<button class = "btn btn-info" style = "display:block;margin:0px auto;margin-top:100px;" onclick = "changestaff(3);">변경하기</button>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id = "maModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">스텝 매칭</h4>
	      </div>
	      <div class="modal-body">
	     
	      		<div id = "mseq"></div>
	      		<div id = "mname"></div>
	    
	      		<select class = "form-control" style = "margin:0px auto;" id = "staffsel">
	      			<c:forEach items = "${list}" var = "dto">
	      				<option value = "${dto['staff_seq']}">${dto['staff_name']} - ${dto['staff_seq']}</option>
					</c:forEach>
	      		</select>
	      </div>
	      <div class="modal-footer">
	       
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>