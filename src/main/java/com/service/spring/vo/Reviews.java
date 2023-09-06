package com.service.spring.vo;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
	private int reviewId;
	private String review;
	private int score;
	
	private int userId;
	private int contentId;
}
