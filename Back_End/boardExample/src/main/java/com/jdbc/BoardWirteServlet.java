package com.jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.Board;

/**
 * Servlet implementation class BoardWirteServlet
 */
@WebServlet("/boardInsert")
public class BoardWirteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		Board bo = new Board();
		bo.setBoardWriter(request.getParameter("boardWriter"));
		bo.setBoardTitle(request.getParameter("boardTitle"));
		bo.setBoardContent(request.getParameter("boardContent"));
		
		BoardService boardService = BoardService.getInstance();
		boolean result = boardService.boardInsert(bo);
		
		if(result) {
			response.sendRedirect("/boardExample/boardList");
		} else {
			request.setAttribute("message", "게시글 등록 실패!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/common/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
