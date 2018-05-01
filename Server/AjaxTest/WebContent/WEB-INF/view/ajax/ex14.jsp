<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>
	#search {
		padding:50px 20px;
		position:relative;
	}
	
	#query {
		width:450px;
	}
	
	#list {
		position:absolute;
		border:1px solid #ccc;
		width:450px;
		left:74px;
		background-color:white;
		display:none;
	}
	
	#list .item {
	
		padding:8px 15px;
		cursor:pointer;
	
	}
	
	#list #listfooter {
		padding:9px;
		background-color:#EEE;	
		text-align:right;
	}
	
	#list #listfooter span {
		cursor:pointer;
	
	
	}
</style>
<script>
	var index = -1; // 키에 맞춰서 선택된 항목 index

	$(function() {
		// GET
		// 1. 데이터 양이 적을때
		// 2. <form>, 링크, JavaScript, Ajax
		// 3. 파라미터가 동일하면 결과값이 동일한 경우(결과값이 불변한 경우)
		
		// POST
		// 1. 데이터 양이 많을때
		// 2. <form>, Ajax
		// 3. 파라미터가 동일 해도 결과값이 다른 경우(결과값이 가변한 경우)( -> 브라우저 캐시 기능때문에)
		
		$("#query").keyup(function() {
			// alert($(this).val());
			if (event.keyCode != 38 && event.keyCode != 40 && event.keyCode != 27) {
				if ($(this).val() != "") {
					$.ajax({
						type: "GET",
						url:"/ajax/ex14data.do",
						data:"query=" + $(this).val(),
						dataType:"json",
						success: function(result) {
		
							// 이전 목록 초기화
							$("#listitem").html("");
		
							if ($(result).length > 0) {
								index = -1;
								$(result).each(function(index, item) {
									$("#listitem").append("<div class = 'item' onmouseover = 'sellitem();' onmouseout = 'sellitem();' onclick = 'selecteditem();'>" + item.word +"</div>");
									
			
								});
			
								$("#list").show();
							} else {
								$("#list").hide();
							}
						}, 
						error: function(a, b, c) {
							console.log(a, b, c);
						}
					});
				} else {
					$("#list").hide();
				}
			}
				if (event.keyCode == 38) {
					// 위
					index--;

					if (index < 0) {
						index = 0;
					}
					
					$("#listitem > div").css("background-color", "#FFF");
					$("#listitem > div").eq(index).css("background-color", "#CCC");
					$("#query").val($("#listitem > div").eq(index).text());
					
				} else if (event.keyCode == 40) {
					// 아래
					index++;

					if ($("#listitem > div").length <= index) {
						index--;
					}
					
					$("#listitem > div").css("background-color", "#FFF");
					$("#listitem > div").eq(index).css("background-color", "#CCC");
					$("#query").val($("#listitem > div").eq(index).text());
					
				} else if (event.keyCode == 13) {
					$("#list").hide();
					location.href = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=" + $("#query").val();

				} else if (event.keyCode == 27) {

					$("#list").hide();

				}
			
		});
		

		$("#listfooter span").click(function() {
			$("#list").hide();
			

		});

		


	});
	
	// - onmouseover
	// - onmouseout
	function sellitem() {
		// 1. 주체(객체)
		var item = event.srcElement;

		// 2. 이벤트?
		if (event.type == "mouseover") {
			$(item).css("background-color", "#EEE");

		} else {
			$(item).css("background-color", "#FFF")

		}

	}

	function selecteditem() {
		$("#query").val($(event.srcElement).text());
		$("#list").hide();


		// 검색 버튼 클릭 or form submit
	}
</script>
</head>
<body>
	<!--  -->
	<div class = "container">
		<header class = "form-inline" id = "search">
			<label for = "query">검색어 : </label>
			<input type = "text" id = "query" name = "query" class = "form-control">
			<button type = "button" class = "btn btn-success">
				<span class = "glyphicon glyphicon-search"></span>
			</button>
			<div id = "list">
				<div id = "listitem"></div>
			
				<div id = "listfooter"><span class = "glyphicon glyphicon-remove"></span></div>
			</div>
		</header>
		<h2 class = "page-header">사이트 제목</h2>
		<section>내용들...</section>
		<section>내용들...</section>
		<section>내용들...</section>
		<section>내용들...</section>
	</div>
</body>
</html>