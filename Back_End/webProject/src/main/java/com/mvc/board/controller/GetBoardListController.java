package com.mvc.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class GetBoardListController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardService service = BoardService.getInstance();
		//검색 부분 제외하고 게시판 리스트 보여주기 위한 요청
		ArrayList<BoardVO> list = service.boardList();
		
		request.setAttribute("list", list);
		//jsp 페이지에서 사용방법은 ${list} : 반환형이 ArrayList이기 때문에, 반복문사용(JSTL의 forEach)
		return "/board/getBoardList";
	}

}
