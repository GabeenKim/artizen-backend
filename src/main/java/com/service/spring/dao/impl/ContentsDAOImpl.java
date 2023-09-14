package com.service.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.ContentsDAO;
import com.service.spring.vo.Contents;
import com.service.spring.vo.FundingContents;
import com.service.spring.vo.SupportContents;

@Repository
public class ContentsDAOImpl implements ContentsDAO{
	
	@Autowired
	private SqlSession sqlSession;
	public static final String NS = "ContentsMapper.";
	
	@Override
	public int addContents(Contents contents) throws Exception {
		return sqlSession.insert(NS + "addContents", contents);
	}

	@Override
	public int updateContents(Contents contents) throws Exception {
		return sqlSession.update(NS + "updateContents", contents);
	}

	@Override
	public int deleteContents(int contentId) throws Exception {
		return sqlSession.delete(NS + "deleteContents", contentId);
	}

	@Override
	public List<Contents> showAllContents() throws Exception {
		return sqlSession.selectList(NS + "showAllContents");
	}


	@Override
	public List<Contents> findContentsByCreator(String name) throws Exception {
		return sqlSession.selectList(NS + "findContentsByCreator", name);
	}

	@Override
	public Contents findContentsByName(String contentName) throws Exception {
		return sqlSession.selectOne(NS + "findContentsByName" ,contentName);
	}

	@Override
	public List<Contents> showMyContents(int userId) throws Exception {
		return sqlSession.selectList(NS + "showMyContents", userId);
	}

	@Override
	public List<Contents> showAdminContents(int isAccepted) throws Exception {
		return sqlSession.selectList(NS + "showAdminContents", isAccepted);
	}

	@Override
	public List<Contents> showNotableContents() throws Exception {
		return sqlSession.selectList(NS + "showNotableContents");
	}

	@Override
	public List<Contents> showContentsRank() throws Exception {
		return sqlSession.selectList(NS + "showContentsRank" );
	}

	@Override
	public int addSupportContents(SupportContents supportContents) throws Exception {
		return sqlSession.insert(NS + "addSupportContents", supportContents );
	}

	@Override
	public int addFundingContents(FundingContents fundingContents) throws Exception {
		return sqlSession.insert(NS + "addFundingContents", fundingContents );
	}

	@Override
	public int updateSupportContents(SupportContents supportContents) throws Exception {
		return sqlSession.update(NS + "updateSupportContents", supportContents );
	}

	@Override
	public int updateFundingContents(FundingContents fundingContents) throws Exception {
		return sqlSession.update(NS + "updateFundingContents", fundingContents );
	}

	@Override
	public Contents showFundingContentsDetail(int fundingId) throws Exception {
		return sqlSession.selectOne(NS + "showFundingContentsDetail", fundingId );
	}

	@Override
	public Contents showSupportContentsDetail(int scId) throws Exception {
		return sqlSession.selectOne(NS + "showSupportContentsDetail", scId );
	}

	@Override
	public int addAdminContents(int contentId) throws Exception {
		return sqlSession.update(NS + "addAdminContents", contentId);
	}
	
	@Override
	public List<Contents> showAllSupportContents() throws Exception {
	    return sqlSession.selectList(NS + "showAllSupportContents");
	}

	@Override
	public List<Contents> showAllFundingContents() throws Exception {
	    return sqlSession.selectList(NS + "showAllFundingContents");
	}

	@Override
	public Contents findContentsById(int contentId) throws Exception {
		return sqlSession.selectOne(NS + "findContentsById", contentId);
	}


}
