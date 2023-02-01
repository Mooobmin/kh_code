package com.mvc.join.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.join.service.JoinService;
import com.mvc.join.vo.JoinVO;

public class UpdateJoinFormController implements Controller {

	   @Override
	   public String execute(HttpServletRequest request, HttpServletResponse response) {
	        String id = request.getParameter("id");
	        String code = request.getParameter("code");
	        
	        JoinService service = JoinService.getInstance(); 
	        JoinVO data =service.updateJoinForm(id);
	        
	        
	         
	        request.setAttribute("updateData", data);
	        
	        
	        if(code!=null && code.equals("1")){
	           request.setAttribute("errorMsg","수정완료에 문제가 있어 잠시 후 다시 입력해 주세요."); }
	        return "/join/updateJoinForm";
	   }

	}
