package com.global.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;
import com.global.view.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제 처리");
		
		//1.사용자 입력 정보 추출
		String seq = request.getParameter("seq");

		//DB연동
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);

		//화면 응답
		return "getBoardList.do";
	}

}
