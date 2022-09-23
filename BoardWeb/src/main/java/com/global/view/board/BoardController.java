package com.global.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardService;
import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException{

		System.out.println("글 등록 처리");
		
		//파일 업로드 처리를 함
		MultipartFile uploadFile = vo.getUploadFile();
		
		if(!uploadFile.isEmpty()) {//비지 않았을 경우
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/pk/"+fileName));//업로드할 파일의 위치를 잡기
		}
		
		boardService.insertBoard(vo);

		return"getBoardList.do";
	}
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String handleRequest(@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 수정 처리");
		
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		
		System.out.println("글 삭제 처리");
		
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
		
	}
	/*
	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {

		System.out.println("글 상세 조회 처리");
		
		mav.addObject("board", boardDAO.getBoard(vo));//Board정보를 저장
		mav.setViewName("getBoard.jsp");//View정보를 저장
		
		return mav;
	}
	
	//글 목록 조회
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		System.out.println("글 목록 조회 처리");
		
		//검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
		mav.addObject("boardList", boardDAO.getBoardList(vo));//Model 정보를 저장
		mav.setViewName("getBoardList.jsp");//View 정보를 저장
		
		return mav;
	}
	*/
	
		//검색 조건 목록 설정
		@ModelAttribute("conditionMap")
		public Map<String, String>searchConditionMap(){
			
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("제목", "TITLE");
			conditionMap.put("내용", "CONTENT");
			
			return conditionMap;
		}
	
		//글 상세 조회
		@RequestMapping("/getBoard.do")
		public String getBoard(BoardVO vo, Model model) {

			System.out.println("글 상세 조회 처리");
			
			model.addAttribute("board", boardService.getBoard(vo));//Board정보를 저장
			return "getBoard.jsp";//View 이름 리턴함
		}
		
		//글 목록 조회
		@RequestMapping("/getBoardList.do")
		public String getBoardList(BoardVO vo, Model model) {
			System.out.println("글 목록 조회 처리");
			
			if(vo.getSearchCondition() == null)vo.setSearchCondition("TITLE");
			if(vo.getSearchKeyword() == null)vo.setSearchKeyword("");
			
			
			//검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
			model.addAttribute("boardList", boardService.getBoardList(vo));//Model 정보를 저장
			return "getBoardList.jsp";//View 이름 리턴
		}
		/*
		//글 목록 조회
		@RequestMapping("/getBoardList.do")
		public String getBoardList(BoardVO vo,
				
				@RequestParam(value = "searchCondition",defaultValue = "TITLE", required = false)String condition
				,@RequestParam(value = "serchKeyword",defaultValue = "", required = false)String keyword
				, BoardDAO boardDAO, Model model) {
			System.out.println("글 목록 조회 처리");
			System.out.println("검색 조건:"+condition);
			System.out.println("검색 키워드:"+keyword);
			
			//검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
			model.addAttribute("boardList", boardDAO.getBoardList(vo));//Model 정보를 저장
			return "getBoardList.jsp";//View 이름 리턴
		}
		*/
}
