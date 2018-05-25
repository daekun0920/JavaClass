package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// 1. Controller
// - Controller 인터페이스를 구현하지 않으면 이 클래스를 DispatcherServlet이 찾지를 못한다.
public class Ex02Controller implements Controller {

	// 2. 요청 메소드 구현
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// 3. 업무 실행(DB Select)
		String name = "홍길동";
		int age = 20;
		String address = "서울시";
		String gender = "남자";
		
		
		// 4. 뷰 호출 + 데이터 전송
		//		a. 이전 방식 : req.setAttribute()
		//		b. 스프링 : ModelAndView + req.setAttribute()
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ex02"); // servlet-context.xml > ViewResolver > "/WEB-INF/views/" + "ex02" + ".jsp"
		
		
		// 데이터 전달(새로운 방식)
		mv.addObject("name", name);
		mv.addObject("age", age);
		
		// 데이터 전달(기존 방식)
		req.setAttribute("address", address);
		req.setAttribute("gender", gender);
		
		return mv; // dispatcher.forward(req, resp); 와 동일
	}
	
	
}
