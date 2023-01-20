package com.board.service;


import static com.board.common.JDBCTemplate.*;

import java.sql.Connection;

import com.board.dao.BoardDao;
import com.board.vo.Board;
/*
 * 공통모듈인 JDBCTemplate.java 의 getConnect()을 사용하여 Connection을 생성하고,
 * BoardDao 클래스의 insertBoard()로 Connection과 전달받은 Board객체 정보를 전달하고 나서
 * 처리결과를 리턴받아 트랜잭션을 처리하고 Connection을 close하고 받은 결과를 컨트롤러로 리턴한다.
 */
public class BoardService {
	private static BoardService instance = null;
	
	private BoardService() {}
	
	public static BoardService getInstance() {
		if(instance == null) {
			instance = new BoardService();
		}
		return instance;
	}
	
	public int insertBoard(Board board) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertBoard(conn, board);
	
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
