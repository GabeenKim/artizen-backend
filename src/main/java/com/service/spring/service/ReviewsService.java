package com.service.spring.service;

import java.util.HashMap;
import java.util.List;

import com.service.spring.vo.Reviews;

public interface ReviewsService {
	int addReview(int userId, int contentId, String review, String score); //P14.리뷰작성
	List<Reviews> showReview(int writerId); //P15.작가 리뷰 목록
    HashMap<String, Object> showContentReview(int contentId); //컨텐츠 별 리뷰 목록
}
