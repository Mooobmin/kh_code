package com.forward.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet4
 */
@WebServlet("/secondDispatcher")
public class SecondServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		
//		String language = request.getParameter("language");
		String language = (String)request.getAttribute("language");
		String name = (String)request.getAttribute("name");
		String address = (String)request.getAttribute("address");
		
		
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' /><title>Dispatcher 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<div>우리가 배운 언어 : " + language + "</div>");
		out.println("<div>나의 이름은 " + name + "입니다.</div>");
		out.println("<div>내가 사는곳은 " + address + " 입니다.</div>");
		out.println("<div>dispatch를 이용한 forward실습입니다.</div>");
		out.println("</body></html>");
	}
}
