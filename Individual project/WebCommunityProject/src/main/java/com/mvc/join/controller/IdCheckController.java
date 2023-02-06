package com.mvc.join.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.join.service.JoinService;

public class IdCheckController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      String id = request.getParameter("id");
      
      JoinService service = JoinService.getInstance();
      int result = service.idCheck(id);
      
      request.setAttribute("resultData", result);
      
      return "/common/resultData";
   }

}