package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


// 기존의 컨트롤러(서블릿)과의 차이점
// 1. 선언 방식
//   a. Controller 인터페이스 구현
//	 b. @Controller 어노테이션 사용

// 2. handleRequest 메소드
// - doGet/doPost와 같은 역할
public class Ex01 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		// 3. ModelAndView 반환
		//	- RequestDispatcher와 같은 역할
		//		a. 뷰를 호출한다
		//		b. request.response 전달
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ex01"); // jsp 이름
		
		
		return mv;
	}
	
	
	
}
