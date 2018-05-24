<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>
	#head_name {
	
		width:900px;
		margin:0px auto;
		
	}
	
	#div_main {
	
		width:900px;
		margin:0px auto;
		border-left:1px solid #CCC;
		border-right:1px solid #CCC;
		padding:0 20px;
		opacity:0;
		position:relative;
		top:-30px;
	
	}
	
	#img1 {
		margin-right:20px;
		width:60%;
		height:40%;
		margin-left:20px;
		vertical-align:middle;
		float:left;
		border-radius:7px;
	}
	
	#cont1 {
		margin-left:20px;
		clear:both;
		color:#BBB;
		display:inline;
		line-height:2.1em;
		vertical-align:middle;
	}
	
</style>
<script>
	$(function() {
		$("#div_main").css("transition", "all 1.5s").css("opacity", "1").css("top", "0px");
	
	
	});
	
</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header_main.jsp"></jsp:include>
	<div id = "head_name">
	<h1>About JIP</h1>
	<hr>
	</div>
	
	<div id = "div_main">
		<img src = "/enter/images/about.jpg" id = "img1">
		<span id = "cont1">
			JIP Entertainment는 전세계에 ‘Made by JIP’ 콘텐츠를 통해 대중음악은 물론 한글, 한식 등 한국 고유의 문화를 알리고 있으며, 한국 브랜드 제품 소비를 촉진해 한국의 위상을 높이는데 앞장서고 있습니다. 그리고 ‘Culture first, Economy next’라는 캐치프레이즈로 문화가 국가경제를 리드하고, 성장에 기여하는 문화적 가치에 주목했습니다. JIP Entertainment는 전세계에서 우리 문화가 사랑 받을 때 우리 경제도 최고가 된다는 생각으로 대한민국이 ‘문화대국’과 ‘경제대국’이 되도록 엔터테인먼트 산업을 이끌어 나갈 것입니다.
		</span>
	</div>
	
	<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>