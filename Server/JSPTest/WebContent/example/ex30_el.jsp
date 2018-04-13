<%@page import="java.util.ArrayList"%>
<%@page import="com.test.jsp.Student"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%


%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>

</style>
<script>
	$(function() {
		
	});
</script>
</head>
<body>
	<!-- WebContent > example > ex30_el.jsp -->
	
	<%
	
	//자바 변수
	int a = 10;
	
	//내장 객체 변수
	request.setAttribute("b", 20);
	
	%>	
	<h1>자바 표현식을 사용해서 출력</h1>
	<div>a : <%= a %></div>
	<div>b : <%= request.getAttribute("b") %></div>
	
	<h1>EL을 사용해서 출력</h1>
	<div>a : ${a}</div>
	<div>b : ${request.getAttribute("b")}</div>
	<div>b : ${b}</div>
	
	<%
	int c = 30;	
	%>
	<h1>자바 표현식을 사용해서 출력</h1>
	<div>c : <%= c %></div>
	<div>c * 2 : <%= c * 2 %></div>
	
	<%
	pageContext.setAttribute("d", 40);
	//pageContext.setAttribute("d", (int)pageContext.getAttribute("d") * 2);
	%>
	<h1>EL을 사용해서 출력</h1>
	<div>d : ${d}</div>
	<div>d : ${d * 2}</div>
	
	<%
	int e = 50;
	request.setAttribute("e", e);//내장객체에 직접 추가하면 EL 사용 가능(빈번)
	%>
	<div>e : ${e}</div>
	
	<%
	HashMap<String,String> map = new HashMap<String,String>();
	map.put("name", "홍길동");
	map.put("age", "20");
	map.put("gender", "남자");
	session.setAttribute("myinfo", map);
	%>
	
	<h1>자바 표현식</h1>
	<div>이름 : <%= ((HashMap)session.getAttribute("myinfo")).get("name") %></div>
	<div>나이 : <%= Integer.parseInt((String)((HashMap)session.getAttribute("myinfo")).get("age")) - 1 %></div>
	<div>성별 : <%= ((HashMap)session.getAttribute("myinfo")).get("gender") %></div>
	
	<h1>EL</h1>
	<div>이름 : ${myinfo.name}</div><!-- 가장 많이 사용 -->
	<div>이름 : ${myinfo["name"]}</div>
	<div>이름 : ${myinfo.get("name")}</div>
	
	<div>나이 : ${myinfo.age - 1}</div>
	<div>성별 : ${myinfo.gender}</div>
	
	<%
	
	//사용자 정의 객체
	Student s1 = new Student();
	
	s1.setName("아무개");
	s1.setAge(20);
	s1.setKor(100);
	s1.setEng(90);
	s1.setMath(80);
	s1.setTotal(270);
	
	request.setAttribute("s1", s1);//EL을 사용해서 접근하기 위해..
	%>
	<h1>학생 정보</h1>
	
	<div>이름 : <%= s1.getName() %></div>
	<div>나이 : ${s1.age}</div><!-- getAge() 호출 -->
	<div>국어 : ${s1["kor"]}</div>
	<div>영어 : ${s1.getEng() }</div>
	<div>수학 : ${s1.math}</div>
	<div>총점 : ${s1.total}</div><!-- s1.getTot() 호출 -->
	
	<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("안녕");
	list.add("잘가");
	list.add("또봐");
	request.setAttribute("list2", list);
	%>
	<h1>저녁 인사</h1>
	<div><%= list.get(0) %></div>
	<div>${list2.get(1)}</div>
	<div>${list2[2]}</div>
	<%-- <div>${list2.2}</div> 안됨 --%>
	
	<hr>
	
	<%
	
	request.setAttribute("n1",100);
	request.setAttribute("n2",30);

	%>
	<h1>EL의 연산 지원</h1>
	
	<div>n1 : ${n1}</div>
	<div>n1 : ${n2}</div>
	
	<div>n1 + n2 = <%= (int)request.getAttribute("n1") + (int)request.getAttribute("n2") %></div>
	<div>n1 + n2 = ${n1} + ${n2}</div><%-- <%//실패(값이 이상함) %> --%>
	<div>n1 + n2 = ${n1+ n2}</div><%-- <%//성공 %> --%>
	
	<br>
	
	<div>n1 + n2 = ${n1 + n2 }</div>
	<div>n1 + n2 = ${n1 - n2 }</div>
	<div>n1 + n2 = ${n1 * n2 }</div>
	<div>n1 + n2 = ${n1 / n2 }</div>
	<div>n1 + n2 = ${n1 % n2 }</div>
	<div>n1 div n2 = ${n1 div n2 }</div>
	<div>n1 mod n2 = ${n1 mod n2 }</div>
	
	<div>n1 > n2 = ${n1 > n2}</div>
	<div>n1 > n2 = ${n1 gt n2}</div>
	
	<div>n1 >= n2 = ${n1 >= n2}</div>
	<div>n1 >= n2 = ${n1 ge n2}</div>
	
	<div>n1 < n2 = ${n1 < n2 }</div>
	<div>n1 < n2 = ${n1 lt n2 }</div>

	<div>n1 <= n2 = ${n1 <= n2 }</div>
	<div>n1 <= n2 = ${n1 le n2 }</div>
	
	<div>n1 == n2 = ${n1 == n2 }</div>
	<div>n1 == n2 = ${n1 eq n2 }</div>
	
	<div>n1 != n2 = ${n1 != n2 }</div>
	<div>n1 != n2 = ${n1 ne n2 }</div>
	
	<div>true && true = ${true && true}</div>
	<div>true && false = ${true && false}</div>
	<div>true && false = ${true and false}</div>
	
	<div>true || false = ${true || false }</div>
	<div>true || false = ${true or false }</div>
	
	<div>!true = ${!true }</div>
	<div>!true = ${not true }</div>
	
	<div>n1 = ${n1 > 0?"양수":"음수" }</div>
	
	<%
	String str1 = "";
	String str2 = null;
	String str3 = "홍길동";
	request.setAttribute("str1", str1);
	request.setAttribute("str2", str2);
	request.setAttribute("str3", str3);
	%>
	
	<div>str1 : ${str1}</div>
	<div>str2 : ${str2}</div>
	<div>str3 : ${str3}</div>
	<div>str4 : ${str4}</div>
	
	<div>str1 : ${empty str1 }</div>
	<div>str2 : ${empty str2}</div>
	<div>str3 : ${empty str3 }</div>
	<div>str4 : ${empty str4 }</div>

	
</body>
</html>


























    