package org.iclass.controller.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.NewbooksDao;
import org.iclass.vo.Newbooks;

public class NewBookListController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NewbooksDao dao = NewbooksDao.getInstance();
		List<Newbooks> list = dao.list();
		
		request.setAttribute("books", list);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("newbooks.jsp");
		dispatcher.forward(request, response);
	}

}
