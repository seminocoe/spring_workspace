<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%@ page import="com.global.biz.board.BoardVO" %>

<!-- 여기 파일을 디스패쳐로 옮겨서 삭제해도 작동함 -->

<%
//1.사용자 입력 정보 추출
request.setCharacterEncoding("UTF-8");
String title = request.getParameter("title");
String content = request.getParameter("content");
String seq = request.getParameter("seq");

//DB연동
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setSeq(Integer.parseInt(seq));

BoardDAO boardDAO = new BoardDAO();
boardDAO.updateBoard(vo);

//화면 응답
response.sendRedirect("getBoardList.jsp");

%>