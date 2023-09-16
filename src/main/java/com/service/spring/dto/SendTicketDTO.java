package com.service.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SendTicketDTO {
	private int sendUserId;
	private int receiveUserId;
	private int ticketId;
}
