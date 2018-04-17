package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// JSP -> Servlet -> HTML
// form(get) -> no setCharacterEncdoing
// form(post) -> setCharacterEncoding  
// ?*= -> no setCharacterEncdoing
// jsp,Servlet resp -> setCharacterEncoding
@WebServlet("/board/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// view.do?seq=1
		
		// 1. 데이터 가져오기(seq)
		
		// 2. DAO 위임(SELECT)
		
		// 3. 결과 반환(DTO) + 전달 + JSP 호출하기
		
		HttpSession session = req.getSession();
		
		
		// 1. 
		String seq = req.getParameter("seq");
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		// 2. 
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.get(seq);
		
		// 2.2 조회수 증가하기
		if (session.getAttribute("read") != null &&
			session.getAttribute("read").toString().equals("n")) {
			
			dao.updateReadCount(seq);
			session.setAttribute("read", "y");
		}
		
		// 2.4 존재하지 않는 게시물일 경우 예외 처리(북마크)
		
		if (dto == null || dto.getSubject() == null) {
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().println("<html>"
								   + "<head>"
								   + "<meta charset='utf-8'>"
								   + "<script>"
								   + "alert('존재하지 않는 페이지 입니다.'); location.href = '/mvc/index.do';"
								   + "</script>");
			resp.getWriter().close();
		}
		
		// 2.5 데이터 가공
		

		// 태그 적용 유무
		String content = dto.getContent();
		String subject = dto.getSubject();
		
		if (dto.getTag().equals("n")) {
			
			content = content.replace("<", "&lt;").replace(">", "&gt;"); 
			dto.setContent(content);
			
		}
		
		
		
		// <style>, <script> 무조건 적용안함
		content = content.replace("<script", "&lt;script").replace("<style", "&lt;style").replace("</script", "&lt;/script").replace("</style", "&lt;/style");
		
		dto.setContent(content);
	
		// b. 글 내용에 개행문자 처리
		content = content.replace("\n", "<br>");
		dto.setContent(content);
		
		
		// c. 제목에 HTML 태그 적용 해제
				dto.setSubject(subject.replace("<script", "&lt;script")
											   .replace("<style", "&lt;style")
											   .replace("</script", "&lt;/script")
											   .replace("</style", "&lt;/style"));
				
		// d. 내용 검색 > 키워드 표시
		if (column != null && column.equals("content")) {
		    content = content.replace(word, "<span style = 'background-color:yellow;'>" + word + "</span>");
			dto.setContent(content);
		}
		
		// 3.
		req.setAttribute("dto", dto);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/view.jsp");
		dispatcher.forward(req, resp);

	}

}
