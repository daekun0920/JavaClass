function init() {
	
	$("#submenu").hide();
	$("#invisible").hide();
	$(".sub").hide();
	
}

$(function() {
	/* 홍보용 메뉴*/	
	$("#comp_main").mouseover(function() {
		init();
		
		
		$("#submenu").show();
		$("#comp_menu").show();
		
		
	});
	
	$("#artist_main").mouseover(function() {
		init();
		
		
		$("#submenu").show();
		$("#artist_menu").show();
		
		
	});
	
	$("#goods_main").mouseover(function() {
		init();

		
		$("#submenu").show();
		$("#goods_menu").show();


	});
	
	$("#aud_main").mouseover(function() {
		init();
			
		
		$("#submenu").show();
		$("#aud_menu").show();


	});
	
	$("#concert_main").mouseover(function() {
		init();

		
		$("#submenu").show();
		$("#concert_menu").show();


	});
	
	/*직원용 메뉴*/
	
	$("#manage_main").mouseover(function() {
		init();

		
		$("#submenu").show();
		$("#manage_menu").show();


	});
		
	$("#new_main").mouseover(function() {
		init();

		
		$("#submenu").show();
		$("#new_menu").show();


	});
		


	// 서브 메뉴 감추기
	$("#submenu").mouseleave(function() { 

		$("#submenu").hide();
			$("#comp_menu").hide();
			$("#goods_menu").hide();
			$("#concert_menu").hide();
			$("#aud_menu").hide();
			$("#artist_menu").hide();
			$("#new_menu").hide();
			$("#manage_menu").hide();
		$("#invisible").show();
		
	});
		
		

});