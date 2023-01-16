package com.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chungnam.ChungnamDAO;
import com.chungnam.ChungnamVO;

/**
 * Servlet implementation class ChungnamDelete
 */
@WebServlet("/delete")
public class ChungnamDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ChungnamDAO dao = ChungnamDAO.getInstance();
		
		ChungnamVO vo = new ChungnamVO();
		vo.setMng_no(Integer.parseInt(request.getParameter("mng_no")));
		
		int result = dao.chungnamDelete(vo);
		
		if(result == 1) {
			response.sendRedirect("/servletExample/select");
		} else {
			
		}
	}

}
