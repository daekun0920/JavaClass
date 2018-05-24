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

@WebServlet("/management/addstaff.do")
public class AddStaff extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		
		String stafftype = req.getParameter("stafftype");
		String star = req.getParameter("star");
		String staff = req.getParameter("staff");
		
		System.out.println(stafftype + star + staff);
		
		StaffDTO dto = new StaffDTO();
		
		dto.setStaff_type(stafftype);
		dto.setStaff_seq(staff);
		
		ManagementDAO dao = new ManagementDAO();
		
		
		
		int result = dao.changeStaff(dto, star);
		System.out.println(000000);
		JSONObject job = new JSONObject();
		
		job.put("result", result);
		
		resp.getWriter().print(job);
		resp.getWriter().close();
	}

}
