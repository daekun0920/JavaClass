<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

// 페이지 상단 : 출력 작업과 상관 없는 작업 + 출력하기 전 미리해야 하는 작업 = 코드 분리

// 1. 데이터 받기(클라이언트 -> 서버) : request 담당
// - String request.getParameter("폼태그의 name 값") // 클라이언트로부터 전송된 데이터를 얻기

// request.getParameter("존재하지 않는 키") : null 반환
// 넘긴 키와 받은 키가 다르면 null 반환

String name = request.getParameter("nama");
String gender = request.getParameter("gender");
String age = request.getParameter("age");
String address = request.getParameter("address");

// 데이터 디버깅(확인)
// - 웹서버측 콘솔에 출력

System.out.println(name);
System.out.println(gender);
System.out.println(age);
System.out.println(address);

// request.getParameter() 가 수신할 데이터를 입력받기 못했다면 뭘 리턴? -> 빈 문자열 
System.out.println(name == "");
System.out.println(gender == null);
System.out.println(age == "");
System.out.println(address == null);

%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>

</style>
<script>
	//$(document).ready(function() {
	//	
	//});
	
	// 줄임 표현
	$(function() {
		
	});
</script>
</head>
<body>
	<!-- ex07_request_process -->
	<!-- 표현식에 들어있는 값들은 print의 매개변수로 들어가기 때문에 세미콜론을 붙이면 안된다. -->
	
	
	<h1>데이터를 수신하는 역할(POST, GET)</h1>

		<table style = "width:500px" class = "table table-bordered">
			<tr>
				<th style = "width:150px;">이름</th>
				<td style = "width:400px;">
					<%= name %>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<%-- <%= gender.equals("m") ? "남자" : "여자" %> --%>
					<img src = "images/gender_<%= gender %>.png">
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<%= age %>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<%= address %>
				</td>
			</tr>
		</table>
	
	</body>
</html>