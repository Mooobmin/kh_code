package com.mvc.join.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;
import com.mvc.join.service.JoinService;
import com.mvc.join.vo.JoinVO;

public class loginCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null; 
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		JoinService joinservice = JoinService.getInstance();
		BoardService boardservice = BoardService.getInstance();
		int result = joinservice.loginCheck(id, passwd);
		
		
		ArrayList<BoardVO> list = boardservice.boardList();
		System.out.println(result);
		
		if(result == 1) {
			//System.out.println("여기까지 들어오는거니?");
			JoinVO data = joinservice.joinMyPage(id);
			System.out.println(result);
			request.setAttribute("mypage", data);
			request.setAttribute("list", list);
			return "/join/getMainPage";
			//path = "/join/getMyPage.do";
		} else if(result == 0){
			path = "/join/loginPage";
			request.setAttribute("errorMsg", "아이디 혹은 비밀번호가 틀렸습니다.");
		} else if(result == -1){
			path = "/join/loginPage";
			request.setAttribute("errorMsg", "아이디 혹은 비밀번호가 틀렸습니다.");
		}
		
		return path;
	}

}
