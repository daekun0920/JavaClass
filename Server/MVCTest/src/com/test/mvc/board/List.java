package com.test.mvc.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// @XXX : annotation(프로그래밍 기능 주석)
// web.xml 파일대신 매핑
@WebServlet("/board/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 비회원 접근 금지 
		Check check = new Check();
		check.isauth(req, resp);
		
		// 읽음 표시에 사용할 세션 저장
		HttpSession session = req.getSession();
		session.setAttribute("read", "n");
		
		// 1. DAO 위임(SELECT)
		// 2. 결과 전달 + JSP 호출하기
		
		// 1.
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.list();
		
		// 1.5 데이터 가공
		for (BoardDTO dto : list) {
			

			// 최근에 쓴글인지? - 1시간 이내
			// 현재 시각 - 글쓴 시각 = 차이가 1시간 이내?
			// Calendar
			
			// dto.getRegdate();
			// dao 에서 처리
			
			// 날짜 포맷 설정
			// - 오늘 쓴 글 : 시분초
			// - 어제 이전 쓴 글 : 년월일
			Calendar now = Calendar.getInstance();
			String temp = String.format("%tF", now); // 2018-04-16
			
			if (dto.getRegdate().startsWith(temp)) {
				// - 오늘 쓴 글 : 시분초
				dto.setRegdate(dto.getRegdate().substring(0, dto.getRegdate().length() - 2));
			} else {
				dto.setRegdate(dto.getRegdate().substring(0, 10)); // 덮어쓰기
			}
			
			
			// 제목이 길면 자르기..
			if (dto.getSubject().length() > 35) {
				dto.setSubject(dto.getSubject().substring(0, 28) + "...");
			}
			
			// c. 제목에 HTML 태그 적용 해제
			dto.setSubject(dto.getSubject().replace("<script", "&lt;script")
										   .replace("<style", "&lt;style")
										   .replace("</script", "&lt;/script")
										   .replace("</style", "&lt;/style"));
			
			
		}
		
		
		
		// 2. 
		req.setAttribute("list", list);
		
		// resp.sendRedirect 와 dispatcher.forward는 같이 못쓴다.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/list.jsp");
		dispatcher.forward(req, resp);

	}

}
