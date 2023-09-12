package com.service.spring.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupportContents {
	private int scId;
	private String detail;
	private String teamDetail;
	private String planDetail;
	
	private int contentId;

//	public SupportContents(int scId, String detail, String teamDetail, String planDetail, int contentId) {
//		super();
//		this.scId = scId;
//		this.detail = detail;
//		this.teamDetail = teamDetail;
//		this.planDetail = planDetail;
//		this.contentId = contentId;
//	}
	
	
}
