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

</style>
<script>
	function send1() {

		// Get 방식으로 ajax 요청을 한뒤 응답 받기
		var ajax = new XMLHttpRequest();

		ajax.onreadystatechange = function() {

			if (this.readyState == 4 && this.status == 200) {

				// 응답 데이터 : this.responseText

				$("#result").text(this.responseText + ":" + (new Date()).toLocaleString()) // 서버측 시간과 클라이언트측 시간이 다르다.
			}
			// console.log(this.readyState, this.responseText);
		};

		ajax.open("GET", "/ajax/ex07data.do", true);
		ajax.send(); // ajax 요청 -> 서버로부터 응답 -> onreadystatechange 발생
	}

	function send2() {

		
		var ajax = new XMLHttpRequest();

		ajax.onreadystatechange = function() {

			if (this.readyState == 4 && this.status == 200) {

				$("#result").text(this.responseText + ":" + (new Date()).toLocaleString())
		
			}
			
		};

		ajax.open("POST", "/ajax/ex07data.do", true); // POST 방식
		ajax.send();
	}

	function send3() {

		
		var ajax = new XMLHttpRequest();

		ajax.onreadystatechange = function() {

			if (this.readyState == 4 && this.status == 200) {

				$("#result").text(this.responseText + ":" + (new Date()).toLocaleString())
		
			}
			
		};

		
		
		ajax.open("GET", "/ajax/ex07data.do?id=hong&num=100", true); // 데이터 넘기기
		ajax.send();
	}

	function send4() {

		
		var ajax = new XMLHttpRequest();

		ajax.onreadystatechange = function() {

			if (this.readyState == 4 && this.status == 200) {

				$("#result").text(this.responseText + ":" + (new Date()).toLocaleString())
		
			}
			
		};

		ajax.open("POST", "/ajax/ex07data.do", true); // POST 방식
		ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
		ajax.send("color=red&size=200"); // 데이터 전송
	}

	function send5() {

		
		var ajax = new XMLHttpRequest();

		ajax.onreadystatechange = function() {

			if (this.readyState == 4 && this.status == 200) {

				// ajax 요청에 대한 응답 데이터의 형태 : 텍스트
				// -> this.responseText
				$("#result").text(this.responseText);
				
			}
			
		};

		ajax.open("POST", "/ajax/ex07data.do", true); // POST 방식
		ajax.send(); // 데이터 전송
	}

	function send6() {

		
		var ajax = new XMLHttpRequest();

		ajax.onreadystatechange = function() {

			if (this.readyState == 4 && this.status == 200) {

				// 응답 데이터 : XML
				// this.responseXML
				// alert(this.responseXML);
				// alert($(this.responseXML).find("question").text());


				var temp = $(this.responseXML).find("question").text();

				temp += "<br>";

				// $(this.responseXML).find("item"); 
				
				// item 태그 4개
				$(this.responseXML).find("item").each(function(index, item) {
					//alert();
					temp = temp + $(item).find("text").text() + "<br>";
					temp = temp + $(item).find("count").text() + "<br>";
				});


				$("#result").html(temp);
			}
			
		};

		ajax.open("POST", "/ajax/ex07data.do", true); // POST 방식
		ajax.send(); // 데이터 전송
	}
	
	function send7() {

		
		var ajax = new XMLHttpRequest();

		ajax.onreadystatechange = function() {

			if (this.readyState == 4 && this.status == 200) {

				$("#result").text(this.responseText);
				
			}
			
		};
			// 동기식(false) : 응답 받을때까지 아무 작업 못함 (업무간에 관계가 있을때 사용)
			// 비동기식(true) : 응답 받기전까지도 다른 작업 할 수 있음 (업무간에 관계가 없을때 사용)
		ajax.open("GET", "/ajax/ex07data.do", true);
		ajax.send();
	}
</script>
</head>
<body>
	<!-- ex07.jsp -->
	<div class = "container">
		<h2 class = "page-header">
			페이지 요청 - 데이터 전달
		</h2>
		<input type = "button" value = "1. GET 요청" onclick = "send1();" class = "btn btn-default">
		<input type = "button" value = "2. POST 요청" onclick = "send2();" class = "btn btn-default">
		<input type = "button" value = "3. GET 요청(데이터)" onclick = "send3();" class = "btn btn-default">
		<input type = "button" value = "4. POST 요청(데이터)" onclick = "send4();" class = "btn btn-default">
		<input type = "button" value = "5. 응답 데이터(Text)" onclick = "send5();" class = "btn btn-default">
		<input type = "button" value = "6. 응답 데이터(XML)" onclick = "send6();" class = "btn btn-default">
		<input type = "button" value = "7. 동기/비동기" onclick = "send7();" class = "btn btn-default">
		<hr>
		<div id = "result" class = "well">결과</div>
	</div>
</body>
</html>