package com.spring.mapper;

import java.util.List;

import com.spring.example.domain.SubjectVO;

public interface ExampleMapper {
	
	public List<SubjectVO> getSubjectList(int no);
	
	//정보를 입력하기 위한 메서드 생성, SubjectVO를 매개변수로 지정하고, 반환형은 int
	public int subjectInsert(SubjectVO subject);
	
	public int subjectUpdate(SubjectVO subject);
	
	public int subjectDelete(SubjectVO subject);
	
	public String getSubjectName(String s_num); /*학과번호를 인자로 학과명을 출력*/

}
