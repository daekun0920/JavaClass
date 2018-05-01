function init() {
		$("#invisible").hide();
		$("#submenu").hide();
		$(".sub").hide();

}


$(function() {
		///////////////////////////
		$("#artist_main").mouseover(function() {
			init();

			
			$("#submenu").show();
			$("#artist_menu").show();
	
	
		});
		$("#submenu").mouseleave(function() { 

				$("#invisible").show();
				$("#submenu").hide();
				$("#artist_menu").hide();
			
		});
		
		//////////////////////////
		$("#comp_main").mouseover(function() {
			init();

			
			$("#submenu").show();
			$("#comp_menu").show();
	
	
		});
		$("#submenu").mouseleave(function() { 

			$("#invisible").show();
				$("#submenu").hide();
				$("#comp_menu").hide();
			
		});
		
		//////////////////////////////
		$("#goods_main").mouseover(function() {
			init();

			
			$("#submenu").show();
			$("#goods_menu").show();
	
	
		});
		
		$("#submenu").mouseleave(function() { 
			$("#invisible").show();
				$("#submenu").hide();
				$("#goods_menu").hide();
			
		});

		///////////////////////////////
		$("#aud_main").mouseover(function() {
			init();
				
			
			$("#submenu").show();
			$("#aud_menu").show();
	
	
		});
		
		$("#submenu").mouseleave(function() { 
			$("#invisible").show();
				$("#submenu").hide();
				$("#aud_menu").hide();
			
		});
		//////////////////////////////
		$("#concert_main").mouseover(function() {
			init();

			
			$("#submenu").show();
			$("#concert_menu").show();
	
	
		});
		
		$("#submenu").mouseleave(function() { 
			$("#invisible").show();
				$("#submenu").hide();
				$("#concert_menu").hide();
			
		});
	});

	