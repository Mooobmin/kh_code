package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.board.vo.Board;

import static com.board.common.JDBCTemplate.*;

public class BoardDao {
	
	
		/**
		 * BoardDao.java 크래스의 insertBoard(conn, board)
		 * 메소드를 PreparedStatment로 새 게시글 등록 처리가 되도록 구현하시오.
		 */
	public int insertBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		StringBuffer query = new StringBuffer();
		query.append("insert into board(boardnum, boardwriter, boardtitle, boardcontent) ");
		query.append("values((select decode(max(boardnum), null, 0, max(boardnum)) + 1 from board),?, ?, ?)");
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, board.getBoardWriter());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	} //입력쿼리 완료
	

}
