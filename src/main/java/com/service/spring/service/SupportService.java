package com.service.spring.service;

import java.util.List;
import java.util.Map;

import com.service.spring.vo.Contents;
import com.service.spring.vo.Support;
import com.service.spring.vo.User;

public interface SupportService {
	
	int addFunding(Support support) throws Exception; //펀딩하기 
	int deleteFunding(int supportId) throws Exception; //펀딩취소하기
	Support showFundingDetail(int supportId) throws Exception; //펀딩 세부 목록가져오기
	List<Map<String, Contents>> showFunding(int userId) throws Exception; //한 유저의 펀딩 게시글 목록 가져오기
	List<User> showFundingUser(int contentId) throws Exception; //한 게시글에 펀딩한 유저 보여주기
	
	int satisfied(int contentId) throws Exception; //수익분배
	int notSatisfied(int contentId) throws Exception; //환불하기
	
	List<Support> showSupportRank() throws Exception; //후원랭킹 보여주기
	
	List<Contents> showEndedFunding(int userId) throws Exception;//펀딩한 콘텐츠 중에서 완료된 컨텐츠 

}