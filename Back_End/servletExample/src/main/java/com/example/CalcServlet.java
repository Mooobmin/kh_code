package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1, num2;
		int result = 0;
		String op;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
		
		result = calc(num1, num2, op);
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' /><title>간단한 연산 결과</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>계산결과</h2>");
		out.println("<hr style='width:28; margin-left:0px'/>");
		out.println(num1 + " " + op + " " + num2 + " = " + result);
		out.println("</body>");
		out.println("</html>");
	
		out.close();
		}	
		public int calc(int num1, int num2, String op) {
			int result = 0;
			if(op.equals("+")) {
				result = num1 + num2;
			} else if(op.equals("-")) {
				result = num1 - num2;
			} else if(op.equals("*")) {
				result = num1 * num2;
			} else if(op.equals("/")) {
				if(num2!=0) {
					result = num1 / num2;
				} else {
					result = 0;
				}
			}
			return result;
		}
		
	

}
