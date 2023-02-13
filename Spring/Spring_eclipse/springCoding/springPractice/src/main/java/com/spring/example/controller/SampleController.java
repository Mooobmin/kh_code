package com.spring.example.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.example.domain.ExampleVO;
import com.spring.example.domain.SampleDTO;
import com.spring.example.domain.SampleDTOList;
import com.spring.example.domain.Ticket;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/sample/*")
@Log4j

/* 
 * 참고 : @RestController (@Controller + @ResponesBody) 
 *       응답 문서 타입을 xml이나 json으로 반환할 때는 produces 속성을 사용한다.
 *       @ResponesBody: 일반적인 JSP와 같은 뷰로 전달되는 게 아니라 데이터 자체를 전달하기 위한 용도이다.
 *       ResponseEntity는 개발자가 직접 결과 데이터와 HTTP 상태 코드를 직접 제어할 수 있는 클래스.
 */
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
	public String exam02(@ModelAttribute SampleDTO sampleDTO, Model model) {
		log.info("" + sampleDTO);
		
		model.addAttribute("dto", sampleDTO);
		return "exam02"; // /WEB-INF/views/exam02.jsp를 의미
	}
	
	@GetMapping("/exam02List")
	public String exam02List(@RequestParam("language") ArrayList<String> language, Model model) {
		log.info("language : " + language.toString());
		
		for(String lang : language) {
			log.info("language : " + lang);
		}
		model.addAttribute("language", language);
		return "exam02List"; // /WEB-INF/views/exam02List.jsp를 의미
	}
	
	@GetMapping("/exam02Array")
	public String exam02Array(@RequestParam("hobby") String[] hobby, Model model) {
		log.info("Array hobby : " + Arrays.toString(hobby));
		
		model.addAttribute("hobby", hobby);
		return "exam02Array"; // /WEB-INF/views/exam02Array.jsp를 의미
	}	
	
	@GetMapping("/exam02Bean")
	public String exam02Bean(SampleDTOList list) {
		log.info("list dtoList : " + list);
				
		return "exam02Bean"; // /WEB-INF/views/exam02Bean.jsp를 의미
	}		
	@GetMapping("/exam03")
	public String exam03(SampleDTO dto, @ModelAttribute("number") int number) {
		log.info("dto : " + dto);
		log.info("number : " + number);
		
		return "sample/exam03";
	}
	
	/* @ResponesBody : 일반적인 JSP와 같은 뷰로 전달되는게 아니라 데이터 자체를 전달하기 위한 용도*/
	/* 참고 : @RestController(@Controller + @ResponseBody) */
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	@ResponseBody
	public String getText() {
		log.info("MIMe TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value="/getExample", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public SampleDTO getExample() {
		log.info("/getExample...............");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	@GetMapping(value="/getExample2", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ExampleVO getExample2() {
		return new ExampleVO(1, "김철수", "010-1234-1234"); //ExampleVO필드는 no, name, phone
	}
	
	@GetMapping("/getExample3")
	public ResponseEntity<String> getExample3(){
		log.info("/getExample3...............");
		String msg = "{\"name\" : \"홍길동\", \"email\" : \"javauser@naver.com\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ExampleVO> getList(){
		List<ExampleVO> list = new ArrayList<>();
		list.add(new ExampleVO(1, "홍길동", "010-1234-1111"));
		list.add(new ExampleVO(2, "한늘봄", "010-1234-2222"));
		list.add(new ExampleVO(3, "이진희", "010-1234-3333"));
		list.add(new ExampleVO(4, "박철희", "010-1234-4444"));
		
		return list;
	}
	
	@GetMapping("/examMethod") //회원가입화면
	public String examMethod() {
		log.info("/getMethod Get..........");
			
		return "sample/examMethod"; // /WEB-INF/views/sample/examMethod.jsp를 의미.
	}	
	@PostMapping(value="/examMethod", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String examMethod(ExampleVO evo, Ticket tvo) {
		log.info("/examMethod Post..............");
		log.info("/ExampleVO : " + evo + "Ticket : " + tvo);
		
		return "전송 성공";
	}
 
	
}
