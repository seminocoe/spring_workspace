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
		
		System.out.println("�� ��� ��ȸ ó��");
		
		//�˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ������
		mav.addObject("boardList", boardDAO.getBoardList(vo));//Model ������ ����
		mav.setViewName("getBoardList.jsp");//View ������ ����
		
		return mav;
	}

}
