<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    String clientId = "gH_dcSHGR5xb9dChEsbE";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "1sRE_N9goA";//애플리케이션 클라이언트 시크릿값";
	
    
	
    String token = URLEncoder.encode((String)request.getSession().getAttribute("access_token"), "UTF-8");
   
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete&";
    apiURL += "client_id=" + clientId;
    apiURL += "&client_secret=" + clientSecret;
    apiURL += "&access_token=" + token;
    apiURL += "&service_provider=NAVER";
    

    String refresh_token = "";
    System.out.println("apiURL="+apiURL);
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      System.out.print("responseCode="+responseCode);
      if(responseCode==200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      StringBuffer res = new StringBuffer();
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
      }
      br.close();
      
      String result = "";
      if(responseCode==200) {
        result = res.toString();
      }
      
    } catch (Exception e) {
    	out.println(e);
    }
      %>
      
  <script>
  
  location.href = "/APITest/index.jsp";
  
  </script>
</body>
</html>