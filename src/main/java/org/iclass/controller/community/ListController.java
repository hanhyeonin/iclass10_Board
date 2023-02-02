package org.iclass.controller.community;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;


public class ListController implements Controller{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		// db에서 글 목록 가져오기
		CommunityDao communitydao = CommunityDao.getInstance();
		request.setAttribute("list", communitydao.list());
		// 현재 날짜 시간 저장 - 출력형식 2개 중 하나 고를때 비교값
		request.setAttribute("today", LocalDate.now());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/community/list.jsp");
		dispatcher.forward(request, response);
	}
}
