package com.mvc.join.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.join.service.JoinService;
import com.mvc.join.vo.JoinVO;

public class GetMyPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		JoinService service = JoinService.getInstance();
		
		JoinVO data = service.joinMyPage(id);
		request.setAttribute("mypage", data);
		return "/join/getMyPage";
	}

}
