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

@WebServlet("/management/addofferdata.do")
public class AddOfferData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String art_seq = req.getParameter("art_seq"); // 대상 연예인
		String schedule_name = req.getParameter("schedule_name");
		String schedule_place = req.getParameter("schedule_place");
		String schedule_start = req.getParameter("schedule_start");
		String schedule_end = req.getParameter("schedule_end");
		String schedule_pay = req.getParameter("schedule_pay");
		String seltype = req.getParameter("seltype");
		
		
		String member_seq = (String)req.getSession().getAttribute("auth"); // 작성자
		
		ScheduleDTO dto = new ScheduleDTO();
		

		
		
		dto.setArt_seq(art_seq);
		dto.setMember_seq(member_seq);
		dto.setName(schedule_name);
		dto.setSchedule_place(schedule_place);
		dto.setSchedule_start(schedule_start);
		dto.setSchedule_end(schedule_end);
		dto.setSchedule_pay(schedule_pay);
		dto.setSchedule_type(seltype);
		
		
		ManagementDAO dao = new ManagementDAO();
		
		String type = req.getParameter("type");
		
		int result = dao.addoffer(dto, type);
		
		// "/" -> WebContent
		req.setAttribute("art_seq", art_seq);
		req.setAttribute("result", result);
		req.setAttribute("type", type);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/management/addofferdata.jsp");
		dispatcher.forward(req, resp);

	}

}
