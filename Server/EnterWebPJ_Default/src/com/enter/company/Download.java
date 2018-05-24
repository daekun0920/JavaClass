package com.enter.company;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.management.Check;

@WebServlet("/company/download.do")
public class Download extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		
		check.authcheck("member", req, resp);

		
		// 파일 다운로드 처리
		String fileName = req.getParameter("filename");
		String orgfileName = req.getParameter("orgfilename");	
		
		String savePath = "/files";
		ServletContext context = getServletContext();
		String sDownloadPath = context.getRealPath(savePath);
		


		String sFilePath = sDownloadPath + "/" + fileName;
		byte b[] = new byte[4096];
		FileInputStream in = new FileInputStream(sFilePath);
		String sMimeType = getServletContext().getMimeType(sFilePath);
		System.out.println("sMimeType>>>" + sMimeType);

		if (sMimeType == null)
			sMimeType = "application/octet-stream"; //MIME. 브라우저에게 해석할 수 없는 데이터라고 타입을 속여서 보내는 작업 중 하나

		resp.setContentType(sMimeType);
		String agent = req.getHeader("User-Agent");
		boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);

		if (ieBrowser) {
			orgfileName = URLEncoder.encode(orgfileName, "UTF-8").replaceAll("/+", "%20");
		} else {
			orgfileName = new String(orgfileName.getBytes("UTF-8"), "iso-8859-1");
		}

		resp.setHeader("Content-Disposition", "attachment; filename= " + orgfileName);

		ServletOutputStream out2 = resp.getOutputStream();
		int numRead;

		while ((numRead = in.read(b, 0, b.length)) != -1) {
			out2.write(b, 0, numRead);
		}
		
		
		out2.flush();
		out2.close();
		in.close();
		

	}

}
