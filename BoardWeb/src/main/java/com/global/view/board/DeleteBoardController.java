package com.global.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

//@Controller
public class DeleteBoardController {

	//@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("글 삭제 처리");
		
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
		
	}

}
