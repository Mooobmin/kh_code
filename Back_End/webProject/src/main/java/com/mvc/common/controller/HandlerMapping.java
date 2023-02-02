package com.mvc.common.controller;

import java.util.HashMap;
import java.util.Map;

import com.mvc.board.controller.DeleteBoardController;
import com.mvc.board.controller.DetailBoardController;
import com.mvc.board.controller.GetBoardListController;
import com.mvc.board.controller.InsertBoardController;
import com.mvc.board.controller.InsertFormController;
import com.mvc.board.controller.PasswdCheckController;
import com.mvc.board.controller.UpdateBoardController;
import com.mvc.board.controller.UpdateFormController;
import com.mvc.join.controller.DeleteJoinController;
import com.mvc.join.controller.GetJoinListController;
import com.mvc.join.controller.GetMyPageController;
import com.mvc.join.controller.IdCheckController;
import com.mvc.join.controller.InsertJoinController;
import com.mvc.join.controller.InsertJoinFormController;
import com.mvc.join.controller.UpdateJoinController;
import com.mvc.join.controller.UpdateJoinFormController;
import com.mvc.join.controller.loginCheckController;
import com.mvc.join.controller.loginPageController;


public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		/* 답변형 게시판 처리*/
		mappings.put("/board/getBoardList.do", new GetBoardListController());
		mappings.put("/board/insertForm.do", new InsertFormController());
		mappings.put("/board/insertBoard.do", new InsertBoardController());
		mappings.put("/board/detailBoard.do", new DetailBoardController());
		mappings.put("/board/updateForm.do", new UpdateFormController());
		mappings.put("/board/updateBoard.do", new UpdateBoardController());
		mappings.put("/board/deleteBoard.do", new DeleteBoardController());
		mappings.put("/board/passwdCheck.do", new PasswdCheckController());
		
		
		/*로그인 핸들러*/
		mappings.put("/join/loginPage.do", new loginPageController());
		mappings.put("/join/loginBoard.do", new loginCheckController());
		
		/* 회원가입 핸들러 */
		mappings.put("/join/insertJoinForm.do", new InsertJoinFormController());
	    mappings.put("/join/insertJoin.do", new InsertJoinController());
	    mappings.put("/join/idCheck.do", new IdCheckController());
	    
	    /* 회원 수정 핸들러 */
	    mappings.put("/join/updateJoinForm.do", new UpdateJoinFormController());
	    mappings.put("/join/updateJoin.do", new UpdateJoinController());
	    
	    /* 회원 탈퇴 핸들러*/
	    mappings.put("/join/deleteJoin.do", new DeleteJoinController());  
	    mappings.put("/join/passwdCheck.do", new com.mvc.join.controller.PasswdCheckController());
	    /* 관리자 페이지 핸들러*/
		mappings.put("/join/getJoinList.do", new GetJoinListController());
		mappings.put("/join/getMyPage.do", new GetMyPageController());
	}
	
	public Controller getController(String path) {	//게시판리스트일 경우 path="/board/getBoardList.d
		return mappings.get(path);					//mappings.get("/board/getBoardList.do")
	}												// -> new GetBoardListController()의 주솟값 반환
}
