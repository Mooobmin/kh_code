package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.BoardService;
import com.board.vo.Board;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/boardInsert")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게세글 원글 등록 처리용 컨트롤러
		request.setCharacterEncoding("UTF-8");
		
		Board board = new Board();
		board.setBoardWriter(request.getParameter("boardWriter"));
		board.setBoardTitle(request.getParameter("boardTitle"));
		board.setBoardContent(request.getParameter("boardContent"));
		
		BoardService boardService = BoardService.getInstance();
		if(boardService.insertBoard(board) > 0) {
			//response.sendRedirect("/serverProgramming/boardList");
			response.sendRedirect(request.getContextPath() + "/boardList");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/common/error.jsp");
			request.setAttribute("message", "게시글 등록 실패");
			dispatcher.forward(request, response);
		}

	}

}
