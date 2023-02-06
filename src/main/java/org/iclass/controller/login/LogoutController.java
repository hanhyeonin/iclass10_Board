package org.iclass.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;

// new RequestKeyValue("/logout.hrd", "GET")
public class LogoutController implements Controller {
	// 로그아웃
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();		// 세션 무효화 : 기존 세션ID 삭제
		
		//response.sendRedirect(request.getContextPath());		// 로그아웃 후 메인페이지로 요청 redirect
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("logout.jsp");
		dispatcher.forward(request, response);		// 로그아웃
	}

}
