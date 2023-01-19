package com.jdbc;

import java.util.ArrayList;

import com.board.Board;
import com.board.BoardDao;

public class BoardService {
	private static BoardService instance = null;
	
	private BoardService() {}
	
	public static BoardService getInstance() {
		if(instance == null) {
			instance = new BoardService();
		}
		return instance;
	}
	
	public ArrayList<Board> boardList(Board bo){
		ArrayList<Board> list = new BoardDao().getBoardTotal(bo);
		return list;
	}
	
	public boolean boardInsert(Board bo) {
		boolean result = new BoardDao().boardInsert(bo);
		return result;
	}
}
