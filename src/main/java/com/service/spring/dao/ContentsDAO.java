package com.service.spring.dao;

import java.util.List;

import com.service.spring.vo.Contents;
import com.service.spring.vo.FundingContents;
import com.service.spring.vo.Gift;
import com.service.spring.vo.SupportContents;

public interface ContentsDAO {
	int addContents(Contents contents)throws Exception;
	
	int addAdminContents(int contentId)throws Exception;
    int addSupportContents(SupportContents supportContents) throws Exception;
    int addFundingContents(FundingContents fundingContents) throws Exception;
    int updateSupportContents(SupportContents supportContents) throws Exception;
    int updateFundingContents(FundingContents fundingContents) throws Exception;
	int updateContents(Contents contents) throws Exception;
	int deleteContents(int contentId) throws Exception;
	
	List<Contents> showAllContents() throws Exception;
	Contents showFundingContentsDetail(int fundingId) throws Exception;
	Contents showSupportContentsDetail(int scId) throws Exception;
	
	List<Contents> findContentsByCreator(String name) throws Exception;
	Contents findContentsByName(String contentName) throws Exception; 
	Contents findContentsById(int contentId) throws Exception;
	List<Contents> showMyContents(int userId) throws Exception;
	List<Contents> showAdminContents(int isAccepted) throws Exception;
	List<Contents> showNotableContents() throws Exception;
	List<Contents> showContentsRank() throws Exception;
	
	List<Contents> showAllSupportContents() throws Exception;
	List<Contents> showAllFundingContents() throws Exception;

	int addGift(Gift gift) throws Exception;
	int updateGift(Gift gift) throws Exception;
}
