<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/highcharts.js"></script>
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>
	#chart {
		width:700px;
		height:100%;
	}
	
	#td1 {
	
		padding:0;
	}
</style>
<script>
	function view(id) {
		/* alert(id); */
		$(".table td").css("background-color", "#FFF");
		$(event.srcElement).css("background-color", "#ddd");

		// 특정 부서의 구성원 연봉 비율 가져와서 차트에 출력
		$.ajax({
			type:"POST",
			url:"/ajax/ex12data.do",
			data:"id=" + id,
			dataType:"json",
			success: function(result) {
			
				/* 
				$(result).each(function(index, item) {
					console.log(item.cnt, item.salary);
				}); 
				*/

				// result -> chart data format
				
				/*
				[
					{
						"name":"이름",
						"y":수치
					}
				]
				*/

				/* 
				var dataArray = [];

				$(result).each(function(index, item) {
					var obj = {};
					obj.name = item.salary;
					obj.y = item.cnt;
					dataArray.push(obj);
				});
				 */
				 
				Highcharts.chart('chart', {
				    chart: {
				        plotBackgroundColor: null,
				        plotBorderWidth: null,
				        plotShadow: false,
				        type: 'pie'
				    },
				    title: {
				        text: ''
				    },
				    tooltip: {
				        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				    },
				    plotOptions: {
				        pie: {
				            allowPointSelect: true,
				            cursor: 'pointer',
				            dataLabels: {
				                enabled: true,
				                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
				                style: {
				                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
				                }
				            }
				        }
				    },
				    series: [{
				        name: 'Brands',
				        colorByPoint: true,
				        data: result
				    }]
				});
				
			}

		});
			
	}
</script>
</head>
<body>
	<!--  -->
	<div class = "container">
		<h2 class = "page-header">Departments - Salary</h2>
		
		<table class = "table table-bordered">
			<tr>
				<th>Salary</th>
				<th>Department</th>
			</tr>
			<tr>
				<td rowspan = "${list.size() + 1}" id = "td1"><div id = "chart"></div></td>
				
			</tr>
			<c:forEach items = "${list}" var = "dto">
			<tr>
			
				<td style = "cursor:pointer;" onclick = "view(${dto.id});">${dto.name}</td>				
			
			</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">


		</script>
</body>
</html>