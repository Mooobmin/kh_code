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
	
	@Test
	public void testSubjectList() {
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
	}
}
