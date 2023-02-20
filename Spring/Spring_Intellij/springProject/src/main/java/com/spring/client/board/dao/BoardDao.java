package com.spring.client.board.dao;

import java.util.List;

import com.spring.client.board.vo.BoardVO;

public interface BoardDao {
	//리스트 표현 메서드
	public List<BoardVO> getBoardList(int no);
	
	//게시물 작성 메서드
	public int boardInsert(BoardVO board);
	
	//게시물 상세 페이지
	public BoardVO boardDetail(BoardVO board);
	
	//글 수정 페이지
	public int boardUpdate(BoardVO board);

	//글 삭제 페이지
	public int boardDelete(int board);

	//본인 글 확인
	public int pwdConfirm(BoardVO board);
}
