package com.enter.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.management.model.ManagementDAO;
import com.enter.management.model.ScheduleDTO;

@WebServlet("/management/scheduleboard.do")
public class ScheduleBoard extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		
		String page = req.getParameter("page");
		
		String star = req.getParameter("star"); // 연예인 파라미터
		String type = req.getParameter("type");
		String isSearch = req.getParameter("search"); // 검색 여부
		String category = req.getParameter("category"); // 검색 카테고리
		String keyword = req.getParameter("key"); // 키워드
		
		
		System.out.println("타입이다 " + type);
		if (page == null) {
			
			page = "1";
			
		}
		
		int nowPage;
		int postPerPage = 10;
		
		
		nowPage = Integer.parseInt(page);
		
		
		int start;
		int end;
		
		start = nowPage * 10 - 9;
		end =  nowPage * 10;
		
		ManagementDAO dao = new ManagementDAO();
		
		ArrayList<ScheduleDTO> list = dao.getScheduleRequest(start, end, isSearch, keyword, category, star, type); // 검색중일경우 해당되는 결과만
		
		double countPosts = dao.countPosts(star); // 연예인 개별 카운트
		
		
		
		
		int pages = (int)Math.ceil(countPosts / postPerPage);
		
		int startPage = ((nowPage * 10) / nowPage) - 9;
		
		
	String pagebar = "<nav id = \"pagebar\">   <ul class=\"pagination\">";
		
		/*	
		  
	   for (int i = 1; i <= totalPage; i++) {
			if (i == nowPage) {
				pagebar += String.format(" <a href = '#' onclick = 'event.preventDefault();'><b>%d</b></a>", i, i);
			} else {
				pagebar += String.format(" <a href = '/mvc/board/list.do?page=%d'>%d</a>", i, i);
			}
		}
		
		*/
		
		int loop = 1; // 회전수 조절: 루프 변수
		// n = 1; // 페이지 / 페이지 변수 / 해당 nowPage 10페이지의 첫 페이지(예 : nowPage = 13 -> n  = 11)
		int n = ((nowPage - 1) / postPerPage) * postPerPage + 1; //
		
		if (isSearch == null) { // 검색중이 아닐때 페이징
		
			// 이전 10페이지
			if (n == 1) {
				pagebar  += String.format(" <li class = 'disabled'>\r\n" + 
						"      <a aria-label=\"Previous\" onclick = 'event.preventDefault();'>\r\n" + 
						"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
						"      </a>\r\n" + 
						"    </li>");
			} else {
				//System.out.println(n);
				//pagebar += String.format("<a href = '/mvc/board/list.do?page=%d'>[이전 %d페이지]</a>", n - 1, blockSize);
				pagebar += String.format(" <li>\r\n" + 
						"				      <a href='/mvc/board/list.do?page=%d&star=%s&type=%s' aria-label=\"Previous\">\r\n" + 
						"				        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
						"				      </a>\r\n" + 
						"				    </li>", n - 1, star, type);
			}
			
			
			// 10 페이지 단위로 페이지 링크 만들기
			while (!(loop > postPerPage || n > pages)) {
				System.out.println(1);
				if (n == nowPage) {
					pagebar += String.format(" <li class = 'active'><a>%d</a></li>", n);
				} else {
					pagebar += String.format("  <li><a href='/enter/management/scheduleboard.do?page=%d&star=%s&type=%s'>%d</a></li>", n, star, type, n);
					
				}
				
				loop++;
				n++;
			}
			
			
			
			// 다음 10페이지
			if (n > pages) {
				//pagebar += String.format("<a>[다음 %d페이지]</a>", blockSize);
				pagebar += String.format("<li class = 'disabled'>\r\n" + 
						"      <a aria-label=\"Next\" onclick = 'event.preventDefault();'>\r\n" + 
						"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
						"      </a>\r\n" + 
						"    </li>");
			} else {
				//pagebar += String.format("<a href = '/mvc/board/list.do?page=%d'>[다음 %d페이지]</a>", n, blockSize);
				pagebar += String.format("  <li>\r\n" + 
						"				      <a href='/mvc/board/list.do?page=%d&star=%s&type=%s' aria-label=\"Next\">\r\n" + 
						"				        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
						"				      </a>\r\n" + 
						"				    </li>\r\n" + 
						"				  </ul>", n, star, type);
			}
			
			pagebar += "</nav> ";
		
		} else { // 검색중 페이징
			
			// 이전 10페이지
			if (n == 1) {
				pagebar  += String.format(" <li class = 'disabled'>\r\n" + 
						"      <a aria-label=\"Previous\" onclick = 'event.preventDefault();'>\r\n" + 
						"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
						"      </a>\r\n" + 
						"    </li>");
			} else {
				//System.out.println(n);
				//pagebar += String.format("<a href = '/mvc/board/list.do?page=%d'>[이전 %d페이지]</a>", n - 1, blockSize);
				pagebar += String.format(" <li>\r\n" + 
						"				      <a href='/mvc/board/list.do?page=%d&category=%s&key=%s&search=%s&star=%s&type=%s' aria-label=\"Previous\">\r\n" + 
						"				        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
						"				      </a>\r\n" + 
						"				    </li>", n - 1, category, keyword, isSearch, star, type);
			}
			
			
			// 10 페이지 단위로 페이지 링크 만들기
			while (!(loop > postPerPage || n > pages)) {
				System.out.println(1);
				if (n == nowPage) {
					pagebar += String.format(" <li class = 'active'><a>%d</a></li>", n);
				} else {
					pagebar += String.format("  <li><a href='/mvc/board/list.do?page=%d&category=%s&key=%s&search=%s&star=%s&type=%s'>%d</a></li>", n, n, category, keyword, isSearch, star, type);
					
				}
				
				loop++;
				n++;
			}
			
			
			
			// 다음 10페이지
			if (n > pages) {
				//pagebar += String.format("<a>[다음 %d페이지]</a>", blockSize);
				pagebar += String.format("<li class = 'disabled'>\r\n" + 
						"      <a aria-label=\"Next\" onclick = 'event.preventDefault();'>\r\n" + 
						"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
						"      </a>\r\n" + 
						"    </li>");
			} else {
				//pagebar += String.format("<a href = '/mvc/board/list.do?page=%d'>[다음 %d페이지]</a>", n, blockSize);
				pagebar += String.format("  <li>\r\n" + 
						"				      <a href='/mvc/board/list.do?page=%d&category=%s&key=%s&search=%s&star=%s&type=%s' aria-label=\"Next\">\r\n" + 
						"				        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
						"				      </a>\r\n" + 
						"				    </li>\r\n" + 
						"				  </ul>", n, category, keyword, isSearch, star, type);
			}
			
			pagebar += "</nav> ";
			
		}
		
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("list", list);
		req.setAttribute("keyword", keyword);
		req.setAttribute("category", category);
		req.setAttribute("star", star);
		req.setAttribute("type", type);
		
		// "/" -> WebContent
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/management/scheduleboard.jsp");
		dispatcher.forward(req, resp);

	}

}
