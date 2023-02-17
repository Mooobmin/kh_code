package com.spring.client.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	/************************************************************
	 * 글목록 구현하기(페이징 처리 부분과 검색 제외 목록 조회
	 * 요청 URL : http://localhost:8080/board/boardList
	 ************************************************************/
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(Model model) {
		log.info("boardList() 메서드 호출");
		
		int no = 0;
		List<BoardVO> boardList = boardService.boardList(no);
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	/************************************************************
	 * 글쓰기 폼 구현
	 ************************************************************/	
	@RequestMapping(value="/writeForm")
	public String writeForm() {
		log.info("writeForm 호출 성공");
		
		return "board/writeForm";
	}
	
	/************************************************************
	 * 글쓰기 처리 메서드 구현
	 ************************************************************/

	//@RequestMapping(value="/boardInsert", method=RequestMethod.POST)
	@PostMapping("/boardInsert")
	public String boardInsert(@ModelAttribute BoardVO bvo, Model model) {
		log.info("boardInsert 메서드 호출 성공");
		
		int result = 0;
		String url = "";
		
		result = boardService.boardInsert(bvo);
		if(result == 1) {
			url = "/board/boardList";
		} else {
			url = "/board/writeForm";
		}
		return "redirect:"+url;
	}
	
	/************************************************************
	 * 상세페이지 폼 구현
	 ************************************************************/
	@RequestMapping(value="/boardDetail", method=RequestMethod.GET)
	public String boardDetail(@ModelAttribute BoardVO bvo, Model model) {
		log.info("boardDetail 호출 성공");
		
		BoardVO detail = boardService.boardDetail(bvo);
		model.addAttribute("detail", detail);
	
		return "board/boardDetail";
	}
	
}
