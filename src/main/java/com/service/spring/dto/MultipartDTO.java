package com.service.spring.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.service.spring.vo.FundingContents;
import com.service.spring.vo.Gift;
import com.service.spring.vo.SupportContents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MultipartDTO {
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
    FundingContents fundingContents;
    List<Gift> gift;
    private String imageUrl; 
}

