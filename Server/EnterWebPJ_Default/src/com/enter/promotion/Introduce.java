package com.enter.promotion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.promotion.artist.model.ArtistDAO;
import com.enter.promotion.artist.model.StarListDTO;


@WebServlet("/promotion/introduce.do")
public class Introduce extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//list.jsp에서 view.do?seq=1 이걸로 데이터 넘김, get방식으로 넘기는 것과 같음
	      
	      //1. 데이터 받아오기(seq)
	      //2. DAO 위임(select)
	      //3. 결과 반환(dto) + 전달 + JSP 호출하기
	      
	      
	      //세션 받아오기(List.java에서 보냄)
	     // HttpSession session = req.getSession();
	      
	      
	      //1. 
	       String star_profile_seq = req.getParameter("star_profile_seq");
	      
	      //2. 
	      //  ArtistDAO dao = new ArtistDAO();
	      

	      //2.2 
	      //영문이름, 이름, 생년월일 가져오기
	      
	    // StarListDTO dto = dao.getStarList(star_profile_seq);
	      
	      
	     //2.5
	      //데이터 가공 


	  
		
		//req.setAttribute("star_profile_seq", star_profile_seq);
				
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/promotion/artist/introduce.jsp");
		dispatcher.forward(req, resp);
	}

}