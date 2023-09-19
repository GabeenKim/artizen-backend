package com.service.spring.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.UserDAO;
import com.service.spring.service.UserService;
import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;
import com.service.spring.vo.Writer;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public String isExist(String email) {
		return userDAO.isExist(email);
	}

	@Override
	public User registerUser(UserInfo userInfo) { 
		//결과로 userId를 리턴
		int infoSeq = userDAO.getUserInfoSeq();
		userInfo.setInfoId(infoSeq);
		userDAO.register(userInfo);
		int userSeq = userDAO.getUsersSeq();
		User user = new User();
		user.setUserInfo(userInfo);
		user.setUserId(userSeq);
		user.setIdentity(1);
		userDAO.register(user);
		return user;
	}

	@Override
	public Writer registerWriter(UserInfo userInfo) {
		int infoSeq = userDAO.getUserInfoSeq();
		userInfo.setInfoId(infoSeq);
		userDAO.register(userInfo);
		int writerSeq = userDAO.getWriterSeq();
		Writer writer = new Writer();
		writer.setUserInfo(userInfo);
		writer.setWriterId(writerSeq);
		userDAO.register(writer);
		
		return writer;
	}

	//로그인을 하면 controller에선 login과 showIdentity를 동시에 돌려야 함
	@Override
	public UserInfo login(UserInfo userInfo) {
		return userDAO.login(userInfo);
	}
	
	@Override
	public int showIdentity(int infoId) {
		return userDAO.showIdentity(infoId);
	}
	
	@Override
	public User showUser(int infoId) {
		return userDAO.showUser(infoId);
	}

	@Override
	public Writer showWriter(int infoId) {
		return userDAO.showWriter(infoId);
	}

//	@Override
//	public User updateUser(UserInfo userInfo, User user) {
//		userDAO.updateUserInfo(userInfo);
//		user.setUserInfo(userInfo);
//		System.out.println(userInfo.getInfoId());
//		int userId = userDAO.getUserId(userInfo.getInfoId());
//		user.setUserId(userId);
//		userDAO.updateUser(user);
//		
//		return user;
//	}

//	@Override
//	public Writer updateWriter(UserInfo userInfo) {
//		userDAO.updateUserInfo(userInfo);
//		int writerId = userDAO.getWriterId(userInfo.getInfoId());
//		Writer writer = new Writer();
//		writer.setUserInfo(userInfo);
//		writer.setWriterId(writerId);
//		return writer;
//	}

	@Override
	public int registerCharacter(HashMap<String, Object> map) {
		return userDAO.registerCharacter(map);
	}

	@Override
	public int addAccount(HashMap<String, Object> map) {
		//int infoId, String accounts, String bank
		return userDAO.addAccount(map);
	}

	@Override
	public int updateAccount(HashMap<String, Object> map) {
		//int infoId, int amount
		return userDAO.updateAccount(map);
	}

	@Override
	public int deleteAccount(int infoId) {
		return userDAO.deleteAccount(infoId);
	}

	@Override
	public int getUserId(int infoId) {
		return userDAO.getUserId(infoId);
	}

	@Override
	public int getWriterId(int infoId) {
		return userDAO.getWriterId(infoId);
	}

	@Override
	public UserInfo updateUser(UserInfo userInfo) {
		int result = userDAO.updateUserInfo(userInfo);
		if(result != 0) {
			return userInfo;
		}
		return null;
	}

	@Override
	public UserInfo updateNickname(UserInfo userInfo) {
		int result = userDAO.updateUserNickname(userInfo);
		if(result != 0) {
			return userInfo;
		}
		return null;
	}

	@Override
	public List<HashMap<String, Object>> getWriterRanking() {
		return userDAO.getWriterRanking();
	}

	@Override
	public HashMap<String, Object> getWriterInfo(int writerId) {
		return userDAO.getWriterInfo(writerId);
	}

}
