package com.test.spring;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/addok.action") // 실 주소가 아닌 매핑 주소를 따라간다.
public class Ex05OkController {
	
	@RequestMapping
	public String addok(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws UnsupportedEncodingException {
		
		// 1. 데이터 가져오기
		// 2. 업무
		// 3. 뷰 호출
		// req.setCharacterEncoding("UTF-8");
		
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		req.setAttribute("name", name);
		req.setAttribute("age", age);
		session.setAttribute("test", "test");
		
		
		return "ex05ok";
		
	}
	
}
