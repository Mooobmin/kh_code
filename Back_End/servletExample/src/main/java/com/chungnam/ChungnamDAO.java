package com.chungnam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChungnamDAO {
	private static final String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521/xepdb1";
	private static final String USER = "javauser";
	private static final String PASSWD = "java1234";
	
	//클래스 자신의 타입으로 정적 필드 선언
	private static ChungnamDAO instance = null;

	//외부에서 호출할 수 있는 정적 메소드인 getInstance() 선언하여 인스턴스 반환
	public static ChungnamDAO getInstance() {
		if(instance == null) {
			instance = new ChungnamDAO();
		}
		return instance;
	}
	
	//외부에서 new 연산자로 생성자를 호출할 수 없도록 막기 위해 접근제한자(private)로 명시. private 생성자() {} 선언.
	private ChungnamDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");		
		} catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
		return con;
	}
	
	/******************************************
	 * getChungnamList() 메서드 : 충남 데이터 조회
	 * @return ArrayList<ChungnamVO> 리턴.
	 *****************************************/
	public ArrayList<ChungnamVO> getChungnamList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ChungnamVO> list = new ArrayList<ChungnamVO>();
		ChungnamVO vo = null;
				
		StringBuffer sql = new StringBuffer();
		sql.append("select mng_no, local_nm, type, nm, nm_sub, description, list_img from chungnam");
		sql.append(" order by mng_no desc");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//한 행의 정보를 저장할 VO 객체 생성.
				vo = new ChungnamVO();
				vo.setMng_no(rs.getInt("mng_no"));
				vo.setLocal_nm(rs.getString("local_nm"));
				vo.setType(rs.getString("type"));
				vo.setNm(rs.getString("nm"));
				vo.setNm_sub(rs.getString("nm_sub"));
				vo.setDescription(rs.getString("description"));
				vo.setList_img(rs.getString("list_img"));
				
				list.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/******************************************
	 * chungnamInsert() 메서드 : chungnam 테이블의 레코드 입력 메서드
	 * @param ChungnamVO
	 * @return int 자료형 리턴.
	 * 입력에 성공하면 ChungnamServlet로 보내준다.
	 * 실패하면 다시 입력해달라 하고, jsp화면으로 보내버린다.
	 * 성공 1, 실패 0
	 *****************************************/
	public int chungnamInsert(ChungnamVO vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into chungnam(mng_no, local_nm, type, nm, nm_sub, addr, lat, lng, description, list_img)");
		sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, vo.getMng_no());
			pstmt.setString(2, vo.getLocal_nm());
			pstmt.setString(3, vo.getType());
			pstmt.setString(4, vo.getNm());
			pstmt.setString(5, vo.getNm_sub());
			pstmt.setString(6, vo.getAddr());
			pstmt.setDouble(7, vo.getLat());
			pstmt.setDouble(8, vo.getLng());
			pstmt.setString(9, vo.getDescription());
			pstmt.setString(10, vo.getList_img());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/******************************************
	 * chungnamInsert() 메서드 : chungnam 테이블의 레코드 삭제 메서드
	 * @param ChungnamVO
	 * @return int 자료형 리턴.
	 * 성공 1, 실패 0
	 *****************************************/
	public int chungnamDelete(ChungnamVO vo) {
		return 0;
	}
}
