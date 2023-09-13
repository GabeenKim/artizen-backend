package com.service.spring.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.ContentsDAO;
import com.service.spring.dao.SupportDAO;
import com.service.spring.service.SupportService;
import com.service.spring.vo.Contents;
import com.service.spring.vo.Support;
import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;

@Service
public class SupportServiceImpl implements SupportService{
	
	@Autowired
	private SupportDAO supportDAO;
	
	@Autowired
	private ContentsDAO contentsDAO;
	

	@Override
	public  List<Support> showSupportRank() {
		return supportDAO.showSupportRank();
	}

	@Override
	public List<Support> showFundingList(int contentId) throws Exception {
		return null;
	}




}
