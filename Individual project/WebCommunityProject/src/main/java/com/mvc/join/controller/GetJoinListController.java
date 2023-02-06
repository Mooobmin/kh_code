package com.mvc.join.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.join.service.JoinService;
import com.mvc.join.vo.JoinVO;

public class GetJoinListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		JoinService service = JoinService.getInstance();
		ArrayList<JoinVO> list = service.joinList();
		
		request.setAttribute("list", list);
		
		return "/join/getJoinList";
	}

}
