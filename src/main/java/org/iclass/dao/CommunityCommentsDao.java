package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;

import mybatis.SqlSessionBean;

public class CommunityCommentsDao {

	private static final CommunityCommentsDao dao = new CommunityCommentsDao();
	private CommunityCommentsDao() {}
	public static CommunityCommentsDao getInstance() {return dao;}

	// [insert] id="insert" : 댓글 생성
	public int insert(CommunityComments vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("communityComments.insert", vo);
		mapper.commit();
		mapper.close();
		return result;
	}

	// [delete] id="delete" : idx 조회 후 삭제
	public int delete(int idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("communityComments.delete", idx);
		mapper.commit();
		mapper.close();
		return result;
	}

	// [select] id="maxOf"(idx) : idx 최대값
	public int selectMaxOf() {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("communityComments.maxOf");
		mapper.commit();
		mapper.close();
		return result;
	}

	// [select] id=comments : PK값으로 메인글 조회
	public List<CommunityComments> comments(long mref) {
		SqlSession mapper = SqlSessionBean.getSession();
		List<CommunityComments> list = mapper.selectList("communityComments.comments", mref);
		mapper.commit();
		mapper.close();
		return list;
	}

	// [select] id="commentsCount" : 메인글 idx의 댓글 갯수
	public int selectCommentsCount(long mref) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("communityComments.commentsCount",mref);
		mapper.commit();
		mapper.close();
		return result;
	}
}
