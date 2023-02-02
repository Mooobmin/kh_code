package com.mvc.join.dao;

import static com.mvc.common.util.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mvc.join.vo.JoinVO;

public class JoinDAO {
	private static JoinDAO instance = null;

	public static JoinDAO getInstance() {
		if (instance == null) {
			instance = new JoinDAO();
		}
		return instance;
	} // 싱글톤 방식

	private JoinDAO() {
	}
	/*관리자 페이지*/
	public ArrayList<JoinVO> joinList(){
		ArrayList<JoinVO> list = new ArrayList<JoinVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			StringBuffer query = new StringBuffer();
			query.append("select id, passwd, name, gender, tel, ");
			query.append("to_char(regdate, 'YYYY-MM-DD') regdate from jointable");
			
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JoinVO data = new JoinVO();
				data.setId(rs.getString("id"));
				data.setPasswd(rs.getString("passwd"));
				data.setName(rs.getString("name"));
				data.setGender(rs.getString("gender"));
				data.setTel(rs.getString("tel"));
				data.setRegdate(rs.getString("regdate"));
				
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return list;
	}
	
	/* 마이페이지 */
	public JoinVO joinMyPage(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JoinVO data = new JoinVO();
		
		try {
			conn = getConnection();
			StringBuffer query = new StringBuffer();
			query.append("select id, passwd, name, gender, tel, ");
			query.append("to_char(regdate,'YYYY-MM-DD HH24:MI:SS') regdate ");
			query.append(" from jointable where id = ? ");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data.setId(rs.getString("id"));
				data.setPasswd(rs.getString("passwd"));
				data.setName(rs.getString("name"));
				data.setGender(rs.getString("gender"));
				data.setTel(rs.getString("tel"));
				data.setRegdate(rs.getString("regdate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return data;
	}
	
	
	/*회원가입 기능*/
	public boolean JoinInsert(JoinVO vo) {
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      StringBuffer sql = new StringBuffer();
	      sql.append("INSERT INTO jointable( id, passwd, name, gender, tel ) ");
	      sql.append("VALUES(?, ?, ?, ?, ?)");
	      boolean result = false;
	      try {
	         con = getConnection();
	         pstmt = con.prepareStatement(sql.toString());
	         pstmt.setString(1, vo.getId());
	         pstmt.setString(2, vo.getPasswd());
	         pstmt.setString(3, vo.getName());
	         pstmt.setString(4, vo.getGender());
	         pstmt.setString(5, vo.getTel());
	         
	         if(pstmt.executeUpdate() == 1) result = true;
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	         close(con);
	      }
	      return result;
	   }
	
	/* 아이디 체크 */
	public int IdCheck(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        try {
           con = getConnection();
           StringBuffer sql = new StringBuffer();
           sql.append("SELECT NVL((SELECT 1 FROM jointable WHERE id = ?), 0) ");
           sql.append("AS result FROM dual");
           
           pstmt = con.prepareStatement(sql.toString());
           pstmt.setString(1, id);
           
           rs = pstmt.executeQuery();
           
           if(rs.next()) {
              result = rs.getInt("result");
           }
        }catch(Exception e) {
           e.printStackTrace();
        }finally {
           close(rs);
           close(pstmt);
           close(con);
        }
        return result;
     }
	
	/*로그인 기능*/
	public int loginCheck(String id, String passwd) {
    	System.out.println("dao는?");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
 
        String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
        int x = -1;
 
        try {
            
            StringBuffer query = new StringBuffer();
            query.append("SELECT PASSWD FROM jointable WHERE id = ? ");
 
            conn = getConnection();
            pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
 
            if (rs.next()) { 
                dbPW = rs.getString("passwd"); // 비번을 변수에 넣는다.
                if (dbPW.equals(passwd)) 
                    x = 1; 
                else                  
                    x = 0;
                
            } else {
                x = -1; 
            }
            
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
            close(conn);
        }
        return x;
    }
	
	/*회원 수정 기능*/
	public boolean joinUpdate(JoinVO vo) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean success = false;
	      try {
	         conn = getConnection();
	         StringBuffer query = new StringBuffer();
	         query.append("update jointable set passwd = ? , tel=? ");
	         query.append("where id = ?"); 
	         
	         pstmt= conn.prepareStatement(query.toString());
	         pstmt.setString(1, vo.getPasswd());
	         pstmt.setString(2, vo.getTel());
	         pstmt.setString(3, vo.getId());
	                  
	         int count = pstmt.executeUpdate();
	         if(count == 1) success = true;
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	         close(conn);
	      }
	      return success;
	   }
	
	/*회원 탈퇴 기능*/
	public void joinDelete(String id){
		Connection conn = null;
	    PreparedStatement pstmt = null;
	      
	    try {
	    	conn = getConnection();
	        StringBuffer query = new StringBuffer();
	        query.append("DELETE FROM jointable WHERE id = ?");
	         
	        pstmt = conn.prepareStatement(query.toString());
	        pstmt.setString(1, id);
	        pstmt.executeUpdate();
	        
	    } catch(Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	close(pstmt);
	        close(conn);
	      }
	   }
	
	public int joinPasswdChk(String id, String passwd) {
	      Connection conn = null;
	      ResultSet rs = null;
	      PreparedStatement pstmt = null;
	      int result = 0;
	      try {
	         conn = getConnection();
	         StringBuffer query = new StringBuffer();
	         query.append("select nvl((select 1 from jointable where id = ? ");
	         query.append("and passwd = ?), 0) as result from dual");
	         
	         pstmt = conn.prepareStatement(query.toString());
	         pstmt.setString(1, id);
	         pstmt.setString(2, passwd);
	         
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            result = rs.getInt("result"); // 비번일치 : 1 / 불일치 : 0 반환
	         }
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(rs);
	         close(pstmt);
	         close(conn);
	         
	      }
	      return result;
	   }
}
