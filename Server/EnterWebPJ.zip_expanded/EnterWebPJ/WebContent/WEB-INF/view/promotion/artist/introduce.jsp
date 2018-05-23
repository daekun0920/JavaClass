<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>
	#page_title{ padding: 25px 0; font-weight: bold; text-align: center; width: 100%; height: 108;}
	#content {margin: 0 auto; width: 920px; padding:45px 0; border-top: 3px solid black; background-color: white;}
	#mini_cont{margin-left: 50px;}
	#actor_pic{margin-top:20px; }
	.title_txt{font-size: 12px; color: #949494;}
	.submenu li {font-size: 13px; list-style: none; margin-bottom: 13px; color: #949494; }

	a{text-decoration: none; color: #949494;}
	a:link{text-decoration: none; }
	a:hover {text-decoration: none; color:cornflowerblue;}
	#filmography {margin:-120px auto;  width: 920px; background-color: white; padding: 10px 0px;}
	#filmography > ul ul li { padding: 10px 0; font-size: 12px; border-bottom: 1px solid #e2e2e2; list-style: none;}

	.section{width: 1000px;}
	#drama, #movie{ float: left; width: 32%; margin: 30px auto;}


	
	h4{ margin: 30px 0px 0px 50px; float: left; width: 25%;}
	h5{ border-top: 3px solid black; padding-top: 20px;}
	ul{list-style: none; }
	

</style>
<script>

</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header_main.jsp"></jsp:include>
	
	<div id="container">
		<h2 id="page_title">ACTOR</h2>
		<div id="content" class="wrap">
			<div id="mini_cont">
				<div id="artist_box">
					<h3 class="mini_title">SEO KANG JOON</h3>
					<div class="title_txt">서강준 / 1993. 10.12</div>
				<div id="introduce">
					<div id="actor_pic" class="section">
						<img src="http://fncent.com/files/2016/12/19/d741048e66ac776ef14106ad471c2fd0142936.jpg" alt="사진">
					</div>
				</div>
			</div>
			</div>
		</div>
		<div id="menu" style="background-color: white; width: 150px; transform:translate(885px,-330px);">
			<ul class="submenu">
				<li><a href=#>MAIN</a></li>
				<li><a href=#>INTRODUCE</a></li>
				<li><a href=#>SCHEDULE</a></li>
				<li><a href=#>NOTICE</a></li>
				<li><a href=#>GALLERY</a></li>
			</ul>
		</div>
		<div id="filmography" class="sub_cont">
			<h4>Works&Achievements</h4>
			
				<ul>
					<li class="left_box">
						<div class="section" id="drama">
							<ul>
								<h5>DRAMA</h5>
								<li>2010 SBS 괜찮아, 아빠 딸 / 황연두 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
							</ul>
						</div>
					</li>
					<li class="right_box">
						<div class="section" id="movie">
							<ul>
								<h5>MOVIE</h5>
								<li>2010 SBS 괜찮아, 아빠 딸 / 황연두 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2010 SBS 괜찮아, 아빠 딸 / 황연두 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2010 SBS 괜찮아, 아빠 딸 / 황연두 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								
							</ul>
						</div>
					</li>
				</ul>
		</div>
	</div>
	
	
		
	
	<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>