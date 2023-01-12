package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodayMenu
 */
@WebServlet("/todayMenu")
public class TodayMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' /><title>SELECT & POST</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div style='text-align:center'>오늘 점심은 <strong>");
		String[] paramLunch = request.getParameterValues("lunch");
		for(int i = 0; i < paramLunch.length; i++) {
			out.print(paramLunch[i]);
			if(i<paramLunch.length-1) out.print(", ");
		}
		//Arrays.toString(values);
		out.println("</strong>이나 먹어야 겠다.</div>");
		out.println("</body>");
		out.println("</html>");
	
		out.close();
	}

}
