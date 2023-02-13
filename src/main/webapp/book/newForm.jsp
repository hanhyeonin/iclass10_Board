<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>우리 북카페</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/community.css?v=3">  <!-- 절대경로 -->
<!-- 상대경로는 ../css/community.css 입니다. 
request객체의 contextPath를 el로 접근할 때에는 현재 jsp 객체 pageContext 를 사용해야 합니다. -->
</head>
<body>
			<main id="write">
			<h3>새로나온 책 </h3>
			<p>이달에 새로 나온 책을 소개합니다.</p>
			<hr style="color:white;">
			<form method="post" action="new" enctype="multipart/form-data">
				<input type="hidden" name="userid" value="${user.id }">
			 <table>
			 	<tr><th style="width:25;"><label>책 제목</label></th>
			 		<td><input type="text" name="title" size="50" required></td>
			 	</tr>
			 	<tr>
			 	<!-- 사용자가 선택 이미지 파일이 서버에 업로드 되도록합니다. form 태그의 enctype 속성-->
					<th><label>책 커버<br>(이미지파일첨부)</label></th>
			 		<td><input type="file" name="coverfile" accept="image/*">
			 		<!-- 웹에서 파일형식 MIME 으로 설정. 이미지 파일 선택 accept 속성 설정 -->
			 		</td>
			 	</tr>
			 	<tr><th><label>책 내용 요약</label></th> 
			 		<td><textarea  rows="30" cols="80" name="summary" style="resize:none;" required></textarea>
			 		</td>
			 	</tr>
			 	<tr>
			 	<!-- <th></th> -->
			 	<td style="text-align: center;padding: 10px;" colspan="2">
			 	<button type="submit">저장</button>
			 	<button type="reset">다시쓰기</button>
			 	<button type="button" onclick="location.href='list'">목록</button>
			 	</td></tr>
			 </table>
			 </form>
			 </main>
</body>
</html>