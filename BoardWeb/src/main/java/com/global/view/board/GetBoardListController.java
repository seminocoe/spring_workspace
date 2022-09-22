package com.global.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController{

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		System.out.println("글 목록 조회 처리");
		
		//검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
		mav.addObject("boardList", boardDAO.getBoardList(vo));//Model 정보를 저장
		mav.setViewName("getBoardList.jsp");//View 정보를 저장
		
		return mav;
	}

}
