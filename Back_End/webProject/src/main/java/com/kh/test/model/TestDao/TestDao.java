package com.kh.test.model.TestDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDao {

	public int login(String id, String pw, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select nvl((select 1 from LOGIN_TB where id = ? ");
			sql.append("and pw = ?), 0) as result from dual");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			result = rs.getInt("result");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
