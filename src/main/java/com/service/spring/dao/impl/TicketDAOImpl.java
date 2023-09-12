package com.service.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.TicketDAO;
import com.service.spring.vo.Ticket;
import com.service.spring.vo.User;

@Repository
public class TicketDAOImpl implements TicketDAO {

	@Autowired 
	private SqlSession sqlSession;
	
	private static String NS = "sql.ticket.mapper.";
	
	@Override
	public List<Ticket> showMyTickets(User user) {
		return sqlSession.selectList(NS + "showMyTickets",user);
	}

	@Override
	public void sendTicket(int sendUserId, int receiveUserId, int ticketId) {
		Map<String, Integer> map = new HashMap();
		map.put("receiveUserId",receiveUserId);
		map.put("sendUserId",sendUserId);
		map.put("ticketId",ticketId);
		sqlSession.update(NS + "sendTicket",map);
	}

}
