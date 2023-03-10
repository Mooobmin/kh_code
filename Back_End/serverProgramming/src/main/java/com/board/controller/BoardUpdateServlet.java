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

@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 원글 등록 처리용 컨트롤러
		request.setCharacterEncoding("UTF-8");
		
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		board.setBoardWriter(request.getParameter("boardWriter"));
		board.setBoardTitle(request.getParameter("boardTitle"));
		board.setBoardContent(request.getParameter("boardContent"));
		
		BoardService boardService = BoardService.getInstance();
		if(boardService.updateBoard(board) > 0) {
			//response.sendRedirect("/serverProgramming/boardList");
			response.sendRedirect(request.getContextPath() + "/boardList");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/common/error.jsp");
			request.setAttribute("message", "게시글 수정 실패");
			dispatcher.forward(request, response);
		}
	}

}
