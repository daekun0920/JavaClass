<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="1024kb" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.test.jsp.code.DBUtil" %>

<%@ include file="inc/auth.jsp" %>

<%

//코드 게시물 관련 업무
// - 회원 전용

//list.jsp
// - 일반 회원 > 게시물 열람 > 본인 것만 가능..
// - 관리자 > 모든 게시물 열람 가능..  + 첨부파일 다운로드 권한X
// - 수정, 삭제 > 본인만 가능
// - 수정, 삭제 > 관리자는 불가능

//1. DB 작업(select)
//2. 결과 출력

Connection conn = null;
PreparedStatement stat = null;
ResultSet rs = null;

conn = DBUtil.open();

String sql = "";
//중복 코드가 발생하더라도 업무를 정확히 분리 시켜놓는 것이 바람직하다.
if ((int)session.getAttribute("lv") >= 2) {
   sql = "select c.seq, c.subject, c.content, c.code, c.category, c.regdate, c.id, c.filename, c.orgfilename, m.name, t.name as cname from tblCode c inner join tblMember m on m.id = c.id inner join tblCategory t on t.seq = c.category order by seq desc";
   stat = conn.prepareStatement(sql);
} else {
   sql = "select c.seq, c.subject, c.content, c.code, c.category, c.regdate, c.id, c.filename, c.orgfilename, m.name, t.name as cname from tblCode c inner join tblMember m on m.id = c.id inner join tblCategory t on t.seq = c.category where c.id = ? order by seq desc";
   stat = conn.prepareStatement(sql);
   stat.setString(1, (String)session.getAttribute("auth")); //내 글만 보기
}



rs = stat.executeQuery();


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코드</title>
<%@ include file="inc/asset.jsp" %>
<style>
   #container .panel-body pre {
      margin: 20px;
      line-height: 1.6em;
      padding: 15px;
   }
   #container .panel-body div {
      margin: 20px;
   }
</style>
<script>
   $(function() {
      
   });

   function del(seq) {

      if (confirm("게시물을 삭제하겠습니까?")) {
         location.href = "delok.jsp?seq=" + seq;
      }
      
   }
</script>
</head>
<body>
   <!-- list.jsp -->
   
   <div id="main">
      <%@ include file="inc/header.jsp" %>
      <div id="container">
         <h2 class="page-header">목록</h2>
         
         <%
         while (rs.next()) {
            String panelClass = "";
            if (rs.getString("category").equals("1")) panelClass = "panel-primary";
            else if (rs.getString("category").equals("2")) panelClass = "panel-success";
            else if (rs.getString("category").equals("3")) panelClass = "panel-info";
            else if (rs.getString("category").equals("4")) panelClass = "panel-warning";
            else if (rs.getString("category").equals("5")) panelClass = "panel-danger";
         %>
         
         <div class="panel <%= panelClass %>">
            <div class="panel-heading">
               [<%= rs.getString("name") %>] <%= rs.getString("subject") %>
               
               <!-- 로그인한 사람의 아이디와 해당 게시물의 아이디가 일치하는지? -->
               <% if (rs.getString("id").equals((String)session.getAttribute("auth"))) { %>
               <!-- 삭제 버튼 -->
               <span class="glyphicon glyphicon-remove" style="float:right; cursor:pointer;"onclick="del(<%= rs.getString("seq") %>);"></span> <!-- onclick="del(현재 게시물의 식별자)" -->
               <% } %>
               
            </div>
            <div class="panel-body">
               <pre><%= rs.getString("code").replace("<", "&lt;").replace(">", "&gt;") %></pre>
               <div><%= rs.getString("content").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>") %></div>
            </div>
            <div class="panel-footer">
               [<%= rs.getString("cname") %>]
               <%= rs.getString("regdate").substring(0, 19) %>
               <% if (rs.getString("filename") != null) { %>
               
               <% if ((int)session.getAttribute("lv") == 1) { %>
               <a href="download.jsp?file=<%= rs.getString("filename") %>&orgfile=<%=rs.getString("orgfilename") %>"><%= rs.getString("orgfilename") %></a>
               <!-- <a href="download.jsp?file=main.css&orgfile=main.css">main.css</a> --><!-- 와 같다. -->
               <% } else {%>
               <span style="text-decoration: line-through;">
                  <%= rs.getString("orgfilename") %>
               </span>
               <% } %>
               
               <% } %>
            </div>
         </div>
         
         <% } %>
         
         <div id="btns">
            <input type="button" class="btn btn-primary" value="코드 쓰기" onclick="location.href='add.jsp';">
         </div>
         
      </div>
      <%@ include file="inc/footer.jsp" %>
   </div>
   
</body>
</html>

<%
rs.close();
stat.close();
conn.close();
%>