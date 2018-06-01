package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mainController")
public class MainController {

	//회원 업무
	@RequestMapping(value="/member/info.action")	
	public String info() {
		
		return "member/info";
	}
	
	@RequestMapping(value="/member/point.action")	
	public String point() {
		
		return "member/point";
	}
	
	//관리자 업무
	@RequestMapping(value="/admin/data.action")	
	public String data() {
		
		return "admin/data";
	}
	
	@RequestMapping(value="/admin/chart.action")	
	public String chart() {
		
		return "admin/chart";
	}
	
}















