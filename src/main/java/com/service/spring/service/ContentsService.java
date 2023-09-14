package com.service.spring.service;

import java.util.List;

import com.service.spring.dto.ContentIdRequestDTO;
import com.service.spring.vo.Contents;


public interface ContentsService {
	int addSupportContents(Contents contents)throws Exception;
	int addFundingContents(Contents contents) throws Exception;
	int addAdminContents(int contentId) throws Exception;
	int updateContents(Contents contents) throws Exception;
	int deleteContents(int contentId) throws Exception;
	
	List<Contents> showAllContents() throws Exception;
	Contents showFundingContentsDetail(int fundingId) throws Exception;
	Contents showSupportContentsDetail(int scId) throws Exception;
	
	List<Contents> findContentsByCreator(String name) throws Exception;
	Contents findContentsByName(String contentName) throws Exception; 
	List<Contents> showMyContents(int userId) throws Exception;
	List<Contents> showAdminContents(int isAccepted) throws Exception;
	List<Contents> showNotableContents() throws Exception;
	List<Contents> showContentsRank() throws Exception;
	
	List<Contents> showEndedContents() throws Exception;
	List<Contents> showCustomizedContents() throws Exception;

	List<Contents> showAllSupportContents() throws Exception;
	List<Contents> showAllFundingContents() throws Exception;


}
