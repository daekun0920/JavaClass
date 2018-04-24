<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트</title>
<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>
	.container > div { width: 900px; margin: 30px auto; }
	
	#count > .countItem { width: 200px; height: 140px; padding: 20px; border-radius: 10px; text-align: right; float: left; margin-right: 20px; }
	
	#count > .countItem:nth-child(1) { background-color: #337AB7; }
	#count > .countItem:nth-child(2) { background-color: #5CB85C; }
	#count > .countItem:nth-child(3) { background-color: #F0AD4E; }
	#count > .countItem:nth-child(4) { background-color: #D9534F; }
	
	
	#count > .countItem > span { color: white; font-size: 50px; float: left; }
	#count > .countItem > div { color: white; }
	#count > .countItem > div:nth-child(2) { font-size: 40px; font-weight: bold; margin-top: 20px; }
	#count > .countItem > div:nth-child(3) { font-size: 15px; }
	
	
	#postCount { border: 1px solid #ccc; width: 850px; margin: 20px auto; padding: 0px; transform: translate(-20px, 0px); }
	
</style>
<script src="/mvc/js/highcharts.js"></script>
<script>
	
</script>
</head>
<body>
	<!-- WebContent > admin > index.jsp -->
	<div class="container">
		<jsp:include page="/inc/header.jsp"></jsp:include>
		<!-- 현황판 -->
		<h2 class="page-header">Dash Board</h2>
		
		<div id="count">
		
			<div class="countItem">
				<span class="glyphicon glyphicon-user"></span><!-- 아이콘 -->
				<div>${userCount}</div>
				<div>Total Users</div>
				<div style="clear:both;"></div>
			</div>
			
			<div class="countItem">
				<span class="glyphicon glyphicon-list-alt"></span>
				<div>${postCount}</div>
				<div>Total Posts</div>
				<div style="clear:both;"></div>
			</div>
			
			<div class="countItem">
				<span class="glyphicon glyphicon-tag"></span><!-- 아이콘 -->
				<div>${commentCount}</div>
				<div>Total Comments</div>
				<div style="clear:both;"></div>
			</div>
			
			<div class="countItem">
				<span class="glyphicon glyphicon-paperclip"></span><!-- 아이콘 -->
				<div>${mediaCount}</div>
				<div>Total Media</div>
				<div style="clear:both;"></div>
			</div>
		
			<div style="clear:both;"></div>
		</div><!-- count -->
		
		
		<!-- 차트 -->
		<div id="postCount"></div>
		
		
		
	</div><!-- class="container" -->
	
	<script type="text/javascript">

Highcharts.chart('postCount', {
    chart: {
        type: 'bar'
    },
    title: {
        text: 'Post Count'
    },
    xAxis: {
        categories: [
            <%--
        	<c:forEach items="${names}" var="name" varStatus = "status">
        	'${name}' <c:if test = "${status.count != names.size()}">,</c:if> 
        	</c:forEach>
        	--%>

        	${namesData}
        	
        ],
        title: {
            text: "회원명"
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: '게시물수',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    },
    tooltip: {
        valueSuffix: ' 개'
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
        name: '게시물수',
        data: [${postsData}]
    }, {
        name: '댓글수',
        data: [${commentsData}]
    }]
});
		</script>

</body>
</html>
