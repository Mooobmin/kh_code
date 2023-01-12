package com.chungnam;

public class ChungnamVO {
	private int mng_no;
	private String local_nm;
	private String type;
	private String nm;
	private String nm_sub;
	private String addr;
	private double lat;
	private double lng;
	private String description;
	private String list_img;
	private String regDate;
	public int getMng_no() {
		return mng_no;
	}
	public void setMng_no(int mng_no) {
		this.mng_no = mng_no;
	}
	public String getLocal_nm() {
		return local_nm;
	}
	public void setLocal_nm(String local_nm) {
		this.local_nm = local_nm;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getNm_sub() {
		return nm_sub;
	}
	public void setNm_sub(String nm_sub) {
		this.nm_sub = nm_sub;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getList_img() {
		return list_img;
	}
	public void setList_img(String list_img) {
		this.list_img = list_img;
	}
	@Override
	public String toString() {
		return "ChungnamVO [mng_no=" + mng_no + ", local_nm=" + local_nm + ", type=" + type + ", nm=" + nm + ", nm_sub="
				+ nm_sub + ", addr=" + addr + ", lat=" + lat + ", lng=" + lng + ", description=" + description
				+ ", list_img=" + list_img + ", regDate=" + regDate + "]";
	}

	
}
