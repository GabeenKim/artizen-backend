package com.service.spring.vo;



import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Contents { 
    private int contentId;
    private int contentSum;   //모여진 금액
    private String contentName;
    private int target;    // 목표금액
    private String category;
    private Date startDay;
    private Date endDay;
    private int likes;
    private int isAccepted;
    private int writerId;

    private List<Image> image;
    private List<Support> support;
    private List<Reviews> review;
    private FundingContents fundingContents;
    private SupportContents supportContents;
    private List<Gift> gift;

    @Builder
    public Contents(int contentSum, String contentName, int target, String category, Date startDay, Date endDay, int likes, int isAccepted,
                    int writerId, List<Image> image, List<Gift> gift, FundingContents fundingContents, SupportContents supportContents,
                    List<Support> support, List<Reviews> review){
        this.contentSum = contentSum;
        this.contentName = contentName;
        this.target = target;
        this.category = category;
        this.startDay =startDay;
        this.isAccepted = isAccepted;
        this.endDay = endDay;
        this.likes = likes;
        this.writerId = writerId;
        this.image = image;
        this.gift = gift;
        this.fundingContents = fundingContents;
        this.supportContents = supportContents;
        this.support = support;
        this.review = review;

}
}
