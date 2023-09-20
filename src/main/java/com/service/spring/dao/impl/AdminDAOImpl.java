package com.service.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.AdminDAO;
import com.service.spring.vo.Contents;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;
	public static final String NS = "sql.admin.mapper.";
	
	@Override
	public List<Contents> checkList() throws Exception{
		return sqlSession.selectList(NS + "checkList");
	}

	@Override
	public int ok(int contentId) throws Exception {
		return sqlSession.update(NS + "ok", contentId);
	}

	@Override
	public int fail(int contentId) throws Exception {
		return sqlSession.update(NS + "fail", contentId);
	}

	@Override
	public List<Contents> okList() throws Exception {
		return sqlSession.selectList(NS + "okList");
	}

	@Override
	public List<Contents> failList() throws Exception {
		return sqlSession.selectList(NS + "failList");
	}

	@Override
	public List<Map<String, Object>> userList() throws Exception {
		return sqlSession.selectList(NS + "userList");
	}

	@Override
	public String getWriterName(int writerId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS + "getWriterName", writerId);
	}
	
}
