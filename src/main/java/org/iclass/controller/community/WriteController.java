package org.iclass.controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String ip = request.getRemoteAddr();
		
		Community vo = Community.builder()
				.title(request.getParameter("title"))
				.writer(request.getParameter("writer"))
				.content(request.getParameter("content"))
				.ip(ip)
				.build();
		CommunityDao dao = CommunityDao.getInstance();

		long result = dao.insert(vo);
		if (result != 0) {
			// list로 이동
			response.sendRedirect("list");
		}else{
			// 메인화면으로 이동
			response.sendRedirect(request.getContextPath());
		}
	}
}
