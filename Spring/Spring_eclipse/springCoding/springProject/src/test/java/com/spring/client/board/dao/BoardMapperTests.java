package com.spring.client.board.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.client.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
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
/*	@Test
	public void testBoardDetail() {
		BoardVO bvo = new BoardVO();
		bvo.setB_num(1);
		BoardVO board = boardDao.boardDetail(bvo);
		
		log.info(board.toString());
	}*/
	
	@Test
	public void testBoardUpdate() {
		BoardVO board = new BoardVO();
		board.setB_title("용기가 필요할 때 수정하겠지~~~");
		board.setB_content("당신이 할 수 있다고 믿든, 할 수 없다고 믿든, 믿는대로 될거다~~~~");
		board.setB_pwd("4321");
		board.setB_num(1);
		
		int count = boardDao.boardUpdate(board);
		log.info("수정된 행의 수 : " + count);
	}
}
