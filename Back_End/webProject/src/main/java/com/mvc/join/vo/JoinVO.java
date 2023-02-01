package com.mvc.join.vo;

public class JoinVO {
	private String id;
	private String passwd;
	private String name;
	private String gender;
	private String tel;
	private String regdate;
	
	public JoinVO() { }
	public JoinVO(String id, String passwd, String name, String gender, String tel, String regdate) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.gender = gender;
		this.tel = tel;
		this.regdate = regdate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "JoinVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", gender=" + gender + ", tel=" + tel
				+ ", regdate=" + regdate + "]";
	}
	
	
}
