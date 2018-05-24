package com.enter.promotion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.promotion.model.PromotionDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/promotion/artistadd.do")
public class ArtistAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String path = req.getRealPath("./files");
		int size = 100 * 1024 * 1024;
		
		
		try {
			System.out.println(path);
			
			// 1. 데이터 가져오기(subject, content, tag)
			
			// 2. DTO 생성 + 데이터 추가
			
			// 3. DAO 위임(insert)
			
			// 4. 결과 반환 + JSP 호출하기	
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			// 1. 데이터 가져오기(subject, content, tag)
			
			// req -> 역할 교체 -> multi
			MultipartRequest multi = new MultipartRequest(
										req,
										path, // 업로드 폴더 지정
										size, // 파일 최대 크기
										"UTF-8", // getParameter() 인코딩 방식
										new DefaultFileRenamePolicy() // 파일명 관리
									); // 첨부파일 업로드 완료
			
			
			// 첨부 파일명 얻기
			String filename = multi.getFilesystemName("attach"); // 물리명(name 값)
			String orgfilename = multi.getOriginalFileName("attach"); // 원본명(name 값)
			String profileseq = multi.getParameter("star_profile_seq");
			
			
			PromotionDAO dao = new PromotionDAO();
			
			dao.putFiles(filename, orgfilename, profileseq);
			

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/promotion/artist/introduce.jsp?star_profile_seq=" + profileseq);
			dispatcher.forward(req, resp);
	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
