package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// add.action
// addok.action

// edit.action
// editok.action

@Controller
public class Ex06Controller {
	
	
	
	@RequestMapping(value="/edit.action")
	public String edit() {
		
		return "edit";
		
	}
	
	@RequestMapping(value="/editok.action")
	public String editok() {
		
		
		
		return "editok";
	}
	
	public String test() {
		// 일반 메소드
		
		return "test";
	}
	
	
}
















