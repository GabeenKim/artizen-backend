package com.service.spring.dto;

import java.sql.Date;

import com.service.spring.vo.FundingContents;
import com.service.spring.vo.SupportContents;

public class ContentsRequestDTO {
	int contentSum;
	String contentName;
	int target;
	String category;
	Date startDay;
	Date endDay;
	int likes;
	int isAccepted;
	int writerId;
	SupportContents supportContents;
	FundingContents fudingContents;
	   
}
