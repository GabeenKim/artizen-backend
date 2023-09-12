package com.service.spring.dao;

import java.util.List;
import java.util.Map;

import com.service.spring.vo.Contents;
import com.service.spring.vo.Support;
import com.service.spring.vo.User;

public interface SupportDAO {
	
	int addFunding(Support support); //펀딩하기 
	int deleteFunding(String supportId); //펀딩취소하기
	Support showFundingDetail(int supportId); //펀딩 세부 목록가져오기
	List<Map<String, Contents>> showFunding(int userId); //한 유저의 펀딩 게시글 목록 가져오기
	List<User> showFundingUser(int contentId); //한 게시글에 펀딩한 유저 보여주기
	
	int satisfied(int contentId); //수익분배
	int notSatisfied(int supportId); //환불하기
	
	List <Contents> showSupportRank(); //후원랭킹 보여주기
	

}
