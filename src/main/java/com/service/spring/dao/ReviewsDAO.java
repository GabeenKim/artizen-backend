package com.service.spring.dao;

import java.util.HashMap;
import java.util.List;

import com.service.spring.vo.Reviews;

public interface ReviewsDAO {
	int addReview(int userId, int contentId, String review, String score); //P14.리뷰작성
	List<Reviews> showReview(int writerId); //P15.작가 리뷰 목록
    List<HashMap<String, Object>> showContentReview(int contentId); //콘텐츠별 리뷰 목록(리뷰들)
    HashMap<String, Object> showContentReviewAvg(int contentId); //콘텐츠별 리뷰 목록(평균점수+제목)
}	
