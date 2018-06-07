<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		box-shadow: 0 -1px 5px #444;
		background-color: #FFEB9D;
		width: 215px;
		min-height: 185px;
		float: left;
		margin: 20px;
		position: relative;
		border-radius: 3px;
	}
	
	.item:nth-child(even) {
		transform: translate(7px, 10px);
	}
	
	h1.page-header {
		text-shadow: 0 -1px 5px #999;
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
		border-top: 1px solid #aaa;
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
	
	.btnClose {
		float: right;
		margin: 3px 7px 0px 0px; 
		cursor: pointer;
		display: none;
	}
	
	.item:hover > .btnClose {
		display: block;
	}
	
	.page-header span {
		display: inline-block;
		width: 45px;
		height: 15px;
		cursor: pointer;
	}
	
	.page-header span:nth-child(1) { background-color: #FFEB9D; }
	.page-header span:nth-child(2) { background-color: #ff8080; }
	.page-header span:nth-child(3) { background-color: #7bbdff; }
	.page-header span:nth-child(4) { background-color: #80ff80; }
	
</style>

</head>
<body>
	<!-- note.jsp -->
	
	<div class="container">
		<h1 class="page-header">
			Sticky Note
			
			<span></span><span></span><span></span><span></span>
			
		</h1>
		
		<div id="list">
		
			<c:forEach items="${list}" var="dto">
			<c:set var="color" />
			<c:choose>
				<c:when test="${dto.color == 1}">
					<c:set var="color" value="red" />
				</c:when>
				<c:when test="${dto.color == 2}">
					<c:set var="color" value="blue" />
				</c:when>
				<c:when test="${dto.color == 3}">
					<c:set var="color" value="green" />
				</c:when>
			</c:choose>
			<div class="item ${color}">
				<div class="btnClose">&times;</div>
				<div class="memo">${dto.memo}</div>
				<div class="regdate">${fn:substring(dto.regdate, 0, 19)}</div>
				<input type="hidden" class="seq" value="${dto.seq}">
			</div>
			</c:forEach>
			
			
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
					//console.log(result);
					
					if (result != null) {
						
						var color = "";
						if (result.color == 1) color = "red";
						else if (result.color == 2) color = "blue";
						else if (result.color == 3) color = "green";
						
						//성공
						var note = "<div class='item " + color + "'>";
						note += "<div class='memo'>" + result.memo + "</div>";
						note += "<div class='regdate'>" + result.regdate.substring(0, 19) + "</div>";
						note += "</div>";	
						
						//$("#list").prepend(note); //자식으로 추가
						$("#add").before(note); //형제로 추가
						
						//입력 폼 초기화
						$("#memo").val("");
						$("#color li").eq(0).click();
						
						
					} else {
						alert("쓰기 실패");
					}
				},
				error: function(a,b,c) {
					alert("쓰기 실패");
				}
			});
			
		});
		
		
		
		$(".btnClose").click(function() {
			
			var seq = $(this).next().next().next();
			//alert(seq.val());
			var btn = $(this);
			
			$.ajax({
				
				type: "GET",
				url: "/spring/del.note",
				data: "seq=" + seq.val(),
				dataType: "json",
				success: function(result) {
					
					if (result == 1) {
						btn.parent().remove();
					} else {
						alert("삭제 실패");
					}
					
				},
				error: function(a,b,c) {
					alert("삭제 실패");
				}
				
			});
			
			
		});
		
		
		
		
		
		
		$(".page-header span").click(function() {
			
			//alert($(this).index());
			
			if ($(this).index() == 0) {
			
				//기본색 메모
				//$(".item.red, .item.blue, .item.green").hide();
				$(".item").hide();
				$(".item[class='item ']").show();
				$("#add").show();
				
			} else if ($(this).index() == 1) {
				
				//빨간색 메모
				$(".item").hide();
				$(".item.red").show();
				$("#add").show();
				
			} else if ($(this).index() == 2) {
				
				//파란색 메모
				$(".item").hide();
				$(".item.blue").show();
				$("#add").show();
				
			} else if ($(this).index() == 3) {
				
				//초록색 메모
				$(".item").hide();
				$(".item.green").show();
				$("#add").show();
				
			}
			
			
		});
		
		
	
	</script>
	
</body>
</html>







































    