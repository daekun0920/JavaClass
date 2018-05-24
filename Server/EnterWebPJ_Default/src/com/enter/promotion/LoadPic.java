package com.enter.promotion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.enter.promotion.model.PromotionDAO;

@WebServlet("/promotion/loadpic.do")
public class LoadPic extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		String profseq = req.getParameter("profseq");
		
		PromotionDAO dao = new PromotionDAO();
		
		String filename = dao.loadfilenames(profseq);
		
		JSONObject job = new JSONObject();
		
		job.put("filename", filename);
		
		resp.getWriter().print(job);
		resp.getWriter().close();

	}

}
