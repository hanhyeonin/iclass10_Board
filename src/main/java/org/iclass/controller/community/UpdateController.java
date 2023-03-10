package org.iclass.controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

public class UpdateController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		long idx = Long.parseLong(request.getParameter("idx"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		
		
		CommunityDao dao = CommunityDao.getInstance();
		Community vo = Community.builder()
				.title(title)
				.content(content)
				.idx(idx)
				.ip(ip).build();
		System.out.println(vo);
		int result = dao.update(vo);
		System.out.println("result = " + result);
		
		if(result == 1) {
			// 현재페이지 번호전달
			response.sendRedirect("read?idx="+idx+"&page="+request.getParameter("page"));
		}else
			response.sendRedirect(request.getContextPath());	// 메인페이지로 이동
	}
}
