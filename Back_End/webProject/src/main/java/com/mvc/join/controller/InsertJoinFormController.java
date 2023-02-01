package com.mvc.join.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;

public class InsertJoinFormController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      return "/join/insertJoinForm";
   }
}