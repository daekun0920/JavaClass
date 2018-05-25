package com.test.spring;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Ex03Controller implements Controller {
	
	private Ex03DAO dao;
	private Random rnd;
	
	
	public Ex03Controller(Ex03DAO dao, Random rnd) {
		this.dao = dao;
		this.rnd = rnd;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		// 업무 발생
		// Ex03DAO dao = new Ex03DAO();
		String name = dao.getName();
		
		//Random rnd = new Random();
		
		int num = rnd.nextInt();
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ex03");
		
		mv.addObject("name", name);
		mv.addObject("num", num);
		
		return mv;
	}

	
	
}
