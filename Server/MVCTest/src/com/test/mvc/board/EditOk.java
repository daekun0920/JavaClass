package com.test.mvc.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getRealPath("/board/files");  // application 객체로 교체될거라 줄이 그인다.
		int size = 100 * 1024 * 1024;
		
		
		
		
		try {
			
		Check check = new Check();
		check.isauth(req, resp);
		
		MultipartRequest multi = new MultipartRequest(
				req,
				path, // 업로드 폴더 지정
				size, // 파일 최대 크기
				"UTF-8", // getParameter() 인코딩 방식
				new DefaultFileRenamePolicy() // 파일명 관리
		); // 첨부파일 업로드 완료
		
		// editok.do == addok.do 유사
		// 1. 데이터 가져오기(subject, content, tag)
		
		// 2. DTO 생성 + 데이터 추가
		
		// 3. DAO 위임(UPDATE)
		
		// 4. 결과 반환 + JSP 호출하기	
		
		req.setCharacterEncoding("UTF-8");

		
		// 1. 데이터 가져오기(subject, content, tag)
		
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String tag = multi.getParameter("tag");
		String seq = multi.getParameter("seq");
		
		String delfile = multi.getParameter("delfile");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();		
		// 첨부파일 삭제작업(물리 + DB)
		
		BoardDTO temp = dao.get(seq);
		String filename = "";
		String orgfilename = "";
		String ftemp = multi.getFilesystemName("attach");
		
		/*
		
		1. 기존 첨부파일명 클릭 > 파일 삭제
		2. 기존 첨부파일명 방치 + 새로운 파일 선택 > 파일 교체
		3. 기존 첨부파일명 방치 + 새로우 파일 선택 X > 기존 파일 유지
		
		
		[파일 컨트롤]	[파일명]
		X		X	-> 기존 파일 유지		//O
		X		O	-> 기존 파일 삭제		//O
		O		X	-> 기존 파일 삭제 + 새파일 추가	//X
		O		O	-> 기존 파일 삭제 + 새파일 추가	//X
		
		*/
		
		if (delfile.equals("y") && ftemp == null) {
			
			File file = new File(path + "\\" + temp.getFilename());
			file.delete();
			// 다운로드 카운트를 0으로 초기화 update
			
			//dao.updateFileName(seq);
			
			filename = "";
			orgfilename = "";
			
			
		} else if (delfile.equals("n") && ftemp == null) {
			
			filename = temp.getFilename();
			orgfilename = temp.getOrgfilename();
			
		} else if (ftemp != null) { // 새 첨부파일이 존재 하기만 하면
			// 다운로드 카운트를 0으로 초기화 update
			
			// 기존 파일 삭제
			File file = new File(path + "\\" + temp.getFilename());
			file.delete();
			
			// 새파일 등록
			filename = multi.getFilesystemName("attach");
			orgfilename = multi.getOriginalFileName("attach");
			
		} 

		// 첨부 파일명 얻기
		// String filename = multi.getFilesystemName("attach"); // 물리명
		// String orgfilename = multi.getOriginalFileName("attach"); // 원본명
				
		dto.setFilename(filename);
		dto.setOrgfilename(orgfilename);		
		
		// 2.
		
		dto.setSubject(subject);		
		dto.setContent(content);
		dto.setTag(tag);
		dto.setSeq(seq);
		
		
		
		
		// 3. 
		int result = -1;
		
		BoardDTO dto2 = dao.get(seq);
		
		
		if (dto2.getId().equals((String)req.getSession().getAttribute("auth"))) { // 자기가 쓴글인지? 
			result = dao.edit(dto);
		} else {
			result = 2;
		}
		
		
		// 4. 
		req.setAttribute("result", result);
		req.setAttribute("seq", seq);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/editok.jsp");
		dispatcher.forward(req, resp);
		
	}

}

