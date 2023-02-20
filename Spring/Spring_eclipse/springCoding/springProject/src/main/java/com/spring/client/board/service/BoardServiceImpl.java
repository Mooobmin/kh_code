package com.spring.client.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.board.dao.BoardDao;
import com.spring.client.board.vo.BoardVO;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardDao boardDAO;
	
	//글 목록 구현
	@Override
	public List<BoardVO> boardList(int no){
		List<BoardVO> boardList = boardDAO.getBoardList(no);
		return boardList;
	}
	
	//글 입력 구현
	@Override
	public int boardInsert(BoardVO board) {
		int result = 0;
		result = boardDAO.boardInsert(board);
		
		return result;
	}
	
	//글 상세보기 구현
	@Override
	public BoardVO boardDetail(BoardVO bvo) {
		BoardVO detail = null;
		
		detail = boardDAO.boardDetail(bvo);
		if(detail != null) {
			detail.setB_content(detail.getB_content().toString().replaceAll("\n", "<br />"));
		}
		return detail;
	}
	
	//글 수정
	@Override
	public BoardVO updateForm(BoardVO board) {
		BoardVO updateData = null;
		updateData = boardDAO.boardDetail(board);
		return updateData;
	}
	
	//글 수정 구현
	@Override
	public int boardUpdate(BoardVO board) {
		int result = 0;
		result = boardDAO.boardUpdate(board);
		return result;
	}
}
