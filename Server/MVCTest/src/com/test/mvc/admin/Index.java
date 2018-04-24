package com.test.mvc.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/index.do")
public class Index extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//관리자 접근
				if (req.getSession().getAttribute("lv").toString().equals("1")) {
					//서블릿 페이지 출력
					resp.setCharacterEncoding("UTF-8");
					String html = "<html><head><meta charset='utf-8'></head><body>";
					html += "<script>alert('나가');location.href='/mvc/';</script>"; // 기본 index.do
					html += "</body></html>";
					
					resp.getWriter().println(html);
					resp.getWriter().close();
				}
				
				AdminDAO dao = new AdminDAO();
				
				int userCount = dao.getUserCount();
				int postCount = dao.getPostCount();
				int commentCount = dao.getCommentCount();
				int mediaCount = dao.getMediaCount();
				
				ArrayList<String> names = dao.getNames();
				
				//names -> '홍길동', '아무개'
				
				StringBuilder namesData = new StringBuilder();
				
				for (String name : names) {
					namesData.append("'");
					namesData.append(name);
					namesData.append("',");
					
				}
				
				// 마지막 , 제거
				namesData.deleteCharAt(namesData.lastIndexOf(","));
				
				// 회원별 게시물 수
				ArrayList<Integer> posts = dao.getPostsData();
				
				StringBuilder postsData = new StringBuilder();
				
				for (Integer post : posts) {
		
					postsData.append(post);
					postsData.append(",");
					
				}
				
				
				// 회원별 댓글 수
				ArrayList<Integer> comments = dao.getCommentsData();
				
				StringBuilder commentsData = new StringBuilder();
				
				for (Integer comment : comments) {

					commentsData.append(comment);
					commentsData.append(",");
					
				}
				
				
				req.setAttribute("userCount", userCount);
				req.setAttribute("postCount", postCount);
				req.setAttribute("commentCount", commentCount);
				req.setAttribute("mediaCount", mediaCount);
				req.setAttribute("names", names);
				
				req.setAttribute("namesData", namesData.toString());
				req.setAttribute("postsData", postsData.toString());
				req.setAttribute("commentsData", commentsData.toString());
				
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/index.jsp");
				dispatcher.forward(req, resp);

	}

}
