package com.mvc.join.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.join.service.JoinService;
import com.mvc.join.vo.JoinVO;

public class InsertJoinController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      String path = null;
      
      JoinVO vo = new JoinVO();
      vo.setId(request.getParameter("id"));
      vo.setPasswd(request.getParameter("passwd"));
      vo.setName(request.getParameter("name"));
      vo.setGender(request.getParameter("gender"));
      vo.setTel(request.getParameter("tel"));
      
      JoinService joinService = JoinService.getInstance();
      boolean result = joinService.insertJoin(vo);
      
      if(result) {
         path =  "/join/loginPage";
         request.setAttribute("joinMsg", "가입이 완료되었습니다. 로그인 해주세요");
      }
      
      return path;
   }

}