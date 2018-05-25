package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ex08Controller {
	
	// 기존 서블릿 
	// 1. 가상 주소
	// 2. doGet/doPost
	
	@RequestMapping(value = "/get.action", method= {RequestMethod.GET})
	public String m1() {
		
		return "get";
	}
	
	@RequestMapping(value = "/post.action", method= {RequestMethod.POST})
	public String m2() {
		
		return "post";
	}
	
}
