<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		<jsp:include page="/inc/asset.jsp"></jsp:include>
		<style type="text/css">
		
		</style>
	</head>
	<body>
<script src="/enter/code/highcharts.js"></script>
<script src="/enter/code/modules/exporting.js"></script>
<script src="/enter/code/modules/export-data.js"></script>
<jsp:include page="/inc/header.jsp"></jsp:include>
	

	
	
<div id="container" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
		


<script type="text/javascript">

$.ajax ({
	type:"GET",
	url:"/enter/schedulechart.do",
	dataType:"json",
	success: function(result) {
		var array = new Array();
		
		var arrayz = new Array();
		
		$(result).each(function(index, item) {
			array.push(item.star_name);
			
			arrayz.push(item.times *= 1);
		});
	
		Highcharts.chart('container', {
		
				
				    chart: {
				        type: 'bar'
				    },
				    title: {
				        text: '2018 스케쥴 간단 도표'
				    },
				    xAxis: {
				        categories: array,
				        title: {
				            text: null
				        }
				    },
				    yAxis: {
				        min: 0,
				        title: {
				            text: '건',
				            align: 'high'
				        },
				        labels: {
				            overflow: 'justify'
				        }
				    },
				    tooltip: {
				        valueSuffix: '건'
				    },
				    plotOptions: {
				        bar: {
				            dataLabels: {
				                enabled: true
				            }
				        }
				    },
				    legend: {
				        layout: 'vertical',
				        align: 'right',
				        verticalAlign: 'top',
				        x: -40,
				        y: 80,
				        floating: true,
				        borderWidth: 1,
				        backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
				        shadow: true
				    },
				    credits: {
				        enabled: false
				    },
				    series: [{
				        name: 'Year 2018',
				        data: arrayz
				    }]
			
		});
	},
	error: function(a, b, c) {
		console.log(a, b, c);
		
	}
		

});


		</script>
		
		<jsp:include page="/inc/footer.jsp"></jsp:include>
	</body>
</html>
