package com.global.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.global.biz.board.BoardVO;
import com.global.biz.common.JDBCUtil;

//@Repository
public class BoardDAO {

	//JDBC���� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//SQL��ɾ��
	private final String BOARD_INSERT=
			"insert into sboard(seq, title, writer, content) values((select nvl(max(seq),0)+1 from sboard), ?, ?, ?)";
	private final String BOARD_UPDATE="update sboard set title=?, content=? where seq=?";
	private final String BOARD_DELETE="delete sboard where seq=?";
	private final String BOARD_GET="select * from sboard where seq = ?";
	private final String BOARD_LIST="select * from sboard order by seq desc";
	private final String BOARD_LIST_T="select * from sboard where title like '%'|| ? ||'%' order by desc";
	private final String BOARD_LIST_C="select * from sboard where content like '%'|| ? ||'%' order by desc";
	
	//CRUD ����� �޼ҵ带 ����
	//�� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("====>JDBC�� insertBoard()��� ó��...");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	//�� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("====>JDBC�� updateBoard()��� ó��...");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	//�� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("====>JDBC�� deleteBoard()��� ó��...");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	//�� ����ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("====>JDBC�� getBoard()��� ó��...");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}
	//�� �����ȸ
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("====>JDBC�� getBoardList()��� ó��...");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_LIST);
			if(vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_LIST_T);
			}else if(vo.getSearchCondition().equals("CONTENT")) {
				stmt = conn.prepareStatement(BOARD_LIST_C);
			}
			stmt.setString(1, vo.getSearchKeyword());
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
}
