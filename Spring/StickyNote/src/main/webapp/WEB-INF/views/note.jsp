<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sticky Note</title>

<link rel="stylesheet" href="/spring/resources/css/bootstrap.css">
<link rel="stylesheet" href="/spring/resources/css/note.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>

	body { margin-bottom: 200px; overflow-y: scroll; }
	
	.item {
		/* border: 1px solid #000; */
		box-shadow: 0 0 5px #444;
		background-color: #FFEB9D;
		width: 215px;
		min-height: 185px;
		float: left;
		margin: 20px;
		position: relative;
	}
	
	.item .memo {
		margin: 10px;
	}
	
	.item .regdate {
		color: #777;
		font-size: 12px;
		position: absolute;
		right: 7px;
		bottom: 3px;
		text-shadow: 0 0 2px #999;
	}
	
	.item.red {
		background-color: #ff8080;
	}
	
	.item.blue {
		background-color: #7bbdff;
	}
	
	.item.green {
		background-color: #80ff80;
	}
	
	.item #memo {
		width: 200px;
		margin: 7px;
		resize: none;
		outline: none;
		height: 150px;
		border: 0px;
		background-color: transparent;
	}
	
	.item #color {
		list-style-type: none;
		margin: 0px;
		padding: 0px;
	}
	
	.item #color li {
		height: 15px;
		float: left;
		width: 25%;
	}
	
	.item #color li:nth-child(1) { background-color: #FFEB9D; }
	.item #color li:nth-child(2) { background-color: #ff8080; }
	.item #color li:nth-child(3) { background-color: #7bbdff; }
	.item #color li:nth-child(4) { background-color: #80ff80; }
	
</style>

</head>
<body>
	<!-- note.jsp -->
	
	<div class="container">
		<h1 class="page-header">Sticky Note</h1>
		
		<div id="list">
		
			<!-- 
			<div class="item">
				<div class="memo">메모 내용</div>
				<div class="regdate">2018-05-30 12:10:30</div>
			</div>
			 -->
			
			<div class="item" id="add">
				<form id="form1">
					<textarea id="memo" name="memo"></textarea>
					<ul id="color"><li></li><li></li><li></li><li></li></ul>
					<input type="hidden" name="color" id="hcolor" value="0">
				</form>
			</div>
			
		</div>
				
	</div>
	
	<script>
	
		$("#color li").click(function() {
			//alert($(this).index());
			if ($(this).index() == 0) {
				$(this).parents(".item").css("background-color", "#FFEB9D");
			} else if ($(this).index() == 1) {
				$(this).parents(".item").css("background-color", "#ff8080");
			} else if ($(this).index() == 2) {
				$(this).parents(".item").css("background-color", "#7bbdff");
			} else if ($(this).index() == 3) {
				$(this).parents(".item").css("background-color", "#80ff80");
			}
			
			$("#hcolor").val($(this).index());
			
		});
		
		
		$("#memo").change(function() {
			//메모를 적고 포커스가 해제되면..
			
			//alert($("#form1").serialize());			
			//return;
			
			$.ajax({
				type: "POST",
				url: "/spring/add.note",
				data: $("#form1").serialize(),
				dataType: "json",
				success: function(result) {
					//alert(result);
					if (result == 1) {
						
						//성공
						var note = "<div class='item'>";
						note += "<div class='memo'>" + $("#memo").val() + "</div>";
						note += "<div class='regdate'>2018-05-30 12:10:30</div>";
						note += "</div>";	
						
						//$("#list").prepend(note); //자식으로 추가
						$("#add").before(note); //형제로 추가
						
					} else {
						alert("쓰기 실패");
					}
				},
				error: function(a,b,c) {
					alert("쓰기 실패");
				}
			});
			
			
			
		});
		
	
	</script>
	
</body>
</html>







































    