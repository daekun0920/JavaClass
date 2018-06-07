package com.test.spring.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	// 의존 객체 주입
	@Autowired
	private IBoardDAO dao;
	
	// 업무 ...
	// 목록 보기
	@RequestMapping(method = {RequestMethod.GET}, value = "/board/list.aop")
	public String list(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		
		
		return "list";
	}
	
	// 글 쓰기
	@RequestMapping(method = {RequestMethod.GET}, value = "/board/add.aop")
	public String add(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		
		
		return "add";
	}
	
	// 글 보기
	@RequestMapping(method = {RequestMethod.GET}, value = "/board/view.aop")
	public String view(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		
		
		return "view";
	}
}
