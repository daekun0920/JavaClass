<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 1. 데이터 가져오기(post + 한글 포함)
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String age = request.getParameter("age");


// 2. 업무(DB) - 여기서 오류가 발생해도 페이지 이동이 일어나므로 오류의 여부를 체크해서 세번째 페이지에 전달해줘야한다
System.out.println("inser... + 실행");

// 3. 결과 페이지 이동
//	a. location.href // 처음 시작 지점으로 다시 돌아갔다가 감 -> X 
//  b. response.sendRedirect() // O
//  c. pageContext.forward() // O - 최적(성공 혹은 오류 여부 세번째 페이지에 전달)

// response.sendRedirect("ex21_forward_result.jsp");

request.setAttribute("result", 0);

// pageContext.forward("ex21_forward_result.jsp");

%>

<!--

단독 태그 사용법
<br> - XML 에서는 허용 안됨
<br/>
<br></br>

 -->

<jsp:forward page = "ex21_forward_result.jsp" />

<%--

 <div></div>
<jsp:div></jsp:div>
jsp: // 접두어 -> 네임스페이스(namespace) == 자바의 패키지 역할
-> 유일한 표현을 사용한다.(지구상에서) -> 도메인(http://test.com)

XML -> 태그를 사용자가 맘대로 정의할 수 있다.

- 개발자 : 홍길동
<http://test.com:정보>
	<http://test.com:이름>홍길동</http://test.com:이름>
	<http://test.com:나이>20</http://test.com:나이>
</http://test.com:정보>

- 개발자 : 아무개
<강아지:정보>
	<강아지:이름>멍멍이</강아지:이름>
	<강아지:나이>2</강아지:나이>
</강아지:정보>

<!-- 문서 통합의 경우 -->
<사람:문서>
	<사람:정보>
		<사람:이름>홍길동</사람:이름>
		<사람:나이>20</사람:나이>
		<사람:색깔>검정</사람:색깔>
	</사람:정보>
	<강아지:정보>
		<강아지:이름>멍멍이</강아지:이름>
		<강아지:나이>2</강아지:나이>
		<강아지:색깔>흰색</강아지:색깔>
	</강아지:정보>
</강아지:문서>

<!-- 최종 결론 -->
<!-- xmlns -> XML Name Space(네임 스페이스) -->
<my:정보 xmlns:my = "http://test.com">
	<my:이름>멍멍이</my:이름>
	<my:나이>2</my:나이>
</my:정보>

<!-- 별칭 생략 딱 1번 가능 -->
<정보 xmlns = "http://test.com">
	<이름>멍멍이</이름>
	<나이>2</나이>
</정보>

 --%>
















