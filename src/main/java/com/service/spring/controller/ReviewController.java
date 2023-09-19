package com.service.spring.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.dto.ReviewDTO;
import com.service.spring.service.ReviewsService;
import com.service.spring.vo.Contents;
import com.service.spring.vo.Reviews;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private ReviewsService reviewsService;
	
	
	/* [리뷰 작성] :: P14 */
	@PostMapping("/addReview")
	public ResponseEntity addReview(@RequestBody ReviewDTO req) {
		try {
			reviewsService.addReview(req.getUserId()
					, req.getContentId()
					, req.getReview()
					, req.getScore());
			
			return new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	/* [작가 리뷰 목록] :: P15*/
	@GetMapping("/showReview/{writerId}")
	public ResponseEntity showReview(@PathVariable int writerId) {
		try {
			List<Reviews> result = reviewsService.showReview(writerId);
			return new ResponseEntity(result, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	
}
