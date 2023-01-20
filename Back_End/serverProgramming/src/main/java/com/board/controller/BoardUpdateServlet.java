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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		

		BoardService boardService = BoardService.getInstance();
		Board board = boardService.boardSelect(boardNum);
		
		RequestDispatcher dispatcher = null;
		String url = "";
		
		if(board != null) {
			url = "/board/updateForm.jsp";
		} else {
			request.setAttribute("msg", "게시글 수정 실패");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
		
	}

}
