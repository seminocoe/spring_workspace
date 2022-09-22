package com.global.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 목록 조회 처리");
		
		//DB연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		//검색결과를 세션에 저장하고 글 목록 화면으로 이동
		/*
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
		*/
		
		//검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);//Model 정보를 저장
		mav.setViewName("getBoardList");//View 정보를 저장
		
		return mav;
	}

}
