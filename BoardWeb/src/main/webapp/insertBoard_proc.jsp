<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.global.biz.board.BoardVO"%>
<%@ page import="com.global.biz.board.impl.BoardDAO"%>

<%
// 사용자 입력 정보 추출
request.setCharacterEncoding("UTF-8");
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
response.sendRedirect("getBoardList.jsp");
%>