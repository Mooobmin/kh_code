package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.board.vo.Board;

import static com.board.common.JDBCTemplate.*;

public class BoardDao {
	
	
	public ArrayList<Board> boardList(){
		Connection con = null;
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Board board = null;
		
		StringBuffer query = new StringBuffer();
		query.append("select boardnum, boardwriter, boardtitle, boarddate from board ");
		query.append("order by boardnum desc");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setBoardNum(rs.getInt("boardnum"));
				board.setBoardWriter(rs.getString("boardwriter"));
				board.setBoardTitle(rs.getString("boardtitle"));
				board.setBoardDate(rs.getString("boarddate"));
				
				list.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);	
		}
		return list;
	} //리스트 쿼리 완료
	
	
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
	
	public Board boardSelect(int boardNum) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Board board = null;
		
		StringBuffer query = new StringBuffer();
		query.append("select boardnum, boardwriter, boardtitle, boardcontent, boarddate from board ");
		query.append("where boardnum = ? order by boardnum desc");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new Board();
				board.setBoardNum(rs.getInt("boardnum"));
				board.setBoardWriter(rs.getString("boardwriter"));
				board.setBoardTitle(rs.getString("boardtitle"));
				board.setBoardContent(rs.getString("boardcontent"));
				board.setBoardDate(rs.getString("boarddate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return board;
	}
	
	public int updateBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		StringBuffer query = new StringBuffer();
		query.append("update board set boardwriter = ?, boardtitle = ?, boardcontent = ? ");
		query.append("where boardnum = ?");
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, board.getBoardWriter());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setInt(4, board.getBoardNum());
			
			result = pstmt.executeUpdate();
			if(result == 1) {
				commit(conn);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}

}
