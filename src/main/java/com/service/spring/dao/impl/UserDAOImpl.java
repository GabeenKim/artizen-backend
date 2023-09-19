package com.service.spring.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.UserDAO;
import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;
import com.service.spring.vo.Writer;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	public static final String NS = "sql.user.mapper.";
	
	@Override
	public int register(UserInfo userInfo) {
		return sqlSession.insert(NS+"registerInfo", userInfo);
	}

	@Override
	public int register(User user) {
		return sqlSession.insert(NS+"registerUser", user);

	}

	@Override
	public int register(Writer writer) {
		return sqlSession.insert(NS+"registerWriter", writer);
	}

//	@Override
//	public int updateUser(User user) {
//		return sqlSession.update(NS+"updateUser", user);
//	}

	@Override
	public int updateUserInfo(UserInfo userInfo) {
		return sqlSession.update(NS+"updateUserInfo", userInfo);
	}
	
	@Override
	public int updateUserNickname(UserInfo userInfo) {
		return sqlSession.update(NS+"updateUserNickname", userInfo);
	}
	
	@Override
	public int addAccount(HashMap<String, Object> map) {
		return sqlSession.insert(NS+"addAccount", map);
	}

	@Override
	public int updateAccount(HashMap<String, Object> map) {
		return sqlSession.update(NS+"updateAccount", map);
	}

	@Override
	public int deleteAccount(int infoId) {
		return sqlSession.delete(NS+"deleteAccount", infoId);
	}

	@Override
	public String isExist(String email) {
		return sqlSession.selectOne(NS+"isExist", email);
	}

	@Override
	public UserInfo login(UserInfo userInfo) {
		return sqlSession.selectOne(NS+"login", userInfo);
	}

	@Override
	public User showUser(int infoId) {
		return sqlSession.selectOne(NS+"showUser", infoId);
	}

	@Override
	public Writer showWriter(int infoId) {
		return sqlSession.selectOne(NS+"showWriter", infoId);
	}

	@Override
	public int showIdentity(int infoId) {
		return sqlSession.selectOne(NS+"showIdentity", infoId);
	}

	@Override
	public int registerCharacter(HashMap<String, Object> map) {
		return sqlSession.update(NS+"registerCharacter", map);
	}

	@Override
	public int getUserInfoSeq() {
		return sqlSession.selectOne(NS+"getUserInfoSeq");
	}

	@Override
	public int getUsersSeq() {
		return sqlSession.selectOne(NS+"getUsersSeq");
	}

	@Override
	public int getWriterSeq() {
		return sqlSession.selectOne(NS+"getWriterSeq");
	}

	@Override
	public int getUserId(int infoId) {
		return sqlSession.selectOne(NS+"getUserId", infoId);
	}

	@Override
	public int getWriterId(int infoId) {
		return sqlSession.selectOne(NS+"getWriterId", infoId);
	}

	@Override
	public List<HashMap<String, Object>> getWriterRanking() {
		List<HashMap<String, Object>> result=null;
		try {
			result = sqlSession.selectList(NS+"getWriterRanking");
			return result;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}


	@Override
	public User showUserById(int userId) {
		return sqlSession.selectOne(NS + "showUserById", userId);
	}

	@Override
	public HashMap<String, Object> getWriterInfo(int writerId) {
		return sqlSession.selectOne(NS + "getWriterInfo", writerId);
	}



}
