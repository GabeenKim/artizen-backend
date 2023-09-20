package com.service.spring.dao;

import java.util.List;
import java.util.Map;

import com.service.spring.vo.Contents;

public interface AdminDAO {
	List<Contents> checkList() throws Exception;
	int ok(int contentId) throws Exception; 
	int fail(int contentId) throws Exception;
	List<Contents> okList() throws Exception;
	List<Contents> failList() throws Exception;
	List<Map<String,Object>> userList() throws Exception;
	String getWriterName(int writerId) throws Exception;
}
