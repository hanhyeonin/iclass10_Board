package org.iclass.controller.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;
import org.iclass.dao.NewMemberDao;
import org.iclass.vo.NewMember;

// new RequestKeyValue("/login.hrd", "POST")
public class LoginActionController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		NewMemberDao dao = NewMemberDao.getInstance();

		Map<String, String> map = new HashMap<String, String>();

		map.put("id", id);
		map.put("password", password);
		NewMember vo = dao.login(map);

		String url = null;
		if (vo != null) {
			// 로그인 성공
			session.setAttribute("user", vo); // 핵심
			url = request.getContextPath();
		} else
			url="login?incorrect=y";		// login 실패시 login.jsp에 있는 스크립트 실행
		
		response.sendRedirect(url);
	}

}
