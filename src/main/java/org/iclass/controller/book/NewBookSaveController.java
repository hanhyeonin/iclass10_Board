package org.iclass.controller.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NewBookSaveController implements Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(NewBookSaveController.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 서버에 전송될 위치(파일시스템 경로)
		String path = "D:\\i_Class1020\\upload";
		
		// 업로드 가능한 최대 크기(바이트)
		int maxSize = 10*1024*1024;	// 1024bite = 1KB , 10MByte로 설정
		
		// request 를 파일을 받을 수 있는 request로 사용해야 합니다. : cos 라이브러리 추가
		MultipartRequest multiRequest = new MultipartRequest(request,
				path,
				maxSize,
				"UTF-8",	// UTF-8 로 인코딩
				new DefaultFileRenamePolicy());	
		// DefaultFileRenamePolicy 는 중복된 파일명에 대해 새로 파일명을 부여하는 규칙(파일명뒤에 일련번호)
		
		// 기존 방식처럼 text 타입 등 파라미터 받아오기
		String title = multiRequest.getParameter("title");
		String summary = multiRequest.getParameter("summary");
		
		// 서버로 업로드된 파일의 파일명
		String cover = multiRequest.getFilesystemName("coverfile");
		
		logger.info("::: 파일명 - {} , 책 제목 - {} , 내용 - {} :::", cover, title, summary);
		
		// 서버의 파일 시스템 D:\\i_Class1020\\upload 경로에서 파일이 생겼는지 확인하기
		//response.sendRedirect("");
	}

}
