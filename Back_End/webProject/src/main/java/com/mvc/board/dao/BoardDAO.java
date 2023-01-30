package com.mvc.board.dao;

import static com.mvc.common.util.JDBCTemplate.*; //정적 메소드 임포트

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mvc.board.vo.BoardVO;

public class BoardDAO {
	private static BoardDAO instance = null;
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	} //싱글톤 방식
	
	private BoardDAO() {}
	
	/***************************************************************
	 * boardList() 메서드 : 게시판 목록 조회(검색 처리 제외)
	 * @return ArrayList<BoardVO> 리턴.
	 ***************************************************************/
	public ArrayList<BoardVO> boardList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO> ();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			StringBuffer query = new StringBuffer();
			query.append("select num, author, title, ");
			query.append("to_char(writeday, 'YYYY/MM/DD') writeday, ");
			query.append("readcnt, repRoot, repStep, repIndent from board ");
			query.append(" order by repRoot desc, repStep asc");
			
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO data = new BoardVO();
				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setWriteday(rs.getString("writeday"));
				data.setReadcnt(rs.getInt("readcnt"));
				data.setRepRoot(rs.getInt("repRoot"));
				data.setRepStep(rs.getInt("repStep"));
				data.setRepIndent(rs.getInt("repIndent"));
				
				list.add(data);
			} // end while
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return list;
 	} //end select
	
	/***************************************************************
	 * boardInsert() 메서드 : 게시물 등록
	 * @return boolean. 
	 ***************************************************************/
	public boolean boardInsert(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			StringBuffer query = new StringBuffer();
			query.append("insert into board(num, author, title, content, reproot, repstep, repindent, passwd) ");
			query.append("values(board_seq.nextval, ?, ?, ?, board_seq.currval, 0,0, ? )");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getAuthor());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPasswd());
			int value = pstmt.executeUpdate();
			
			if(value == 1) result = true;
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(conn);
			}
		return result;
	}
	/***************************************************************
	 * readCount() 메서드 : 조회수 증가 처리 메서드.
	 * @param 게시물 번호.
	 ***************************************************************/
	public void readCount(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			StringBuffer query = new StringBuffer();
			query.append("update board set readcnt = readcnt + 1 ");
			query.append("where num = ?");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
	
	/***************************************************************
	 * boardDelete() 메서드 : 게시물 삭제 처리 메서드.
	 * @param 게시물 번호, 비밀번호
	 ***************************************************************/
	
	/***************************************************************
	 * boardUpdate() 메서드 : 게시물 수정 처리 메서드.
	 * @param BoardVO
	 * @return boolean. 
	 ***************************************************************/
}
