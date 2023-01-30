package com.mvc.common.controller;

public class ViewResolver {
	public String prefix; //공동 경로(폴더)를 명시
	public String suffix; //확장자 명시
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) { //view = /board/getBoardList이면 prefix = /WEB-INF, suffix = .jsp
		return prefix + viewName + suffix;	 //WEB-INF/board/getBoardList.jsp를 반환
	}
	
}
