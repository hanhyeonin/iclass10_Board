package org.iclass.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewMember;

import mybatis.SqlSessionBean;

public class NewMemberDao {

	private static final NewMemberDao dao = new NewMemberDao();
	private NewMemberDao() {}
	public static NewMemberDao getInstance() {
		return dao;
	}
	
	public NewMember login(Map<String, String> map){
		SqlSession mapper = SqlSessionBean.getSession();
		NewMember vo = mapper.selectOne("newmember.login",map);		// <"id",momo> <"password",1212>
		mapper.commit();
		mapper.close();
		return vo;
	}
	public List<NewMember> selectAll(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<NewMember> list = mapper.selectList("newmember.listAll");
		mapper.commit();
		mapper.close(); 
		return list;
	}
	
}
