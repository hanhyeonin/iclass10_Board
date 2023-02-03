package org.iclass.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;

import mybatis.SqlSessionBean;

public class CommunityDao {
	private static final CommunityDao dao = new CommunityDao();
	private CommunityDao() {}
	public static CommunityDao getInstance() {
		return dao;
	}
	
	// [update] id=setCommentCount : 댓글 개수 업데이트(댓글 추가, 삭제 할때 필요함.)
	public int updateCount(long mref) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.setCommentCount",mref);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	// [insert] id=insert : 메인글 생성
	public long insert(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		mapper.insert("community.insert", vo);
		mapper.commit();
		mapper.close();
		return vo.getIdx();		// 매퍼xml에서 selectKey로 시퀀스 값을 vo객체에 저장시킵니다.
	}
	
	// [update] id=update : 글제목, 글내용, ip수정하는 update (PK값으로 조회)
	public int update(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.update", vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	// [delete] id=delete : PK값으로 조회 후 삭제
	public int delete(long idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("community.delete", idx);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	// [select] id=selectByIdx : PK값으로 메인글 조회
	public Community selectByIdx(long idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		Community vo = mapper.selectOne("community.selectByIdx", idx);
		mapper.commit();
		mapper.close();
		return vo;
	}
	
	// [select] id=count : 전체 메인글의 갯수
	public int count() {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("community.count");
		mapper.commit();
		mapper.close();
		return result;
	}
	
	
	// [select] id=maxOf(idx) : idx 최대값
	public int selectMaxOf() {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("community.maxOf");
		mapper.commit();
		mapper.close();
		return result;
	}
	
	// [select] id="" :
	public List<Community> list(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<Community> list = mapper.selectList("community.list");
		mapper.commit();
		mapper.close();
		return list;
	}
	
	//메인글 목록 가져오기 - 할일 : 한번에(즉 한페이지에) 글 10개씩 가져오도록 변경
	public List<Community> pagelist(Map<String,Integer> map) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		List<Community> list = mapperSession.selectList("community.pagelist",map);
		mapperSession.close();
		return list;
	}

	
	public int setReadCount(long idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.setReadCount", idx);
		mapper.commit();
		mapper.close();
		return result;
	}
}
