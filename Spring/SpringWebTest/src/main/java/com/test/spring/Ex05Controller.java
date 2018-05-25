package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/add.action")
public class Ex05Controller {

	@RequestMapping
	public String add() {
		
		
		return "ex05";
	}
	
}
