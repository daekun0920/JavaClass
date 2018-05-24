package com.enter.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.company.model.CompanyDAO;
import com.enter.company.model.NoticeDTO;
import com.enter.management.Check;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/company/addnoticeok.do")
public class AddNoticeOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check2 = new Check();
		check2.authcheck("staff", req, resp);
		
		
		String path = req.getRealPath("/files");
		
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
			
			String check = multi.getParameter("check");
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			
			// 첨부 파일명 얻기
			String filename = multi.getFilesystemName("file"); // 물리명
			String orgfilename = multi.getOriginalFileName("file"); // 원본명
			
			// System.out.println(filename); // null 
			
			// 공지글
			// - 체크박스 선택 O : value or "on"
			// - 체크박스 선택 X : null
			NoticeDTO dto = new NoticeDTO();
			if (check != null) {
				dto.setCheck("1");
			} else {
				dto.setCheck("0");
			}
			
			
			
			dto.setTitle(title);
			dto.setContent(content);
			//dto.setStaffseq(req.getParameter("seq"));
			dto.setStaffseq("1");
			// 첨부파일명 추가
			
			dto.setFile(filename);
			dto.setOrgfile(orgfilename);
			
			CompanyDAO dao = new CompanyDAO();
			
			int result = dao.addNotice(dto);
	
			req.setAttribute("result", result);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/company/addnoticeok.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

