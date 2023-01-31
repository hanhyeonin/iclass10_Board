package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;

import mybatis.SqlSessionBean;

public class CommunityDao {
	private static final CommunityDao dao = new CommunityDao();
	private CommunityDao() {}
	public static CommunityDao getInstance() {
		return dao;
	}
	
	public int insert(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("insert", vo);
		
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int update(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("update", vo);
		
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int delete(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("delete", vo);
		
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public Community selectOne(int idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		Community vo = mapper.selectOne("selectOne", idx);
		
		mapper.close();
		return vo;
	}
	
	public List<Community> selectAll(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<Community> list = mapper.selectList("selectAll");
		
		mapper.close();
		return list;
	}
}
