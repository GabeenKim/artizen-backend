package com.service.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.service.SupportService;
import com.service.spring.service.TicketService;
import com.service.spring.vo.Contents;
import com.service.spring.vo.Support;
import com.service.spring.vo.Ticket;
import com.service.spring.vo.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/funding")
public class SupportController {
	
	@Autowired
	private SupportService supportService;
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/addFunding")  //supportId 주자..
	public int addFunding(@RequestBody Support support) throws Exception{
		int i = supportService.addFunding(support);
		ticketService.addTicket(new Ticket(support.getUserId(),support.getContentId()));
		return i;
	}
	
	@DeleteMapping("/deleteFunding/{supportId}")
	public int deleteFunding(@PathVariable int supportId) throws Exception{
		return supportService.deleteFunding(supportId);
		
	}
	
	@GetMapping("showFundingDetail/{supportId}")
	public Support showFundingDetail(@PathVariable int supportId) throws Exception{
		return supportService.showFundingDetail(supportId);
	}
	
	@GetMapping("showFundingUser/{contentId}")
	public List<User> showFundingUser(@PathVariable int contentId) throws Exception{
		return supportService.showFundingUser(contentId);
	}
	
	@PutMapping("/satisfied/{contentId}")
	public int satisfied(@PathVariable int contentId) throws Exception {
		return supportService.satisfied(contentId);
	}
	
	@PutMapping("/notSatisfied/{contentId}")
	public int notSatisfied(@PathVariable int contentId) throws Exception {
		return supportService.notSatisfied(contentId);
	}
	
	@GetMapping("/showSupportRank")
    public List<Support> showSupportRank() throws Exception{
        return supportService.showSupportRank();   
    }

	@GetMapping("/showFunding/{userId}")
	public List<Map<String, Contents>> showFunding(@PathVariable int userId) throws Exception{
		return supportService.showFunding(userId);
	}
	
	@GetMapping("/showEndedFunding/{userId}")
	public List<Contents> showEndedFunding(@PathVariable int userId) throws Exception{
		return supportService.showEndedFunding(userId);
	}
}

	


