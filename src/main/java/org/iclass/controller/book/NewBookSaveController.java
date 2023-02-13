package org.iclass.controller.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.NewbooksDao;
import org.iclass.vo.Newbooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NewBookSaveController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(NewBookSaveController.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버에 전송될 위치(파일시스템 경로)
		String path = "D:\\i_Class1020\\upload";

		//업로드 가능한 최대 크기(바이트)
		int maxSize = 10*1024*1024;		//1024바이트=1KB, 10MByte로 설정

		//request 를 파일을 받을 수 있는 request로 사용해야 합니다. : cos 라이브러리 추가
		MultipartRequest multiRequest = new MultipartRequest(request, 
				path,
				maxSize,
				"UTF-8",
				new DefaultFileRenamePolicy());		
		//DefaultFileRenamePolicy는 중복된 파일명에 대해 새로파일명 부여하는 규칙(파일명뒤에 일련번호)

		//기존 방식처럼 text 타입 등 파라미터 받아오기
		String title = multiRequest.getParameter("title");
		String summary = multiRequest.getParameter("summary");

		//서버로 업로드된 파일의 파일명
		String cover = multiRequest.getFilesystemName("coverfile");
		logger.info("::: 파일명-{} , 책제목-{} , 내용-{} :::",cover,title,summary);
		
		//서버의 파일 시스템 D:\\iclass1020\\upload 경로에서 파일이 생겼는지 확인하기
		
		// dao의 insert 실행시키기
		NewbooksDao dao = NewbooksDao.getInstance();
		String url = null;
		Newbooks book = new Newbooks(0, title, summary, null, cover, "admin");
		if(dao.insert(book )==1) {
			url = "list";
		}else {
			url = "new";
		}
		response.sendRedirect(url);
	}

}
/*
<!-- 
			StringBuffer sb = new StringBuffer();
			//파일 업로드를 여러개 할때는 아래와 같이합니다.
			@SuppressWarnings("unchecked")
			Enumeration<String> files = multi_request.getFileNames();	//file 타입 파일명 모두 가져오기
			while(files.hasMoreElements()) {
				String f = files.nextElement();			//afile3,afile2,afile1
				String name= multi_request.getFilesystemName(f);		//업로드된 파일명 가져오기
				sb.append(name).append(",");		//파일명 여러개를 , 으로 구분해서 한 컬럼에 저장
			}
			
			//여기까지 업로드 파일개수 만큼 반복실행
			String title= multi_request.getParameter("title"); 
			vo = new NewBooks(0, title, summary, null, sb.toString(), "admin");
			adao.insert(vo);    //업로드한 파일을 테이블 컬럼 값으로 저장.
 			*참고 : db 에서 가져왔을 때는 , 기호로 분리해서 List 또는 배열로 변환하여 사용
 -->
*/