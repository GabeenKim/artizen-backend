package com.service.spring.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.ReviewsDAO;
import com.service.spring.service.ReviewsService;
import com.service.spring.vo.Reviews;

@Service
public class ReviewsServiceImpl implements ReviewsService{

	@Autowired
	private ReviewsDAO reviewsDAO;
	
	@Override
	public int addReview(int userId, int contentId, String review, String score) {
		return reviewsDAO.addReview(userId, contentId, review, score);
	}

	@Override
	public List<Reviews> showReview(int writerId) {
		return reviewsDAO.showReview(writerId);
	}
	
    @Override
    public HashMap<String, Object> showContentReview(int contentId) {
        HashMap<String, Object> map = new HashMap();
        map.put("reviewInfo", reviewsDAO.showContentReviewAvg(contentId));
        map.put("reviews", reviewsDAO.showContentReview(contentId));
        return map;
    }
}
