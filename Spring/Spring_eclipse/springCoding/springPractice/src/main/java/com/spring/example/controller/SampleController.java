package com.spring.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.example.domain.SampleDTO;

import lombok.extern.log4j.Log4j;



@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping(value="/start", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("/sample/start get....................");
		//무조건 /sample/start -> /WEB-INF/views/sample.start.jsp
	}
	
	/*요청방법 : http://localhost:8080/sample/basic*/
	@RequestMapping(value ="/basic", method = RequestMethod.GET)
	public String basicGet1() {
		log.info("basic get.........................");
		return "basic"; // /WEB-INF/views/basic.jsp를 의미
	}
	
	@RequestMapping("/test")
	public String test() {
		return "sample/test"; // /WEB-INF/views/sample/test.jsp
	}	
	
	/*요청방법(form이 존재하지 않고 직접 요청시) : http://localhost:8080/sample/exam01?name=홍길동&age=25*/
	//@RequestMapping(val = "/exam01", method = RequestMethod.GET)
	@GetMapping("/exam01")
	public String exam01(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
		log.info("name : " + name);
		log.info("age : " + age);
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "exam01"; // /WEB-INF/views/main.jsp를 의미
	}
	/*요청방법 : http://localhost:8080/sample/exam02?name=홍길동&age=25*/
	@GetMapping("/exam02")
	public String exam02(@ModelAttribute SampleDTO sampleDTO/*, Model model*/) {
		log.info("" + sampleDTO);
		
		/*model.addAttribute("dto", dto);*/
		return "exam02"; // /WEB-INF/views/exam02.jsp를 의미
	}

}
