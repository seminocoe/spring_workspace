package com.global.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.user.UserVO;
import com.global.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("�α��� ó��");
		
		//����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//�����ͺ��̽� ����
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		//ȭ�� �׺���̼�
		
		ModelAndView mav = new ModelAndView();
		
		if(user !=null){
			mav.setViewName("redirect:getBoardList.do");
		}else{
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
