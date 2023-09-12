package com.service.spring.service;

import java.util.HashMap;

import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;
import com.service.spring.vo.Writer;

public interface UserService {
	String isExist(String email);
	User registerUser(UserInfo userInfo);
	Writer registerWriter(UserInfo userInfo);
	
	UserInfo login(UserInfo userInfo);
	int showIdentity(int infoId);
	User showUser(int infoId);
	Writer showWriter(int infoId);
	
	User updateUser(UserInfo userInfo, User user);
	Writer updateWriter(UserInfo userInfo);
	int registerCharacter(HashMap<String, Object> map);	//int userId, String character
	
	int addAccount(HashMap<String, Object> map); /** int infoId, String accounts, String bank*/
	int updateAccount(HashMap<String, Object> map); //int infoId, int amount
	int deleteAccount(int infoId);
	
	int getUserId(int infoId);
	int getWriterId(int infoId);
}
