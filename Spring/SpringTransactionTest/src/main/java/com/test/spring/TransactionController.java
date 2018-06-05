package com.test.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransactionController {
	
	@Autowired
	private IService service;
	
	@RequestMapping(value = "/del.tran")
	private String del() {
		// 폼 페이지
		
		return "board.del";
	}
	
	@RequestMapping(value="/delok.tran")
	private String delok(HttpServletRequest req) {
		
		//삭제 완료 페이지
		int result = service.delok();
		
		req.setAttribute("result", result);
		
		return "board.delok";
	}
}
