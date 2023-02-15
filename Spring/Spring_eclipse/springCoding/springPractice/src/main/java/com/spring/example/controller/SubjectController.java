package com.spring.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.example.domain.SubjectVO;
import com.spring.example.service.SubjectService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//컨트롤러 생성 후, Controller 어노테이션 선언 1순위
@Controller
@RequestMapping("/subject/*")
@Log4j
public class SubjectController {
	
	@Setter(onMethod_ = @Autowired)
	private SubjectService subjectService;
	
	@RequestMapping(value="/subjectList", method=RequestMethod.GET)
	public String subjectList(Model model) {
		log.info("subjectList() 메서드 호출.....");
		
		int no = 0;
		List<SubjectVO> subjectList = subjectService.subjectList(no);
		model.addAttribute("subjectList", subjectList);
		
		return "subject/subjectList"; // /WEB-INF/views/subject/subjectList.jsp
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		log.info("insertForm() 메서드 호출.....");	
		
		return "subject/insertForm"; // /WEB-INF/views/subject/insertForm.jsp
	}
	
	@GetMapping("/subjectInsert")
	public String subjectInsert(SubjectVO subject) {
		log.info("subjectInsert 메서드 호출.....");
		
		/*같은 페이지에 존재하지 않았다면 아래와 같이 코딩
		int result = 0;
		String path = "";
		
		result = subjectService.subjectInsert(subject);
		if(result == 1) {
			path="/subject/subjectList";
		} else {
			path="/subject/unsertForm";
		}
		//"redirect:"+path 절대 공백 주지말것.
		return "redirect:"+path; */
		
		subjectService.subjectInsert(subject);
		return "redirect:/subject/subjectList";
		
	}
	
}
