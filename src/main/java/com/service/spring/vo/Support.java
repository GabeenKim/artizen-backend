package com.service.spring.vo;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Support {
	private int supportId;
	private int price;
	
	private int userId;
	private int contentId;

}
