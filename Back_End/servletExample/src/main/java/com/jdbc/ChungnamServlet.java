package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chungnam.ChungnamDAO;
import com.chungnam.ChungnamVO;

/**
 * Servlet implementation class ChungnamServlet
 */
@WebServlet("/select")
public class ChungnamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ChungnamDAO dao = ChungnamDAO.getInstance();
		ArrayList<ChungnamVO> list = dao.getChungnamList();
		int counter = list.size();
		
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>Chungnam 정보 리스트 예제</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("<link rel='stylesheet' type='text/css' href='/servletExample/css/chungnam.css' />");
		out.println("<script type='text/javascript' src='/servletExample/js/jquery-3.6.2.min.js'></script>");
		out.println("<script type='text/javascript' src='/servletExample/js/common.js'></script>");
		out.println("<script type='text/javascript'>");
		out.println("$(function(){");
		out.println("   $('.delBtn').click(function(){");
		out.println("      if(confirm('정보를 삭제하시겠습니까?')){");
		out.println("      let mng_no = $(this).parents('li').attr('data-no'); console.log(mng_no)");
		out.println("      location.href='/servletExample/delete?mng_no=' + mng_no;");
		out.println("      }");
		out.println("    })");
		out.println("});");
		out.println("</script>");
		out.println("</head>");
		out.println("<body><h1 class='title'>충남관광 - 관광명소</h1> ");
		out.println("<div class='btn'><a href='/servletExample/jdbc/chungnamForm.jsp'>정보등록</a></div>");
		out.println("<ul id='list'>");
		if(counter > 0) {
			// for(int i=0; i < counter; i++) { // 인덱스 접근 시
			// ChungnamVO cvo = list.get(i);
			for(ChungnamVO cvo : list) {
				out.println("<li class='item' data-no='" + cvo.getMng_no() + "'>");
				out.println("<span class='item-thumb'><img src='" + cvo.getList_img() + "' /></span>");
				out.println("<span class='text'>");
				out.println("<span class='item-type'>" + cvo.getType());
				out.println("</span>");
				out.println("<span class='item-title'>" + cvo.getNm());
				out.println("<button type='button' class='delBtn'>삭제</button>");
				out.println("</span>");
				out.println("<span class='item-sub'>" + cvo.getNm_sub());
				out.println("</span>");
				out.println("</li>");
			}
		}
		out.println("</ul>");
		out.println("</body></html>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
