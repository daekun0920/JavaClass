<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<div id = "header">
			<img src = "/enter/images/logo_w.png" id = "logo">
			<nav id = "nav1">
					<span class = "mainmenu" id = "comp_main">COMPANY</span>
					<span class = "column column-white"> | </span>
					<span class = "mainmenu" id = "artist_main">ARTISTS</span>
					<span class = "column column-white"> | </span>
					<span class = "mainmenu" id = "goods_main">GOODS</span>
					<span class = "column column-white"> | </span>
					<span class = "mainmenu" id = "aud_main">AUDITION</span>
					<span class = "column column-white"> | </span>
					<span class = "mainmenu" id = "concert_main">CONCERT</span>
			</nav>
		</div>
		<div id = "invisible">
			<a href="auth/signup.do" id="signup">Sign Up</a>
					<span class = "column signbar"> | </span>
			<a href="auth/login.do" id="auth">Login</a>
		</div>
		<div id = "parent">
			<div id = "submenu">
				<nav id = "comp_menu" class = "sub">
					<a href="/enter/promotion/company/about.do">About JIP</a>
					<span class = "column"> | </span>
					<a href="/enter/promotion/company/notice.do">Notice</a>
				</nav>
				<nav id = "artist_menu" class = "sub">
					<a href="/enter/promotion/artist/index_singer.do">Singer</a>
					<span class = "column"> | </span>
					<a href="/enter/promotion/artist/index_actor.do">Actor</a>
				</nav>
				<nav id = "goods_menu" class = "sub">
					<a href="/enter/promotion/index_goods.do">Goods</a>
					<span class = "column"> | </span>
					<a href="/enter/promotion/index_album.do">Album</a>
				</nav>
				<nav id = "aud_menu" class = "sub">
					<a >Notice</a>
					<span class = "column"> | </span>
					<a>Audition Schedule</a>
					<span class = "column"> | </span>
					<a>Online Audition</a>
					<span class = "column"> | </span>
					<a>Q & A</a>
				</nav>
				<nav id = "concert_menu" class = "sub">
					<a>Ticket</a>
					<span class = "column"> | </span>
					<a>Q & A</a>
				</nav>
			
			
			</div>
		</div>
<!-- <script>
	//현재 보고 있는 메뉴를 활성화
	//http://localhost:8089/mvc/auth/index.do
	//http://localhost:8090/enter/template_main.do
	var url = location.href;
	
	if (url.indexOf("/enter/auth/") > -1) {
		//인증 메뉴 선택
		$("#comp_menu").addClass("active");
	} else if (url.indexOf("/enter/board/") > -1) {
		//게시판 메뉴 선택
		$("#menu2").addClass("active");
	} else if (url.indexOf("/enter/admin/") > -1) {
		//관리자 메뉴 선택
		$("#menu3").addClass("active");
	}else{
		
		
	}
	
</script> -->