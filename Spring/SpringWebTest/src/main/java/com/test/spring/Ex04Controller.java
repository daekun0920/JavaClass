package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 컨트롤러 구현
// 1. Controller 인터페이스
// 2. @Controller 어노테이션 사용

@Controller
@RequestMapping(value="/ex04.action")
public class Ex04Controller {
	
	// 요청 메소드 : doGet(), doPost(), handleRequest()
	@RequestMapping
	public String m1() {
		
		// 업무 실행
		
		// 뷰 호출
		
		return "ex04"; // ModelAndView + "ex04" + return mv;
		
		
	}
	
	
	
}
