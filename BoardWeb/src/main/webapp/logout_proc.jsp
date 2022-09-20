<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 여기 파일을 디스패쳐로 옮겨서 삭제해도 작동함 -->
<%

session.invalidate();

response.sendRedirect("login.jsp");

%>
