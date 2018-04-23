package com.test.mvc.board;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/board/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Check check = new Check();
		check.isauth(req, resp);
		
		// 파일 업로드
		// 1. 첨부 파일 처리(MultipartRequest 객체 생성)
		// 2. req -> MultipartRequest 교체
		//	- req.getParameter() 만 동작 안함
		// 3. 첨부 파일명 INSERT
		String path = req.getRealPath("/board/files");  // application 객체로 교체될거라 줄이 그인다.
		int size = 100 * 1024 * 1024;
		
		try {
			
			
			// 1. 데이터 가져오기(subject, content, tag)
			
			// 2. DTO 생성 + 데이터 추가
			
			// 3. DAO 위임(insert)
			
			// 4. 결과 반환 + JSP 호출하기	
			req.setCharacterEncoding("UTF-8");
	
			
			// 1. 데이터 가져오기(subject, content, tag)
			
			// req -> 역할 교체 -> multi
			MultipartRequest multi = new MultipartRequest(
										req,
										path, // 업로드 폴더 지정
										size, // 파일 최대 크기
										"UTF-8", // getParameter() 인코딩 방식
										new DefaultFileRenamePolicy() // 파일명 관리
									); // 첨부파일 업로드 완료
			
			String subject = multi.getParameter("subject");
			String content = multi.getParameter("content");
			String tag = multi.getParameter("tag");
			
			// 답변형
			String mode = multi.getParameter("mode");
			int pthread = -1;
			int pdepth = -1;
			
			if (mode.equals("reply")) {
				pthread = Integer.parseInt(multi.getParameter("thread"));
				pdepth = Integer.parseInt(multi.getParameter("depth"));
			}
					
			// 첨부 파일명 얻기
			String filename = multi.getFilesystemName("attach"); // 물리명
			String orgfilename = multi.getOriginalFileName("attach"); // 원본명
			
			// System.out.println(filename); // null 
			
			// 공지글
			// - 체크박스 선택 O : value or "on"
			// - 체크박스 선택 X : null
			String notice = multi.getParameter("notice") != null ? "1" : "0"; // "on" or null
			
			
			// 2.
			BoardDTO dto = new BoardDTO();
			
			dto.setSubject(subject);		
			dto.setContent(content);
			dto.setTag(tag);
			dto.setId((String)req.getSession().getAttribute("auth"));
			dto.setNotice(notice);
			
			// 첨부파일명 추가
			
			dto.setFilename(filename);
			dto.setOrgfilename(orgfilename);
			
			
			BoardDAO dao = new BoardDAO();
			
			
			// 새글? 답변글? thread & depth 넣기
			int thread = -1;
			int depth = -1;
			
			
			
			if (mode.equals("new")) {
				// 새글 쓰기
				// a. 게시물 중 가장 큰 thread값을 찾아서 + 1000 한 값이 현재 새글의 thread값으로 사용(단, 첫글은 1000을 넣는다.)
				thread = dao.getThread();
				
				// b. depth는 무조건 0을 넣는다.
				depth = 0;
				
			} else {
				// 답변글 쓰기
				//a. 게시물의 thread값을 대상으로 답변글의 부모글 thread값보다 작고 이전 새글의 thread값보다 큰 글들을 모두 thread - 1 적용 
				
				// 부모 쓰레드
				// pthread
				
				// 이전 새글의 쓰레드
				int prevThread = (int)Math.floor((pthread - 1) / 1000) * 1000;
				
				dao.updateThread(pthread, prevThread);
				
				// b. 답변글의 thread값은 부모글의 thread - 1 사용
				thread = pthread - 1;
				
				
				// c. 답변글의 depth 값은 부모글의 depth + 1 사용
				depth = pdepth + 1;
				
			}
			
			dto.setThread(thread);
			dto.setDepth(depth);
			
			// 3. 
	
			int result = dao.add(dto);
			
			
			String seq = dao.getSeq();
			
			// 3.5 
			// 수업예제, 자바, 예제
			String hashtag = multi.getParameter("hashtag");
			hashtag = hashtag.replace(" ", "");
			
			// 수업예제, 자바, 예제
			String[] temp = hashtag.split(",");
			HashSet<String> set = new HashSet<String>(); // 중복값 자동 배제
			
			for (String t : temp) {
				
				// System.out.println(t);
				
				set.add(t);
				
			}
			
			//Iterator<String> iter = set.iterator();
			
			for (String t : set) {
				// System.out.println(t);
				
				// DB작업 
				dao.addHashTag(t, seq);
				
			}
			
			// 4. 
			req.setAttribute("result", result);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(92929);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/addok.jsp");
		dispatcher.forward(req, resp);
		
	}

}
