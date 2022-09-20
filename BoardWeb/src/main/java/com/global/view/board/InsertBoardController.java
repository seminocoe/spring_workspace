package com.global.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;
import com.global.view.controller.Controller;

public class InsertBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("글 등록 처리");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// DB 연동
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		// 화면 응답
		return "getBoardList.do";
	}

}
