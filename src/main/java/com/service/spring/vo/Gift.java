package com.service.spring.vo;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gift {
	private int giftId;
	private int criterion;
	private String giftList;
	private int ticketCnt;
	
	private int contentId;
	
	
}
