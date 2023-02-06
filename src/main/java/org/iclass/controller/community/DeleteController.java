package org.iclass.controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

public class DeleteController implements Controller {
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		
		long idx = Long.parseLong("idx");
		CommunityDao dao = CommunityDao.getInstance();
		int result = dao.delete(idx);
		if (result == 1) {
			// 삭제한 글이 있던 페이지로 돌아가기(요청 리다이렉트)
			response.sendRedirect("list?page="+request.getParameter("page"));
		}else{
			// 메인화면으로 이동
			response.sendRedirect(request.getContextPath());
		}
	}

}
