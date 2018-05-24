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
#calendar {
	width: 700px;
	margin: 0px auto;
	padding:0;
}

.datos {
	height: 100px;
	padding:0;
}

#head {
	text-align: center;
	background-color:#072946;
	height:50px;
	width:700px;
	margin:0px auto;
	color:white;
	padding-top:15px;
}

.dates {

	width:125px;
	padding:0;
}

.btn_st, .btn_en {
	float:right;

}

#calendar {

	margin-bottom:100px;

}


#big_cont {
	width:700px;
	background-color:white;
	margin:0px auto;
	border-radius:10px;

}

#left-btn, #right-btn {

	color:white;

}
</style>
<script>
	window.onload = function() {


	  kCalendar("cal");


	   
	}

	function sch() {
		
		$.ajax ({
			type:"GET",
			url:"/enter/management/schedule.do",
			data:"art_seq=" + "${art_seq}" + "&" + "name=" + "${name}",
			dataType:"json",
			success: function(result) {
					
				
				   
				   
				   $(result).each(function(index, item) {
					  
					   var Calendar = document.getElementById(item["schedule_start"].substring(0, 10));
					   
					 	$(Calendar).append("<button style = 'text-align:left;padding-bottom:13px; padding-right:30px;font-size:4px;width:2px; height:5px; margin-left:10px;margin-top:5px;' class = 'btn btn-info btn_st' onclick = 'detailschedule(" + item["schedule_seq"] + ");'>" + item["schedule_type_name"] + "</button>") 
						
					 	 var end = document.getElementById(item["schedule_end"].substring(0, 10));
					 	
					 	$(end).append("<button style = 'padding-bottom:13px; padding-right:30px;font-size:4px;width:2px; height:5px; margin-left:10px; margin-left:10px;margin-top:3px;' class = 'btn btn-danger btn_en' onclick = 'detailschedule(" + item["schedule_seq"] + ");'>" + item["schedule_type_name"] + "</button>") 
					 	
					 	
				   });
				   
				   
				   
				   
				   
				  
			}
		});
	}
	
		function kCalendar(id, date) {
			   var kCalendar = document.getElementById(id);

				//alert("hello");

				   if( typeof( date ) !== 'undefined' ) {

				   date = date.split('-');

				   date[1] = date[1] - 1;

				   date = new Date(date[0], date[1], date[2]);

				   } else {

				   var date = new Date();

				   }

				   var currentYear = date.getFullYear();

				   //년도를 구함



				   var currentMonth = date.getMonth() + 1;

				   //연을 구함. 월은 0부터 시작하므로 +1, 12월은 11을 출력



				   var currentDate = date.getDate();

				   //오늘 일자.



				   date.setDate(1);

				   var currentDay = date.getDay();

				   //이번달 1일의 요일은 출력. 0은 일요일 6은 토요일



				   var dateString = new Array('sun', 'mon', 'tue', 'wed', 'thu', 'fri', 'sat');

				   var lastDate = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

				   if( (currentYear % 4 === 0 && currentYear % 100 !== 0) || currentYear % 400 === 0 )

				   lastDate[1] = 29;

				   //각 달의 마지막 일을 계산, 윤년의 경우 년도가 4의 배수이고 100의 배수가 아닐 때 혹은 400의 배수일 때 2월달이 29일 임.



				   var currentLastDate = lastDate[currentMonth-1];

				   var week = Math.ceil( ( currentDay + currentLastDate ) / 7 );

				   //총 몇 주인지 구함.



				   if(currentMonth != 1)

				   var prevDate = currentYear + '-' + ( currentMonth - 1 ) + '-' + currentDate;

				   else

				   var prevDate = ( currentYear - 1 ) + '-' + 12 + '-' + currentDate;

				   //만약 이번달이 1월이라면 1년 전 12월로 출력.



				   if(currentMonth != 12) 

				   var nextDate = currentYear + '-' + ( currentMonth + 1 ) + '-' + currentDate;

				   else

				   var nextDate = ( currentYear + 1 ) + '-' + 1 + '-' + currentDate;

				   //만약 이번달이 12월이라면 1년 후 1월로 출력.





				   if( currentMonth < 10 )

				   var currentMonth = '0' + currentMonth;

				   //10월 이하라면 앞에 0을 붙여준다.



				   var calendar = '';



				   calendar += '<div id="head">';

				   calendar += '         <span><a href="#" class="button left" onclick="kCalendar(\'' +  id + '\', \'' + prevDate + '\');"><span id = "left-btn" class = "glyphicon glyphicon-chevron-left"></span></a></span>';

				   calendar += '         <span id="date">' + currentYear + '-' + currentMonth + '</span>';

				   calendar += '         <span><a href="#" class="button right" onclick="kCalendar(\'' + id + '\', \'' + nextDate + '\');"><span id = "right-btn" class = "glyphicon glyphicon-chevron-right"></span></a></span>';

				   calendar += '      </div>';

				   calendar += '      <table border="0" cellspacing="0" cellpadding="0" class = "table" id = "calendar">';


				   calendar += '         <thead>';

				   calendar += '            <tr class = "">';

				   calendar += '               <th class="sun" scope="row">일</th>';

				   calendar += '               <th class="mon" scope="row">월</th>';

				   calendar += '               <th class="tue" scope="row">화</th>';

				   calendar += '               <th class="wed" scope="row">수</th>';

				   calendar += '               <th class="thu" scope="row">목</th>';

				   calendar += '               <th class="fri" scope="row">금</th>';

				   calendar += '               <th class="sat" scope="row">토</th>';

				   calendar += '            </tr>';

				   calendar += '         </thead>';

				   calendar += '         <tbody>';



				   var dateNum = 1 - currentDay;



				   for(var i = 0; i < week; i++) {

					   calendar += '         <tr class = "datos">';
	
					   for(var j = 0; j < 7; j++, dateNum++) {
	
						   if( dateNum < 1 || dateNum > currentLastDate ) {
		
						   calendar += '            <td class="' + dateString[j] + ' dates"> </td>';
		
						   continue;
		
						   }
						   
						var datedate = "" + dateNum;
						if (datedate.length < 2) {
							console.log(dateNum.length);
							datedate = "0" + datedate;
							
						}
						var fulldate = currentYear + "-" + currentMonth + "-" + datedate;
						
						
							calendar += '            <td class="' + dateString[j] + ' dates" id = "' + currentYear + '-' + currentMonth + '-' + datedate + '">' + dateNum 
	  	 					+ '</td>';
							
						
					  }
	
					   calendar += '         </tr>';

				   }



				   calendar += '         </tbody>';

				   calendar += '      </table>';


					//console.log(calendar);
				   kCalendar.innerHTML = calendar;

				sch();
		
		}
		function detailschedule(seq) {
			
			$.ajax ({
				type:"GET",
				url:"/enter/management/detailschedule.do",
				data:"schedule_seq=" + seq + "&type=" + ${type},
				dataType:"json",
				success: function(result) {
					$("#mymodal_body").html("");
					$("#mymodal_foot").html("");
						
					$("#mymodal_body").append("<table class = 'table table-striped table-bordered' id = 'cal-tbl'>");
					$("#cal-tbl").append("<tr><td>" + "주최사 </td><td>" + result["member_name"] + "</td></tr>");
					$("#cal-tbl").append("<tr><td>" + "행사명 </td><td>" + result["name"] + "</td></tr>");
					$("#cal-tbl").append("<tr><td>" + "장소 </td><td>" + result["schedule_place"] + "</td></tr>");
					$("#cal-tbl").append("<tr><td>" + "출연료 </td><td>" + result["schedule_pay"] + "원</td></tr>");
					$("#cal-tbl").append("<tr><td>" + "타입   </td><td>" + result["schedule_type_name"] + "</td></tr>");
					$("#cal-tbl").append("<tr><td>" + "시작 날짜 </td><td>" + result["schedule_start"] + "</td></tr>");
					$("#cal-tbl").append("<tr><td>" + "종료 날짜  </td><td>" + result["schedule_end"] + "</td></tr>");
					$("#cal-tbl").append("</table>");
					
					$("#mymodal_foot").append("<button type='button' class='btn btn-primary' onclick = 'del(" + result["schedule_seq"] + ")'>Delete</button>");
					$("#mymodal_foot").append("<button type='button' class='btn btn-primary' onclick = 'load(" + result["schedule_seq"] + ");'>Edit</button>");
				
					
					$('#myModal').modal('show');
				}
					
			
			
			});
			
			
		}
	
	      function del(seq) {
	    	  if (confirm("정말로 삭제하시겠습니까?") == true) {
	    	  
	    		$.ajax ({
	    			type:"GET",
	    			url:"/enter/management/delschedule.do",
	    			data:"seq=" + seq,
	    			dataType:"json",
	    			success: function(result) {
	    					
	    				
	    				   
	    				   
	    				if (result == 1) {
	    					
	    					alert('삭제를 완료했습니다.');
	    					location.href = "";
	    				}   
							    				  
	    			}
	    		});
	    		
	    		
	    	  }
	    	  
	    	  $('#myModal').modal('hide');
	    	  
	    	  
	      }
	      
	      function load(seq) {
	    	  $.ajax ({
					type:"GET",
					url:"/enter/management/detailschedule.do",
					data:"schedule_seq=" + seq,
					dataType:"json",
					success: function(result) {
						$('#myModal').modal('hide');
						
						
						$("#scseq").val(result["schedule_seq"]);
						$("#artseq").val(result["art_seq"]);
						
						$("#scname").val(result["name"]);
						$("#scplace").val(result["schedule_place"]);
						$("#scstart").val(result["schedule_start"]);
						$("#scend").val(result["schedule_end"]);
						$("#scpay").val(result["schedule_pay"]);
						
						
						
			
						$('#editModal').modal('show');
					}
						
				
				
				});
	    	  
	    	  
	      }
			
	   
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header.jsp"></jsp:include>
	<div id = "big_cont">
	<div style = "text-align:center; margin-bottom:20px;"><b>${name}</b> 님의 스케쥴</div>
	<div id="cal"></div>

	<div class="modal fade" id = "myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">${name} 님의 스케쥴</h4>
				</div>
				<div class="modal-body" id = "mymodal_body">
					
				</div>
				<div class="modal-footer" id = "mymodal_foot">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	<!-- 수정 모달 -->
	<form action = "/enter/management/editschedule.do" method = "post">
	<div class="modal fade" id = "editModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">${name} 님의 스케쥴</h4>
				</div>
				<div class="modal-body">
						<input type = "hidden" id = "artseq" name = "artseq" value = "${name}">
							
							<input type = "hidden" id = "scstar" name = "scstar" value = "${name}">
							<input type = "hidden" id = "scseq" name = "scseq">
					행사명  <input type = "text" id = "scname" name = "scname" class = "form-control" style = "margin:10px;" placeholder = "행사명">
					장소  <input type = "text" id = "scplace" name = "scplace" class = "form-control"  style = "margin:10px;"  placeholder = "장소">
					시작일  <input type = "text" id = "scstart" name = "scstart" class = "form-control"  style = "margin:10px;"  placeholder = "시작일">
					종료일  <input type = "text" id = "scend" name = "scend" class = "form-control"  style = "margin:10px;"  placeholder = "종료일">
					출연료  <input type = "text" id = "scpay" name = "scpay" class = "form-control"  style = "margin:10px;"  placeholder = "출연료">
				</div>
				<div class="modal-footer" id = "editmodal_foot">
					<input type="submit" class="btn btn-default" value = "edit">
					
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	</form>
	</div>
	<jsp:include page="/inc/footer.jsp"></jsp:include>

</body>
</html>