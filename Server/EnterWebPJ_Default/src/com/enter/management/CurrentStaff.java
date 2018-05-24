package com.enter.management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.enter.management.model.ManagementDAO;
import com.enter.management.model.StaffDTO;

@WebServlet("/management/currentstaff.do")
public class CurrentStaff extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("utf-8");
		
		String stafftype = req.getParameter("stafftype");
		String star = req.getParameter("star");
		
		ManagementDAO dao = new ManagementDAO();
		
		StaffDTO dto = dao.currstaff(stafftype, star);
		
		JSONObject job = new JSONObject();
		
		job.put("staff_name", dto.getStaff_name());
		job.put("staff_seq", dto.getStaff_seq());
		
		
		resp.getWriter().print(job);
		resp.getWriter().close();
		
	}

}
