package com.service.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.AdminDAO;
import com.service.spring.service.AdminService;
import com.service.spring.vo.Contents;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public List<Contents> checkList() throws Exception {
		return adminDAO.checkList();
	}

	@Override
	public int ok(int contentId) throws Exception {
		return adminDAO.ok(contentId);
	}

	@Override
	public int fail(int contentId) throws Exception {
		return adminDAO.fail(contentId);
	}

	@Override
	public List<Contents> okList() throws Exception {
		return adminDAO.okList();
	}

	@Override
	public List<Contents> failList() throws Exception {
		return adminDAO.failList();
	}

	@Override
	public List<Map<String, Object>> userList() throws Exception {
		return adminDAO.userList();
	}

	@Override
	public String getWriterName(int writerId) throws Exception {
		return adminDAO.getWriterName(writerId);
	}
	
}
