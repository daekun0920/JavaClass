<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 클라이언트 -> (데이터 전송) -> 서버
// - 기본 인코딩 : ISO-8859-1(=EUC-KR, ANSI, MS949)
// - 현재 프로젝트 : UTF-8
// - request 담당

// get 데이터 전달 : URL 붙어서 전송 -> 아파치/톰캣을 통해서 데이터를 수신 : 내부 인코딩(UTF-8)

// post 데이터 전달 : 자바를 통해서 데이터 수신 : 자바 인코딩(UTF-8)

// 클라이언트의 요청이 post일 때만 설정(get일때는 설정 안함)
// 앞으로 request와 관련된 동작은 UTF-8을 사용하겠습니다.
request.setCharacterEncoding("UTF-8"); /* 모든 동작보다 앞서야 한다 */

// 1. 데이터 가져오기
String txt1 = request.getParameter("txt1");
String pw1 = request.getParameter("pw1");
String txt2 = request.getParameter("txt2");

// request.getParameter()의 반환값이 "" 인 경우? -> 사용자가 아무값도 입력 안했을때
// request.getParameter()의 반환값이 null 인 경우? -> 키값이 올바르지 않았을 때
// -> 체크박스는 체크를 하지 않으면 아예 전송이 안된다.(제외)
String cb1 = request.getParameter("cb1");

//System.out.println(txt1);

if (cb1 != null && cb1.equals("on")) {
	System.out.println("체크 함");
} else {
	System.out.println("체크 안함");
}

// 체크박스는 value 기재 or 미기재
// 1. 기재(권장)
// - 체크 O : value 전송
// - 체크 X : 미전송(null)
// 2. 미기재
// - 체크 O : "on"
// - 체크 X : 미전송(null)

String cb2 = request.getParameter("cb2");

/* 
String hobby1 = request.getParameter("hobby1");
String hobby2 = request.getParameter("hobby2");
String hobby3 = request.getParameter("hobby3");
*/

// 체크박스들
String[] hobbys = request.getParameterValues("hobbys");

String rbgender = request.getParameter("rbgender");


//셀렉트 박스
//- 선택된 option의 value가 전송
//- value가 없는 option 이 선택되면 PCDATA를 전송 // 비권장
String sel1 = request.getParameter("sel1");

String[] sel2 = request.getParameterValues("sel2");// 복수의 컨트롤 !!

//히든 태그
String id = request.getParameter("id");

//HTML
String birthday = request.getParameter("birthday");

String minprice = request.getParameter("minprice");
String maxprice = request.getParameter("maxprice");


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
	body {
		padding:50px;
	}
	
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
	<h1>결과</h1>
	
	<div class = "panel panel-default">
		<div class = "panel-heading">텍스트 박스 : </div>
		<div class = "panel-body"><%= txt1 %></div>
	</div>
	
	<div class = "panel panel-default">
		<div class = "panel-heading">암호 박스 : </div>
		<div class = "panel-body"><%= pw1 %></div>
	</div>
	
	<div class = "panel panel-default">
		<div class = "panel-heading">멀티 박스 : </div>
		<div class = "panel-body"><%= txt2.replace("\n", "<br>") %></div> <!-- 개행을 위해서 -->
	</div>
	
	<div class = "panel panel-default">
		<div class = "panel-heading">체크 박스(싱글) : </div>
		<div class = "panel-body"><%= cb1 %></div>	
	</div>
	
	<div class = "panel panel-default">
		<div class = "panel-heading">체크 박스(싱글) : </div>
		<div class = "panel-body"><%= cb2 %></div> 
	</div>
	
	<div class = "panel panel-default">
		<div class = "panel-heading">체크 박스(멀티) : </div>
		<div class = "panel-body"><%= Arrays.toString(hobbys) %></div> 
	</div>
	
	<div class = "panel panel-default">
		<div class = "panel-heading">라디오 버튼 : </div>
		<div class = "panel-body"><%= rbgender %></div> 
	</div>
	<div class="panel panel-primayr">
      <div class="panel-heading">셀렉트 박스</div>
      <div class="panel-body"><%= sel1 %> </div>
   </div>
   <div class="panel panel-primayr">
      <div class="panel-heading">셀렉트 박스</div>
      <div class="panel-body"><%= Arrays.toString(sel2) %> </div>
   </div>
   <div class="panel panel-primayr">
      <div class="panel-heading">히든 태그</div>
      <div class="panel-body"><%= id %> </div>
   </div>
   <div class="panel panel-primayr">
      <div class="panel-heading">HTML5</div>
      <div class="panel-body"><%= birthday %> </div>
   </div>
   <div class="panel panel-primayr">
      <div class="panel-heading">자바스크립트 라이브러리</div>
      <div class="panel-body"><%= minprice %> <%= maxprice %> </div>
	</div>
</body>
</html>