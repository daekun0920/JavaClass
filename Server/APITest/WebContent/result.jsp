<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
	
</script>
</head>
<body>
	<%
		String token = (String) request.getSession().getAttribute("access_token");// 네이버 로그인 접근 토큰;
	
		String header = "Bearer " + token; // Bearer 다음에 공백 추가

		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				System.out.println("에러발생!");
			}
			String inputLine;

			StringBuffer responses = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				responses.append(inputLine);
			}
			br.close();
			out.println(responses.toString());
			
		String id = "";
		String name = "";
			try {

				JSONParser jsonParser = new JSONParser();

				JSONObject jsonObject = (JSONObject) jsonParser.parse(responses.toString());

				jsonObject = (JSONObject) jsonParser.parse(jsonObject.get("response").toString());
				

				id = jsonObject.get("id").toString();
				name = jsonObject.get("name").toString();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			System.out.println(id);
			System.out.println(name);
			
			request.getSession().setAttribute("id", id);
			request.getSession().setAttribute("name", name);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.do");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	%>
</body>

	<!-- <div style = "width:50px;height:50px;background-color:yellow"><a href = "http://mugle.org/logout.jsp">연동해제</a></div> -->
	
</html>