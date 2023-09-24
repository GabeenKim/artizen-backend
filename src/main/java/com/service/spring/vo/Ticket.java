package com.service.spring.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	private int ticketId;
	
	private int userId;
	private int contentId;
	
	public Ticket(int userId, int contentId) {
		this.userId = userId;
		this.contentId = contentId;
	}
}
