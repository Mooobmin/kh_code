package com.spring.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.domain.SubjectVO;
import com.spring.mapper.ExampleMapper;

import lombok.Setter;

//인스턴스 생성을 위한 Service 어노테이션 1순위로 추가
@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Setter(onMethod_ = @Autowired)
	private ExampleMapper exmapleMapper;

	@Override
	public List<SubjectVO> subjectList(int no) {
		List<SubjectVO> subjectList = exmapleMapper.getSubjectList(no);
		return subjectList;
	}

	@Override
	public int subjectInsert(SubjectVO subject) {
		//DAO == Mapper
		int result = exmapleMapper.subjectInsert(subject);

		return result;
	}
	
	

}