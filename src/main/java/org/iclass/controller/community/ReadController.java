package org.iclass.controller.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityCommentsDao;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;

public class ReadController implements Controller{
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		String temp = request.getParameter("idx");			//메인글 글번호 파라미터로 받기
		long idx=0;
		try {
			idx = Long.parseLong(temp);
		}catch (NumberFormatException e) {
			response.sendRedirect("list");
		}
		
		CommunityDao dao = CommunityDao.getInstance();
		// 조회수 증가
		dao.setReadCount(idx);
		Community vo = dao.selectByIdx(idx);
		request.setAttribute("vo", vo);
		
		//idx 메인글의 댓글리스트를 애트리뷰트에 저장하기
		CommunityCommentsDao cdao = CommunityCommentsDao.getInstance();
		List<CommunityComments> cmtlist = cdao.comments(idx);
		request.setAttribute("cmtlist", cmtlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("read.jsp");
		dispatcher.forward(request, response);
	}

}
