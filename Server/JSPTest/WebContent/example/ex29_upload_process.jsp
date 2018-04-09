<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

// 파일 경로
String path = application.getRealPath("files");

// 최대 크기
int size = 100 * 1024 * 1024;

// 변수
String subject = "";
String name = ""; // 텍스트 데이터

ArrayList<String> filename = new ArrayList<String>();
ArrayList<String> orgfilename = new ArrayList<String>();

try {
	
	MultipartRequest multi = new MultipartRequest(request,
												  path,
												  size,
												  "UTF-8",
												  new DefaultFileRenamePolicy()
												  ); // 이미 멀티 파일 업로드 완료...
												  
	subject = multi.getParameter("subject");
    name = multi.getParameter("name");
    
    // 첨부 파일들의 이름들 가져오기
    // multi.getFilesystemName("attach"); // 단일(정적)
	
    Enumeration e = multi.getFileNames();
    
    while (e.hasMoreElements()) {
    	String attachname = (String)e.nextElement();
    	//System.out.println(attachname);
    	
    	String temp = multi.getFilesystemName(attachname);
    	String orgtemp = multi.getOriginalFileName(attachname);
    	
    	//System.out.println(temp);
    	//System.out.println(orgtemp);
    	
    	if (temp != null) {
    		filename.add(temp);
    		orgfilename.add(orgtemp);
    	} 
    	
    }
    
    
    
} catch (Exception e) {
	e.printStackTrace();
}

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
	<!--  -->
	<h1>결과</h1>
	
	<div>제목 : <%= subject %></div>
	<div>이름 : <%= name %></div>
	<div>
		<% for (int i = 0; i < filename.size(); i++) { %>
			<div>
				<%= filename.get(i) %> / 
				<%= orgfilename.get(i) %> /
				<a href = "download.jsp?file=<%= filename.get(i) %>&orgfile=<%= orgfilename.get(i) %>">
					<%= orgfilename.get(i) %>
				</a>
			</div>
			
		<% } %>
	</div>
	
</body>
</html>