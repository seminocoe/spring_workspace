package com.global.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.Ŭ���̾�Ʈ�� ��û path������ ����
		String uri = request.getRequestURI();//BoardWeb/
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		//2.Ŭ���̾�Ʈ ��û�� path�� ���� ������ �б�ó���Ѵ�.
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó��");
		}else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
		}else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ó��");
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� ��ȸ ó��");
		}
	}
	
}
