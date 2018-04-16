<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.jsp.code.DBUtil"%>
<%

//File file2 = new File(application.getRealPath("code/files"));
//System.out.print(file2.getAbsolutePath());
//out.close();


//delok.jsp
//1.데이터 가져오기(seq)
//1.5 해당 글의 파일유무 확인>삭제
//2. DB 작업

//1. delok.jsp?seq=5
String seq = request.getParameter("seq");

//2.
Connection conn = null;
Statement stat = null;

conn = DBUtil.open();
stat = conn.createStatement();

//1.5

//String sql = "select count(*) from tblCode where filename is not null and seq = " + seq; 또 이름검색해야해서 안씀

String sql = "select filename from tblCode where seq = " + seq;
ResultSet rs = stat.executeQuery(sql);

if(rs.next()){
	String filename = rs.getString("filename");
	if(filename != null){
		//첨부파일삭제
		File file = new File(application.getRealPath("code/files/" + filename));
		file.delete();
	}
}

sql = "delete from tblCode where seq = " + seq;

int result = stat.executeUpdate(sql);

stat.close();
conn.close();

out.print("<script>");

if(result == 1){
	out.print("location.href = 'list.jsp';");
}else {
	out.print("alert('삭제 실패;;');");
	out.print("history.back();");
}

out.print("</script>");


%>
