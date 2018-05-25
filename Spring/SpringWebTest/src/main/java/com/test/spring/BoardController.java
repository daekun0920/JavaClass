package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 다수의 서블릿 역할 -> 1개의 컨트롤러
@Controller
public class BoardController {
	
	// 의존 주입
	//private BoardDAO dao;
	
	@RequestMapping(value="/board/add.action", method= {RequestMethod.GET})
	public String add() {
		
		
		return "board/add"; // "WEB-INF/views/board/add.jsp"
	}
	
	@RequestMapping(value="/board/addok.action", method= {RequestMethod.POST})
	public String addok() {
		
		// DB 작업
		
		return "board/addok"; // "WEB-INF/views/board/addok.jsp"
	}
	
	@RequestMapping(value="/board/list.action", method= {RequestMethod.GET})
	public String list() {
		
		// DB 작업
		
		return "board/list"; // "WEB-INF/views/board/addok.jsp"
	}
	
	@RequestMapping(value="/board/view.action", method= {RequestMethod.GET})
	public String view() {
		
		// DB 작업
		
		return "board/view"; // "WEB-INF/views/board/addok.jsp"
	}
	
	
}










