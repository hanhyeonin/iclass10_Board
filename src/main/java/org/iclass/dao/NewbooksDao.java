package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Newbooks;

import mybatis.SqlSessionBean;

public class NewbooksDao {
	
	private static final NewbooksDao dao = new NewbooksDao();
	private NewbooksDao() {}
	public static NewbooksDao getInstance() {return dao;}
	
	public List<Newbooks> list(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<Newbooks> list = mapper.selectList("newbooks.listAll");
		mapper.close(); 
		return list;
	}
	
	public int insert(Newbooks book) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("newbooks.insert", book);
		mapper.commit();
		mapper.close();
		return result;	
	}
}
