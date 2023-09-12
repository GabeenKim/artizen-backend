package com.service.spring.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundingContents {
	private int fundingId;
	private String detail;
	private int transaction;  // 객단가 = 순수익 = 티켓값 - 제작비                                          
	private int productionCost;   // 제작비
	private String purpose;
	private int minInvest;   //최소 투자 금액
	
	private int contentId;

	@Override
	public String toString() {
		return "FundingContents [fundingId=" + fundingId + ", detail=" + detail + ", transaction=" + transaction
				+ ", productionCost=" + productionCost + ", purpose=" + purpose + ", minInvest=" + minInvest
				+ ", contentId=" + contentId + "]";
	}
	
}
