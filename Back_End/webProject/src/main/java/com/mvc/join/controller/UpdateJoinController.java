package com.mvc.join.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.join.service.JoinService;
import com.mvc.join.vo.JoinVO;

public class UpdateJoinController implements Controller {
	  
@Override public String execute(HttpServletRequest request,HttpServletResponse response) {
   String path = null;



      JoinVO vo = new JoinVO();

      vo.setId(request.getParameter("id"));
      vo.setPasswd(request.getParameter("passwd"));
      vo.setTel(request.getParameter("tel"));


      JoinService service = JoinService.getInstance();
      boolean result =service.JoinUpdate(vo);
      if(result) {
         path ="/join/getMyPage.do?id="+vo.getId();
         }else {
         path = "/join/updateJoinform.do?id="+vo.getId()+"&code=1";
         }
      return path;
      }


}
