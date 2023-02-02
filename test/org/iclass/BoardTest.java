package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.iclass.dao.CommunityCommentsDao;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
	CommunityDao communitydao = CommunityDao.getInstance();
	CommunityCommentsDao commentdao = CommunityCommentsDao.getInstance();

//	@DisplayName("메인글쓰기 insert")
//	@Test
//	void insertMain() {
//		Community vo = Community.builder().writer("대머리").title("빡빡이").content("대머리는 빡빡이입니다").build();
//		int result = communitydao.maxOf();
//		communitydao.insert(vo);
//		assertEquals(vo.getIdx(), result+1);
//	}
	
//	@DisplayName("update setCommentCount")
//	@Test
//	void updateSetCommentCount() {
//		
//		int cnt = communitydao.updateCount(3);
//		assertEquals(cnt, 1);
//	}
	
//	@DisplayName("selectCount")
//	@Test
//	void updateSetCommentCount() {
//		
//		int cnt = communitydao.selectCount();
//		assertEquals(cnt, 10);
//	}
	
//	@DisplayName("메인글 10개씩 조회")
//	@Test
//	void select10() {
//		List<Community> list = communitydao.se();
//		for (Community c : list) {
//			System.out.println(c);
//		}
//		assertEquals(list.size(), 10);
	}

