package com.spring.client.board.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.client.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardDao boardDao;
	
/*	@Test
	public void testBoardInsert() {
		BoardVO board = new BoardVO();
		board.setB_name("김철수");
		board.setB_title("용기가 필요해?");
		board.setB_content("포기하지마");
		board.setB_pwd("1234");
		
		int count = boardDao.boardInsert(board);
		log.info("입력된 행의 수 : " + count);
	}
*/	
	@Test
	public void testBoardDetail() {
		BoardVO bvo = new BoardVO();
		bvo.setB_num(1);
		BoardVO board = boardDao.boardDetail(bvo);
		
		log.info(board.toString());
	}
}
