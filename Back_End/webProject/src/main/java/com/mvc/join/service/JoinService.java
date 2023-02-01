package com.mvc.join.service;

import java.util.ArrayList;

import com.mvc.join.dao.JoinDAO;
import com.mvc.join.vo.JoinVO;

public class JoinService {
	private static JoinService service = null;
	
	private JoinDAO dao = JoinDAO.getInstance();
	
	private JoinService() {}
	public static JoinService getInstance() {
		if(service == null) {
			service = new JoinService();
		}
		return service;
	}
	
	public ArrayList<JoinVO> joinList() {
		ArrayList<JoinVO> list = dao.joinList();
		return list;
	}
	
	public JoinVO joinMyPage(String id) {
		JoinVO vo = dao.joinMyPage(id);
		return vo;
	}
	
	public boolean insertJoin(JoinVO vo) {
	      boolean result = dao.JoinInsert(vo);
	      return result;
	   }
	
	public int loginCheck(String id, String name) {
		return dao.loginCheck(id, name);
	}
	
	 public void joinDelete(String id) {
	       dao.joinDelete(id);
	    }
	    
	    public int joinPasswdChk(String id, String passwd) {
	       int result = dao.joinPasswdChk(id, passwd);
	       return result;
	    }
	    public JoinVO updateJoinForm(String id) {
	        JoinVO vo = dao.joinMyPage(id);
	        return vo;
	     }
	     public boolean JoinUpdate(JoinVO vo) {
	        boolean result = dao.joinUpdate(vo);
	        return result;
	     }	    
	
}
