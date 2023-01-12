package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chungnam.ChungnamDAO;
import com.chungnam.ChungnamVO;

/**
 * Servlet implementation class ChungnamInsert
 */
@WebServlet("/insert")
public class ChungnamInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		int mng_no = Integer.parseInt(request.getParameter("mng_no"));
		String local_nm = request.getParameter("local_nm");
		String type = request.getParameter("type");
		String nm = request.getParameter("nm");
		String nm_sub = request.getParameter("nm_sub");
		String addr = request.getParameter("addr");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String description = request.getParameter("description");
		String list_img = request.getParameter("list_img");
		
		ChungnamVO cvo = new ChungnamVO();
		cvo.setMng_no(mng_no);
		cvo.setLocal_nm(local_nm);
		cvo.setType(type);
		cvo.setNm(nm);
		cvo.setNm_sub(nm_sub);
		cvo.setAddr(addr);
		cvo.setLat(lat);
		cvo.setLng(lng);
		cvo.setDescription(description);
		cvo.setList_img(list_img);
		
		ChungnamDAO dao = ChungnamDAO.getInstance();
		int result = dao.chungnamInsert(cvo);
		if(result == 1) {
			response.sendRedirect("/servletExample/select");
		} else {
			response.sendRedirect("/servletExample/jdbc/chungnamForm.jsp");
		}
		
		
		out.close();
	}
}
