<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mugle.org - 실시간 채팅</title>
</head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/header.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/header.js"></script>
<script src="js/bootstrap.js"></script>

<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div style="width: 900px; margin: 0px auto;smargin-top:100px;">
		<fieldset>
			<textarea
				style="margin-top: 100px; display: block; margin: 0px auto; border-radius: 8px; border: 2px solid #CCC;"
				id="messageWindow" rows="10" cols="50" readonly="readonly"
				draggable="false"></textarea>
			<br />
			<div style="width: 381px; margin: 0px auto;">
				<input id="inputMessage" name = "inputMessage" style="width: 300px; display: inline;"
					class="form-control" type="text" /> <input class="btn btn-info"
					type="submit" style="display: inline;" value="send"
					onclick="send()" />
			</div>
		</fieldset>
	</div>
</body>
<script type="text/javascript">
	var textarea = document.getElementById("messageWindow");
	var webSocket = new WebSocket('ws://mugle.org/APITest/broadcasting');
	var inputMessage = document.getElementById('inputMessage');
	webSocket.onerror = function(event) {
		onError(event)
	};
	webSocket.onopen = function(event) {
		onOpen(event)
	};
	webSocket.onmessage = function(event) {
		onMessage(event)
	};
	function onMessage(event) {
		textarea.value += event.data + "\n";
	}
	function onOpen(event) {
		textarea.value += "연결 성공\n";
	}
	function onError(event) {
		alert(event.data);

	}
	function send() {
		inputMessage.value = "${name}(${naver_seq}) : " + inputMessage.value;
		textarea.value += inputMessage.value + "\n";
		webSocket.send(inputMessage.value);
		inputMessage.value = "";
	}
	
	
	$('#inputMessage').keydown(function(event) { 
		if (event.keyCode == 13) {
			
			send();
			gotoBottom();
		}
		
		
	}); 
	function gotoBottom(){
		   var element = document.getElementById("messageWindow");
		   element.scrollTop = element.scrollHeight - element.clientHeight;
	}
</script>
</html>