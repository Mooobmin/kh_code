package com.spring.client.board.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	/************************************************************
	 * 글수정 폼 출력하기
	 * @param : b_num
	 * @return : BoardVO
	 ************************************************************/
	@RequestMapping(value="/updateForm")
	public String updateForm(@ModelAttribute BoardVO bvo, Model model ) {
		log.info("updateForm 호출 성공");
		log.info("b_num = " + bvo.getB_num());
		
		BoardVO updateData = boardService.updateForm(bvo);
		
		model.addAttribute("updateData",updateData);
		return "board/updateForm";
	}
	
	/************************************************************
	 * 글수정 기능 구현하기
	 * @param : BoardVO
	 * 참고 : RedirectAttributes 객체는 리다이렉트 시점(return "redirect:/경로")에 
	 * 한번만 사용되는 데이터를 전송할 수 있는 addFlashAttribute()라는 기능을 지원한다. 
	 * addFlashAttribute() 메서드는 브라우저까지 전송되기는 하지만, URI상에는 보이지 않는 숨겨진 데이터의 형태로 전달된다.
	 ************************************************************/
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(@ModelAttribute BoardVO board/*, RedirectAttributes ras*/) throws Exception{
		log.info("boardUpdate 호출 성공");
		log.info("BoardVO" + board);
		
		int result = 0;
		String url = "";
		
		result = boardService.boardUpdate(board);
		//ras.addFlashAttribute("boardVO", board);
		
		if(result == 1) {
			//아래 url은 수정 후 상세페이지로 이동
			url="/board/boardDetail?b_num="+board.getB_num();
			//url="/board/boardDetail";
		} else {
			url="/board/updateForm?b_num="+board.getB_num();
			//url="/board/updateForm";
		}
		return "redirect:"+url;
	}

	/************************************************************
	 * 글삭제 구현하기
	 ************************************************************/
	@RequestMapping(value = "/boardDelete")
	public String boardDelete(@ModelAttribute BoardVO board) throws Exception{
		log.info("boardDelete 호출 성공");
		log.info("삭제할 글 번호 : " + board.getB_num());

		//아래 변수에는 입력 성공에 대한 상태값 담습니다(1 or 0)
		int result = 0;
		String url= "";

		//result = boardService.boardDelete(board.getB_num());
		result = boardService.boardDelete(board);

		if(result == 1){
			url="/board/boardList";
		} else{
			url="board/boardDetail?b_num=" + board.getB_num();
		}
		return "redirect:"+url;
	}
	/************************************************************
	 * 본인글 확인 기능 구현
	 ************************************************************/
	@RequestMapping(value="/pwdConfirm")
	public String pwdConfirm(@ModelAttribute BoardVO board) throws Exception{
		log.info("pwdConfirm 호출 성공");

		int result = 0;

		result = boardService.pwdConfirm(board);

		if(result == 1){
			log.info("본인 글 입니다.");
		} else{
			log.info("비밀번호를 다시 확인 해주세요.");
		}
		
		return null;
	}
}
