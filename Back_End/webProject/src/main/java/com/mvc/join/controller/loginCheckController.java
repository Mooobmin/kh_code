package com.mvc.join.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.join.service.JoinService;

public class loginCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null; 
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		JoinService service = JoinService.getInstance();
		
		int result = service.loginCheck(id, passwd);
		
		if(result == 1) {
			System.out.println("여기까지 들어오는거니?");
			request.setAttribute("id", id);
			request.setAttribute("passwd", passwd);
			path = "/board/getBoardList.do";
		} else if(result == 0){
			path = "join/loginPage";
			//request.setAttribute("errorMsg", "아이디가 틀렸습니다.");
		} else if(result == -1){
			path = "join/loginPage";
			//request.setAttribute("errorMsg", "아이디가 틀렸습니다.");
		}
		
		return path;
	}

}
