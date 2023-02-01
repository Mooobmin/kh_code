package com.mvc.join.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.join.service.JoinService;

public class DeleteJoinController implements Controller {

	   @Override
	   public String execute(HttpServletRequest request, HttpServletResponse response) {
	      String id = request.getParameter("id");
	      
	      JoinService service = JoinService.getInstance();
	      service.joinDelete(id);
	      
	      return "/join/loginPage.do";
	   }

	}