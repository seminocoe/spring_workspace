package com.global.biz.board;

import java.util.List;

import com.global.biz.board.impl.BoardDAO;

public class BoardServiceClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setTitle("myBatis 임시 제목....");
		vo.setWriter("홍길동");
		vo.setContent("myBatis는 조선 최고의 데이터베이스 프레임 워크임당...");
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		for(BoardVO board: boardList) {
			System.out.println("------>"+board.toString());
		}
		
	}

}
