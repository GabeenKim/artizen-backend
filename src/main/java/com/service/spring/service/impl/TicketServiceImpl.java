package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.TicketDAO;
import com.service.spring.service.TicketService;
import com.service.spring.vo.Ticket;
import com.service.spring.vo.User;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketDAO ticketDAO; 
	
	@Override
	public List<Ticket> showMyTickets(User user) {
		return ticketDAO.showMyTickets(user);
	}

	@Override
	public void sendTicket(int sendUserId, int receiveUserId, int ticketId) {
		ticketDAO.sendTicket(sendUserId, receiveUserId, ticketId);
	}

}
