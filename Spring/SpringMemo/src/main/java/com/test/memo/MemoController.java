package com.test.memo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoController {
	
	private IMemo dao;
	
	// 의존 주입으로 나중에 바꿈
	public MemoController() {
		this.dao = new MemoDAO();
	}
	
	// 템플릿 작업
	@RequestMapping(method= {RequestMethod.GET}, value = "/template.memo")
	public String template(HttpServletRequest req) {
		
		
		return "template"; // WEB-INF/views/memo/template.jsp
	}
	
	@RequestMapping(method= {RequestMethod.GET}, value = "/login.memo")
	public String login(HttpServletRequest req, HttpSession session, String id) {
		
		// 로그인 처리
		session.setAttribute("auth", id);
		
		// 컨트롤러 -> 또다른 컨트롤러 호출
		// resp.sendRedirect() 유사
		return "redirect:/add.memo"; 
	}
	
	@RequestMapping(method= {RequestMethod.GET}, value = "/add.memo")
	public String add() {
		
		
	
		return "add"; 
	}
	
	@RequestMapping(method= {RequestMethod.POST}, value = "/addok.memo")
	public String addok(HttpServletRequest req, HttpSession session, MemoDTO dto) {
		
		System.out.println(dto.getCategory());
		System.out.println(dto.getMemo());
		
		dto.setId((String)session.getAttribute("auth"));
		
		int result = dao.add(dto);
		
		req.setAttribute("result", result);
		
		
		return "addok"; 
	}
	
	@RequestMapping(method= {RequestMethod.GET}, value = "/index.memo")
	public String index(HttpServletRequest req) {
		
		
		List<MemoDTO> list = dao.list();
		
		req.setAttribute("list", list);
	
		return "index"; 
	}
	
	@RequestMapping(method= {RequestMethod.GET}, value = "/edit.memo")
	public String edit(HttpServletRequest req, String seq) { // 1
		
		// 수정
		// 1. 식별자 받아오기(seq)
		// 2. DAO 위임 -> seq에 해당하는 DTO 주세요.
		// 3. 뷰 페이지 호출 + DTO 전달
		
		MemoDTO dto = dao.get(seq);
		
		req.setAttribute("dto", dto);
	
		return "edit"; 
	}
	
	
	@RequestMapping(method= {RequestMethod.POST}, value = "/editok.memo")
	public String editok(HttpServletRequest req, MemoDTO dto) { // 1
		
		int result = dao.editmemo(dto);
		
		req.setAttribute("result", result);
	
		return "editok"; 
	}
}
