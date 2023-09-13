package com.service.spring.service;

import java.util.List;
import java.util.Map;

import com.service.spring.vo.Support;
import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;

public interface SupportService {
	
	
	 List<Support>  showSupportRank(); //후원랭킹 보여주기
	List<Support> showFundingList(int contentId)throws Exception;
}
