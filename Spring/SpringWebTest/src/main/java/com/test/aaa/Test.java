package com.test.aaa;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test.action")
public class Test {

	

	@RequestMapping
	public String addok(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		
		// 1. 데이터 가져오기
		// 2. 업무
		// 3. 뷰 호출
	
		
		
		return "test";
		
	}
}
