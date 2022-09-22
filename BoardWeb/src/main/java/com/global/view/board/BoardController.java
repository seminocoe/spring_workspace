package com.global.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	//�� ���
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {

		System.out.println("�� ��� ó��");
		
		boardDAO.insertBoard(vo);

		return"getBoardList.do";
	}
	//�� ����
	@RequestMapping("/updateBoard.do")
	public String handleRequest(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
	//�� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("�� ���� ó��");
		
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
		
	}
	/*
	//�� �� ��ȸ
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {

		System.out.println("�� �� ��ȸ ó��");
		
		mav.addObject("board", boardDAO.getBoard(vo));//Board������ ����
		mav.setViewName("getBoard.jsp");//View������ ����
		
		return mav;
	}
	
	//�� ��� ��ȸ
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		System.out.println("�� ��� ��ȸ ó��");
		
		//�˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ������
		mav.addObject("boardList", boardDAO.getBoardList(vo));//Model ������ ����
		mav.setViewName("getBoardList.jsp");//View ������ ����
		
		return mav;
	}
	*/
		@ModelAttribute("conditionMap")
		public Map<String, String>searchConditionMap(){
			
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("����11", "TITLE");
			conditionMap.put("����11", "CONTENT");
			
			return conditionMap;
		}
	
		//�� �� ��ȸ
		@RequestMapping("/getBoard.do")
		public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {

			System.out.println("�� �� ��ȸ ó��");
			
			model.addAttribute("board", boardDAO.getBoard(vo));//Board������ ����
			return "getBoard.jsp";//View �̸� ������
		}
		
		//�� ��� ��ȸ
		@RequestMapping("/getBoardList.do")
		public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
			System.out.println("�� ��� ��ȸ ó��");
			
			//�˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ������
			model.addAttribute("boardList", boardDAO.getBoardList(vo));//Model ������ ����
			return "getBoardList.jsp";//View �̸� ����
		}
		/*
		//�� ��� ��ȸ
		@RequestMapping("/getBoardList.do")
		public String getBoardList(BoardVO vo,
				
				@RequestParam(value = "searchCondition",defaultValue = "TITLE", required = false)String condition
				,@RequestParam(value = "serchKeyword",defaultValue = "", required = false)String keyword
				, BoardDAO boardDAO, Model model) {
			System.out.println("�� ��� ��ȸ ó��");
			System.out.println("�˻� ����:"+condition);
			System.out.println("�˻� Ű����:"+keyword);
			
			//�˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ������
			model.addAttribute("boardList", boardDAO.getBoardList(vo));//Model ������ ����
			return "getBoardList.jsp";//View �̸� ����
		}
		*/
}