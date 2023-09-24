package com.service.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.ReviewsDAO;
import com.service.spring.vo.Reviews;

@Repository
public class ReviewsDAOImpl implements ReviewsDAO{

	@Autowired
	private SqlSession sqlSession; 
	
	private static String NS = "sql.review.mapper.";
	
	@Override
	public int addReview(int userId, int contentId, String review, String score) {
		Map<String, Object> map = new HashMap();
		map.put("contentId",contentId);
		map.put("userId",userId);
		map.put("review",review);
		map.put("score",score);
		return sqlSession.insert(NS + "addReview",map);
	}

	@Override
	public List<Reviews> showReview(int writerId) {
		return sqlSession.selectList(NS + "showReview",writerId);
	}

	@Override
	public List<HashMap<String, Object>> showContentReview(int contentId) {
	    return sqlSession.selectList(NS + "showContentReview",contentId);
	}
	
	 @Override
	 public HashMap<String, Object> showContentReviewAvg(int contentId) {
	    return sqlSession.selectOne(NS + "showContentReviewAvg",contentId);
	 }
}
