package com.spring.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.example.domain.SubjectVO;
import com.spring.mapper.ExampleMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
/*자동으로 만들어줄 어플리캐이션 컨텍스트의 설정파일의 위치를 지정할 때 사용한다.*/
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ExampleMapperTests {
	@Setter(onMethod_ = @Autowired)
	private ExampleMapper exampleMapper;
	
	/*@Test
	public void getSubjectList() {
		log.info("--------------------------------");
		log.info("getSubjectList() 메서드 실행");
		List<SubjectVO> list = exampleMapper.getSubjectList(5);
		for(SubjectVO vo : list) {
			log.info(vo);
		}
		log.info("--------------------------------");
		log.info("getSubjectList() 메서드 실행");
		list = exampleMapper.getSubjectList(0);
		for(SubjectVO vo : list) {
			log.info(vo);
		}		
	}*/
	
	/*@Test
	public void testSubjectInsert() {
		log.info("--------------------------------");
		log.info("getSubjectInsert() 메서드 실행");
		SubjectVO svo = new SubjectVO();				
		svo.setS_num("10");								
		svo.setS_name("경제학과");
		log.info(exampleMapper.subjectInsert(svo));
		
	}*/
	
	/*@Test
	public void testSubjectUpdate() {
		log.info("--------------------------------");
		log.info("SubjectUpdate() 메서드 실행");
		SubjectVO subvo = new SubjectVO();
		subvo.setS_name("인터넷비즈니스과");
		subvo.setNo(4);
		log.info(exampleMapper.subjectUpdate(subvo));
	}*/
	
	/*@Test
	public void testsubjectDelete() {
		log.info("--------------------------------");
		log.info("SubjectDelete() 메서드 실행");
		SubjectVO subvo = new SubjectVO();
		subvo.setNo(16);
		log.info(exampleMapper.subjectDelete(subvo));			
	}*/
	
	@Test
	public void testgetSubjectName() {
		log.info("--------------------------------");
		log.info("getSubjectName() 메서드 실행");	
		
		exampleMapper.getSubjectName("01");
		log.info(exampleMapper.getSubjectName("01"));
	}
	
}
