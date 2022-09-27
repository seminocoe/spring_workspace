package com.global.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.biz.board.BoardVO;

/*@Repository
public class BoardDAOMybatis extends SqlSessionDaoSupport{ ù��° ���*/

@Repository
public class BoardDAOMybatis{
	/*
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	*/
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo){
		System.out.println("===>Spring Mybatis�� inserBoard()��� ó��......");
//		getSqlSession().insert("BoardDAO.insertBoard", vo);
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo){
		System.out.println("===>Spring Mybatis�� updateBoard()��� ó��......");
//		getSqlSession().update("BoardDAO.updateBoard", vo);
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo){
		System.out.println("===>Spring Mybatis�� deleteBoard()��� ó��......");
//		getSqlSession().delete("BoardDAO.deleteBoard", vo);
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo){
		System.out.println("===>Spring Mybatis�� getBoard()��� ó��......");
//		return (BoardVO)getSqlSession().selectOne("BoardDAO.getBoard", vo);
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO>getBoardList(BoardVO vo){
		System.out.println("===>Spring Mybatis�� getBoardList()��� ó��......");
//		return getSqlSession().selectList("BoardDAO.getBoardList", vo);
		
		if(vo.getSearchCondition().equals("TITLE")) {
	         return mybatis.selectList("BoardDAO.getBoardList_T", vo);
	      }else if(vo.getSearchCondition().equals("CONTENT")) {
	         return mybatis.selectList("BoardDAO.getBoardList_C", vo);
	      }
	      return null;
		
	}
	
}
