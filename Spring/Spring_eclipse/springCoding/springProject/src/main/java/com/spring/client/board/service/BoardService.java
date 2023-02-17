package com.spring.client.board.service;

import java.util.List;

import com.spring.client.board.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> boardList(int no);
	
	public int boardInsert(BoardVO board);
	
	public BoardVO boardDetail(BoardVO board);
}
