package com.test.mvc.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

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
		
		process(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req, resp);

	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		// 페이징 사전 작업
		
		int nowPage = 0;					// 현재 페이지 번호				
		int pageSize = 5;                   // 한페이지에서 보여줄 게시물 수
		int totalPage = 0;                  // 총 페이지 수
		int start = 0;                      // 쿼리의 조건절 rnum >= start
		int end = 0;						// rnum <= end
		int totalCount = 0;
		
		int n = 0;
		int loop = 0;
		int blockSize = 10;
		
		// list.do -> list.do?page=1
		// list.do?page=3
		String page = req.getParameter("page");
		
		if (page == null) nowPage = 1;
		else nowPage = Integer.parseInt(page);
		
		// nowPage : 현재 보고싶은 페이지
		// 1. > WHERE rnum >= 1 ~ 5 >=rnum
		// 2. > 6 ~ 10
		
		start = ((nowPage - 1) * pageSize) + 1;
		end = start + pageSize - 1;
		
		HashMap<String, String> map = new HashMap<>();
		map.put("start", start + "");
		map.put("end", end + "");
		
		
		
		
		
		// 그냥 목록 보기
		// - list.do
		// 검색 결과 목록 보기
		// - list.do + column + word
	
		
		boolean isSearch = false;
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		if (column != null && word != null) {
			isSearch = true;
		}
		
		
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
		
		
		// 임시 상자
		map.put("isSearch", isSearch + "");
		map.put("column", column);
		map.put("word", word);
		
		
		// 총 페이지 수 계산하기
		totalCount = dao.getTotalCount(map); // 총 게시물 수 
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize); // ceil 로 무조건 올림
		
		
		
		map.put("totalpage", totalPage + "");
		map.put("totalcount", totalCount + "");
		map.put("page", page);
		
		System.out.println(map.get("totalcount"));
		ArrayList<BoardDTO> list = dao.list(map); // isSearch, column, word
		
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
			
			// d. 제목을 검색 > 검색어를 색깔로 표시
			if (isSearch && column.equals("subject")) {
				
				
				// before) 게시판 테스트 입니다.
				//  after) 게시판 <span style = "background-color:yellow;">테스트</span> 입니다.
				dto.setSubject(dto.getSubject().replace(word, "<span style = 'background-color:yellow;'>" + word + "</span>"));
				
			}
		}
		
		
		
		// 2. 
		req.setAttribute("list", list);
		
		// 검색 중이라면..
		req.setAttribute("map", map);
		
		
		
		// resp.sendRedirect 와 dispatcher.forward는 같이 못쓴다.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/list.jsp");
		dispatcher.forward(req, resp);
	}

}
