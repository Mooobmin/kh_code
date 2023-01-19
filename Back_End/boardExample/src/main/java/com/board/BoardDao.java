package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.common.JDBCTemplate.*;
public class BoardDao {
	
	/*********************************************
	 * board테이블에서 모든 레코드 반환 메서드
	 * 검색 시 검색값을 vo로 전달 받음
	 *********************************************/
	public ArrayList<Board> getBoardTotal(Board bo){
		StringBuffer sql = new StringBuffer();
		sql.append("select boardnum, boardwriter, boardtitle, boardcontent, boarddate from board ");
		
		if(bo != null) {
			sql.append("where boardtitle list ?");
		}
		sql.append("order by boardnum");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board bbo = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			if(bo != null) {
				pstmt.setString(1, "%" + bo.getBoardTitle() + "%");
			}
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) {
				bbo = new Board();
				
				bbo.setBoardNum(rs.getInt("boardNum"));
				bbo.setBoardWriter(rs.getString("boardWriter"));
				bbo.setBoardWriter(rs.getString("boardTitle"));
				bbo.setBoardWriter(rs.getString("boardContent"));
				bbo.setBoardWriter(rs.getString("boardDate"));
				
				list.add(bbo);
			}
		} catch(SQLException se) {
			System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해 주세요.");
			se.printStackTrace();
		} catch(Exception e) {
			System.out.println("error = [ " + e + " ]");
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return list;
	}
	
	public boolean boardInsert(Board bbo) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into board(boardnum, boardwriter, boardtitle, boardcontent, boarddate) ");
		sql.append("values((select nvl(max(boardnum),0) +1 from board), ?, ?, ?, sysdate)");
		
		//SELECT NVL(MAX(증가컬럼)+1,0) FROM 테이블)
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, bbo.getBoardWriter());
			pstmt.setString(2, bbo.getBoardTitle());
			pstmt.setString(3, bbo.getBoardContent());
			
			int i = pstmt.executeUpdate();
			if(i == 1) {
				success = true;
				commit(con);
			}
		} catch(SQLException se) {
			System.out.println("입력에 문제가 있어 잠시 후에 다시 진행해 주세요.");
			rollback(con);
			se.printStackTrace();
		} catch(Exception e) {
			System.out.println("error = [ " + e + " ]");
			rollback(con);
		} finally {
			close(pstmt);
			close(con);
		}
		return success;
	}
}
