package com.enter.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.company.model.CompanyDAO;
import com.enter.company.model.NoticeDTO;
import com.enter.management.Check;

@WebServlet("/company/notice.do")
public class Notice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("auth", 1);
		
		Check check = new Check();
		
		check.authcheck("member", req, resp);
		
		String page = req.getParameter("page");
		int nowPage = 1;
		int pagePerBlock = 10;
		
		String isSearch = req.getParameter("issearch");
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		
		HashMap<String, String> map = new HashMap<>();
		
		
		map.put("isSearch", isSearch);
		map.put("category", category);
		map.put("keyword", keyword);
		
		
		if (page == null) {
			nowPage = 1;
		} else { 
			nowPage = Integer.parseInt(page);
		}
		
		CompanyDAO dao = new CompanyDAO();
		
		ArrayList<NoticeDTO> list = dao.noticelist(nowPage, map);
		int totalPage = dao.getTotalPage(map);
		
		// 데이터 가공
		if (category != null && category.equals("stitle")) {
			for (NoticeDTO dto : list) {
				
				dto.setTitle(dto.getTitle().replace(keyword, "<span style = 'background-color:yellow;'>" + keyword + "</span>"));
				
			}
		}
		int loop = 1;
		int num = ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		
		String pagebar = "<nav id = \"pagebar\">   <ul class=\"pagination\">";
		


	
		if (num == 1) {
			pagebar  += String.format(" <li class = 'disabled'>\r\n" + 
					"      <a aria-label=\"Previous\" onclick = 'event.preventDefault();'>\r\n" + 
					"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
					"      </a>\r\n" + 
					"    </li>");
		} else {
			
			if (isSearch == null) {
				pagebar += String.format(" <li>\r\n" + 
						"				      <a href='/enter/company/notice.do?page=%d' aria-label=\"Previous\">\r\n" + 
						"				        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
						"				      </a>\r\n" + 
						"				    </li>", num - 1);
			} else {
				pagebar += String.format(" <li>\r\n" + 
						"				      <a href='/enter/company/notice.do?page=%d&issearch=1&category=%s&keyword=%s' aria-label=\"Previous\">\r\n" + 
						"				        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
						"				      </a>\r\n" + 
						"				    </li>", num - 1, category, keyword);
				
			}
		}
		
		
		// 10 페이지 단위로 페이지 링크 만들기
		while (!(loop > pagePerBlock || num > totalPage)) {
			if (num == nowPage) {
				pagebar += String.format(" <li class = 'active'><a>%d</a></li>", num);
			} else {
				if (isSearch != null) {
				
					pagebar += String.format("  <li><a href='/enter/company/notice.do?page=%d&issearch=1&category=%s&keyword=%s'>%d</a></li>", num, category, keyword, num);
				
				} else {
					pagebar += String.format("  <li><a href='/enter/company/notice.do?page=%d'>%d</a></li>", num, num);
				}
			}
			
			loop++;
			num++;
		}
		
		
		
		// 다음 10페이지
		if (num > totalPage) {
			//pagebar += String.format("<a>[다음 %d페이지]</a>", blockSize);
			pagebar += String.format("<li class = 'disabled'>\r\n" + 
					"      <a aria-label=\"Next\" onclick = 'event.preventDefault();'>\r\n" + 
					"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
					"      </a>\r\n" + 
					"    </li>");
		} else {
			if (isSearch == null) {
			//pagebar += String.format("<a href = '/mvc/board/list.do?page=%d'>[다음 %d페이지]</a>", n, blockSize);
			pagebar += String.format("  <li>\r\n" + 
					"				      <a href='/enter/company/notice.do?page=%d&issearch=1&category=%s&keyword=%s' aria-label=\"Next\">\r\n" + 
					"				        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
					"				      </a>\r\n" + 
					"				    </li>\r\n" + 
					"				  </ul>", num, category, keyword);
			}
		}
		
		pagebar += "</nav> ";
		
		
		
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("list", list);
		
		// "/" -> WebContent
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/company/notice.jsp");
		dispatcher.forward(req, resp);

	}

}
