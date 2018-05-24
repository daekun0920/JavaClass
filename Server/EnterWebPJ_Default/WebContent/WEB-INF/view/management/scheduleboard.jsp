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
#tbl1 {
	width: 700px;
	margin: 0px auto;
}

#pagebar {
	text-align: center;
	position: absolute;	
	left:1rem;
	right:1rem;
	display:inline;
	margin-top:50px;
}

#tbl1 td, th {
	text-align: center;
}

th {

	background-color:#072946;
	color:white;

}
#tbl1 button {
	width: 20px;
	height: 15px;
}

body {

	padding-bottom:100px;

}
</style>
<script>
	function detailview(seq) {

		$.ajax ({
			type:"GET",
			url:"/enter/management/scheduleboarddata.do",
			data:"seq=" + seq + "&type=" + ${type},
			dataType:"json",
			success: function(result) {
				$("#tbl2").html("");
			
				$("#tbl2").append("<tr><td>행사명 : " + result["schedule_name"] + "</td></tr>");
				$("#tbl2").append("<tr><td>연예인 : " + result["star_name"] + "</td></tr>");
				$("#tbl2").append("<tr><td>주최사 : " + result["member_name"] + "</td></tr>");
				$("#tbl2").append("<tr><td>장소 : " + result["schedule_place"] + "</td></tr>");
				$("#tbl2").append("<tr><td>시작일 : " + result["schedule_start"] + "</td></tr>");
				$("#tbl2").append("<tr><td>종료일 : " + result["schedule_end"] + "</td></tr>");
				$("#tbl2").append("<tr><td>출연료 : " + result["schedule_pay"] + "원</td></tr>");
				$("#tbl2").append("<tr><td>타입 : " + result["schedule_type_name"] + "</td></tr>");
				$("#tbl2").append("<input id = 'seq' type = 'hidden' value ='" + result["schedule_seq"] + "'>");
				
				$("#maModal").modal("show");
				
			},
			error: function(a, b, c) {
				console.log(a, b, c);
				
			}
		
		});
		
	}
	
	function accept() {
		
		
		
		$.ajax ({
			type:"GET",
			url:"/enter/management/scheduleaccept.do",
			data:"seq=" + $("#seq").val() + "&type=" + ${type} + "&star=" + ${star},
			dataType:"json",
			success: function(result) {
				if (result["result"] == 1) {
					
					alert("수락을 완료하였습니다.");
					location.href = '';
				} else {
					
					alert("수락에 실패하였습니다.");
					location.href = '';
				}
				
				
			},
			error: function(a, b) {
				console.log(a, b);
				
			}
		
		});
		
		$("#maModal").modal("hide");
		location.href = "";	
	}
	
	function decline() {

		$.ajax ({
			type:"GET",
			url:"/enter/management/scheduledecline.do",
			data:"seq=" + $("#seq").val(),
			dataType:"json",
			success: function(result) {
				if (result["result"] == 1) {
					
					alert("거절을 완료하였습니다.");
					
				} else {
					
					alert("거절에 실패하였습니다.");
					
				}
				
				
			},
			error: function(a, b) {
				console.log(a, b);
				
			}
		
		});
		
		$("#maModal").modal("hide");
		
		location.href = "";
		
		
	}
	
	
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header.jsp"></jsp:include>
	<div style = "width:700px;margin:0px auto;margin-bottom:20px;">
		<h1 style = "">섭외 요청</h1>
	</div>
	<table id="tbl1" class="table table-striped">
		<tr>
			<th>번호</th>
			<th>행사명</th>
			<th>연예인명</th>
			<th>주최사</th>
			<th>상세보기</th>
		</tr>

		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="5">게시물이 존재하지 않습니다.</td>
			</tr>
		</c:if>

		<c:forEach items="${list}" var="dto">
			<tr>
				<td><span>${dto["schedule_seq"] }</span></td>
				<td><span>${dto["name"] }</span></td>
				<td><span>${dto["star_name"] }</span></td>
				<td><span>${dto["member_name"] }</span></td>
				<td><span onclick="detailview(${dto['schedule_seq']});"
						class="btn btn-info glyphicon glyphicon-search" style = "font-size:11px;"></span></td>
			</tr>
		</c:forEach>

	</table>
	<div style = "width:700px; margin:0px auto; padding-top:20px; text-align:right;">
		<a class = "btn btn-info" href = "/enter/management/addoffer.do?art_seq=${star}&type=${type}">글 쓰기</a>
		${pagebar}
	</div>
	<div class="modal fade" id = "maModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id = "mtitle">섭외 요청</h4>
				</div>
				<div class="modal-body" id = "mbody">
					<table id = "tbl2">
						
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary" onclick = "accept();">수락</button>
					<button type="button" class="btn btn-danger" onclick = "decline();">거절</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	


	

	<jsp:include page="/inc/footer.jsp"></jsp:include>


</body>
</html>