package com.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.common.JDBCTemplate.*;

public class SubjectDAO {
	
	/****************************************************************************
	 * getSubjectTotal(SubjectDAO vo) 메서드 : 학과 테이블에서 모든 레코드를 반환하는 메서드
	 * 검색시 검색값을 vo로 전달받음.
	 * @return ArrayList<SubjectVO> 자료형 리턴.
	 ***************************************************************************/
	public ArrayList<SubjectVO> getSubjectTotal(SubjectVO vo){
		StringBuffer sql = new StringBuffer();
		sql.append("select no, s_num, s_name from subject ");
		if(vo != null) {
			sql.append("where s_name like ?");
		}
		sql.append("order by no");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO svo = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			if(vo != null) {
				pstmt.setString(1,  "%" + vo.getS_name() + "%");
			}
			rs = pstmt.executeQuery();
			
			//ResultSet의 결과에서 모든 행을 각각의 SubjectVO 객체에 저장
			while(rs.next()) {
				//한 행의 학과 정보를 저장할 VO 객체 생성
				svo = new SubjectVO();
				//한 행의 학과 정보를 VO객체에 저장
				svo.setNo(rs.getInt("no"));
				svo.setS_num(rs.getString("s_num"));
				svo.setS_name(rs.getString("s_name"));
				
				//ArrayList 객체에 원소로 추가
				list.add(svo);
			}
		} catch(SQLException se) {
			System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해 주세요.");
			se.printStackTrace();
		} catch(Exception e) {
			System.out.println("error = [" + e + "]");
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return list;
	}
	
	
	/****************************************************************************
	 * getSubjectNum() 메서드 : 학과번호 자동 구하기.
	 * @return String 자료형 리턴.
	 ***************************************************************************/	
	
	public String getSubjectNum() {
		StringBuffer sql = new StringBuffer();
		sql.append("select nvl(lpad(max(to_number(LTRIM(s_num, '0')))+1,2,'0'),'01) ");
		sql.append("as subjectNum from subject");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String subjectNumber = "";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				subjectNumber = rs.getString("subjectNum");
			}
		} catch(SQLException se) {
			System.out.println("쿼리 getSubjectNum error = [ " + se + " ] ");
			se.printStackTrace();
		} catch(Exception e) {
			System.out.println("error = [ " + e + " ]");
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return subjectNumber;
	}
	
	/****************************************************************************
	 * subjectInsert(SubjectVo svo) 메서드 : 학과 테이블에 데이터 입력.
	 * @return boolean 자료형 리턴.
	 ***************************************************************************/
	
	public boolean subjectInsert(SubjectVO svo) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into subject(no, s_num, s_name) ");
		sql.append("values(subject_seq.nextval, ?, ?)");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, svo.getS_num()); // 첫번째 ?(바인딩변수) 설정값 - 학과번호
			pstmt.setString(2, svo.getS_name()); // 두번째 ?(바인딩변수) 설정값 - 학과명
			
			int i = pstmt.executeUpdate(); //쿼리문 실행 - 결과값은 입력된 행의 수 반환
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
