package com.service.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.SupportDAO;
import com.service.spring.vo.Contents;
import com.service.spring.vo.Support;
import com.service.spring.vo.User;

@Repository
public class SupportDAOImpl implements SupportDAO {
	
	public static final String NS ="ns.sql.support.mapper.";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addFunding(Support support) {
		int result = sqlSession.insert(NS+"addFunding", support);
		return result;
	}

	@Override
	public int deleteFunding(int supportId) {
		int result = sqlSession.delete(NS+"deleteFunding", supportId);
		return result;
	}
	

	//selectOne으로 ..
	@Override
	public Support showFundingDetail(int supportId) {
		return sqlSession.selectOne(NS+"showFundingDetail", supportId);
	}

	@Override
	public List<Map<String, Contents>> showFunding(int userId) {
		List<Map<String, Contents>> list = sqlSession.selectList(NS+"showFunding", userId);
        return list;
	}

	@Override
	public List<Support> showFundingUser(int contentId) {
		return sqlSession.selectList(NS+"showFundingUser", contentId);
	}

	@Override
	public int satisfied(int contentId) {
		int result = sqlSession.update(NS+"satisfied", contentId);
		return result;
	}

	@Override
	public int notSatisfied(int supportId) {
		int result = sqlSession.update(NS+"notSatisfied", supportId);
		return result;
	}

	@Override
	public List<Support> showSupportRank() {
		return sqlSession.selectList(NS+"showSupportRank");
	}

	@Override
	public int deleteFundingByContentId(int contentId) {
		return sqlSession.delete(NS + "deleteFundingByContentId");
	}

	

}
