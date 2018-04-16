package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Check check = new Check();
		check.isauth(req, resp);
		
		// 1. 데이터 가져오기(subject, content, tag)
		
		// 2. DTO 생성 + 데이터 추가
		
		// 3. DAO 위임(insert)
		
		// 4. 결과 반환 + JSP 호출하기	
		req.setCharacterEncoding("UTF-8");

		
		// 1. 데이터 가져오기(subject, content, tag)
		
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String tag = req.getParameter("tag");
		
		// 2.
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject(subject);		
		dto.setContent(content);
		dto.setTag(tag);
		dto.setId((String)req.getSession().getAttribute("auth"));
		
		
		// 3. 
		BoardDAO dao = new BoardDAO();
		int result = dao.add(dto);
		
		// 4. 
		req.setAttribute("result", result);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/addok.jsp");
		dispatcher.forward(req, resp);
		
	}

}
