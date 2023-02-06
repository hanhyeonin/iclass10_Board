package org.iclass.controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityCommentsDao;
import org.iclass.vo.CommunityComments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글 작성 추가

		request.setCharacterEncoding("UTF-8");		//항상 맨앞에
		CommunityCommentsDao dao = CommunityCommentsDao.getInstance();
		String f = request.getParameter("f");
		System.out.println(f);
		String url=null;		//redirect url 변수
		long mref = Long.parseLong(request.getParameter("mref"));   //메인글의 idx 를 댓글테이블 mref 컬럼에 저장해야 함.(댓글추가)
		logger.info("::::::CommentesController  f={} :::::::",f);
		request.setAttribute("page", request.getParameter("page"));
		//댓글 삭제
		// 댓글 작성 추가
		if(f.equals("1")) {
			CommunityComments vo =CommunityComments.builder()
									.mref(mref)
									.writer(request.getParameter("writer"))
									.content(request.getParameter("content"))
									.ip(request.getRemoteAddr())
									.build();
			if(dao.insert(vo)==1) url="read?idx="+mref+"&page="+request.getParameter("page");
			else url="list";

		}else if(f.equals("2")) {	
		//댓글 삭제 - 해보세요.
			CommunityComments vo = CommunityComments.builder().idx(Integer.parseInt(request.getParameter("idx"))).build();
			int idx = vo.getIdx();
			if(dao.delete(idx)==1) url="read?idx="+mref+"&page="+request.getParameter("page");
			else url="list";
		}
		//댓글 갯수 변경 dao 메소드는 편의상 CommunityCommentsDao 로 옮기기
		//댓글 갯수 변경은 ReadController에서 사용 
		//dao.setCommentCount(mref);
		response.sendRedirect("read?idx="+mref+"&page="+request.getParameter("page"));
		
	}

}