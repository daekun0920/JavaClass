
$(function() {
		$("#manage_main").mouseover(function() {
			init();

			
			$("#submenu").show();
			$("#manage_menu").show();
	
	
		});
		$("#submenu").mouseleave(function() { 

				
				$("#submenu").hide();
				$("#manage_menu").hide();
			
		});


		$("#new_main").mouseover(function() {
			init();

			
			$("#submenu").show();
			$("#new_menu").show();
	
	
		});
		$("#submenu").mouseleave(function() { 

				$("#submenu").hide();
				$("#new_menu").hide();
			
		});
		
	});

	function init() {

		$("#submenu").hide();
		$(".sub").hide();

	}