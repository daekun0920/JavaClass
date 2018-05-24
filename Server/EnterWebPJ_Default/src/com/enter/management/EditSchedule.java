package com.enter.management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.management.model.ManagementDAO;
import com.enter.management.model.ScheduleDTO;

@WebServlet("/management/editschedule.do")
public class EditSchedule extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String star = req.getParameter("scstar");
		String seq = req.getParameter("scseq");
		String name = req.getParameter("scname");
		String place = req.getParameter("scplace");
		String start = req.getParameter("scstart");
		String end = req.getParameter("scend");
		String pay = req.getParameter("scpay");
		String artseq = req.getParameter("artseq");
		
		ScheduleDTO dto = new ScheduleDTO();
		
		dto.setSchedule_seq(seq);
		dto.setName(name);
		dto.setSchedule_place(place);
		dto.setSchedule_start(start);
		dto.setSchedule_end(end);
		dto.setSchedule_pay(pay);
		
		System.out.println(seq);
		
		
		ManagementDAO dao = new ManagementDAO();
		
		int result = dao.editSchedule(dto);
		
		req.setAttribute("starname", star);
		req.setAttribute("scseq", seq);
		req.setAttribute("result", result);
		req.setAttribute("artseq", artseq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/management/editschedule.jsp");
		dispatcher.forward(req, resp);
		
	}

}
