<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.test.jsp.code.DBUtil" %>

<%@ include file="inc/auth.jsp" %>

<%

//addok.jsp
//1. 데이터 가져오기
//2. 파일 업로드 처리
//3. DB 작업(insert)
//4. 결과 통보

//1. 2. 
int result = 0;

try {
      
   MultipartRequest multi = new MultipartRequest(
                                       request,
                                       application.getRealPath("/code/files"),
                                       100 * 1024 * 1024,
                                       "UTF-8",
                                       new DefaultFileRenamePolicy()
                                       ); //업로드 완료
   //1.
   String catagory = multi.getParameter("category");
   String subject = multi.getParameter("subject");
   String content = multi.getParameter("content");
   String code = multi.getParameter("code");
   String filename = "";
   String orgfilename = "";
   
   if (multi.getFilesystemName("attach") != null) { //첨부파일 있음
      filename = multi.getFilesystemName("attach");
      orgfilename = multi.getOriginalFileName("attach");
   }
   
   //2.
   Connection conn = null;
   PreparedStatement stat = null;
   
   conn = DBUtil.open();
   
   String sql = "insert into tblCode (seq, subject, content, code, category, regdate, id, filename, orgfilename) values (code_seq.nextval, ?, ?, ?, ?, default, ?, ?, ?)";
   
   stat = conn.prepareStatement(sql);
   
   stat.setString(1, subject);
   stat.setString(2, content);
   stat.setString(3, code);
   stat.setString(4, catagory);
   stat.setString(5, (String)session.getAttribute("auth"));
   stat.setString(6, filename);
   stat.setString(7, orgfilename);
   
   result = stat.executeUpdate();
   
   stat.close();
   conn.close();
   
}catch(Exception e) { 
   
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코드</title>
<%@ include file="inc/asset.jsp" %>
<style>
   #content, #code {
      height: 200px;
      resize : none;
   }
   #category {
      height: 200px;
   }
</style>
<script>
   $(function() {
      <%if(result ==1) { %>
      location.href = "list.jsp";
      <% } else { %>
      alert("코드 쓰기 실패;;");
      history.back();
      <% } %>
   });
</script>
</head>
<body>
   <!-- addok.jsp -->
   
   <div id="main">
      <%@ include file="inc/header.jsp" %>
      <div id="container">
         <h2 class="page-header">제목입니다.</h2>
         
      </div>
      <%@ include file="inc/footer.jsp" %>
   </div>
   
</body>
</html>