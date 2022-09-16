package com.global.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.global.biz.board.BoardVO;

@Repository
public class BoardDAOSpring{//�ι�° ���
//public class BoardDAOSpring extends JdbcDaoSupport{ //ù��° ���
	//SQL ��ɾ�
	private final String BOARD_INSERT=
			"insert into sboard(seq, title, writer, content) values((select nvl(max(seq),0)+1 from sboard), ?, ?, ?)";
	private final String BOARD_UPDATE="update sboard set title=?, content=? where seq=?";
	private final String BOARD_DELETE="delete sboard where seq=?";
	private final String BOARD_GET="select * from sboard where seq = ?";
	private final String BOARD_LIST="select * from sboard order by seq desc";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//ù��° ����ÿ��� �̷��� ������
	/*
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	*/
	//CRUD ����� �޼ҵ� ����
	
	//�� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("====>Spring JDBC�� insertBoard() ��� ó��...");
//		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	//�� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("====>Spring JDBC�� updateBoard() ��� ó��...");
//		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	//�� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("====>Spring JDBC�� deleteBoard() ��� ó��...");
//		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	//�� �󼼺���
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("====>Spring JDBC�� getBoard() ��� ó��...");
		Object[] args = {vo.getSeq()};
//		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
		
	}
	//�� ���
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("====>Spring JDBC�� getBoardList() ��� ó��...");
//		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}
