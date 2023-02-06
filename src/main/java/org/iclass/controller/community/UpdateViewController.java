package org.iclass.controller.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

public class UpdateViewController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 수정 화면으로 데이터 보내기 구현해보세요.
		// 지정된 idx 메인글 가져오기
		
		String temp = request.getParameter("idx");
		long idx = 0;
		idx = Long.parseLong(temp);
		CommunityDao dao = CommunityDao.getInstance();
		Community vo = dao.selectByIdx(idx);
		
		request.setAttribute("vo", vo);
		// 현재페이지를 read.jsp에서 받아 update.jsp로 전달합니다
		request.setAttribute("page", request.getParameter("page"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);
	}
}
