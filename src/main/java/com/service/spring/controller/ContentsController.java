package com.service.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.service.ContentsService;
import com.service.spring.vo.Contents;
import com.service.spring.vo.Support;
import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;
import com.service.spring.service.SupportService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContentsController {
	@Autowired
	private ContentsService contentsService;
	@Autowired
	private SupportService supportService;


	
	@GetMapping("/poster/showNotableContents")
	public ResponseEntity showNotableContents() {
		try {
			List<Contents> selected = contentsService.showNotableContents();
			
			return new ResponseEntity(selected,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/poster/showEndedContents")
	public ResponseEntity showEndedContents() {
		try {
			List<Contents> selected = contentsService.showEndedContents();
			
			return new ResponseEntity(selected,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/poster/showAllContents")
	public ResponseEntity showAllContents() {
		try {
			List<Contents> selected = contentsService.showAllContents();

			return new ResponseEntity(selected,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/poster/showAllSupportContents")
	public ResponseEntity showAllSupportContents() {
		try {
			List<Contents> selected = contentsService.showAllSupportContents();
			
			return new ResponseEntity(selected,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/poster/showAllFundingContents")
	public ResponseEntity showAllFundingContents() {
		try {
			List<Contents> selected = contentsService.showAllFundingContents();
			
			return new ResponseEntity(selected,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/poster/showMyContents")
	public ResponseEntity showMyContents(int userId) {
		try {
			//인자값으로 writerId 넘겨줘야 함. 
			List<Contents> selected = contentsService.showMyContents(userId);

			return new ResponseEntity(selected,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/community/showContentsRank")
	public ResponseEntity showContentsRank() {
		try {
			List<Contents> selected = contentsService.showContentsRank();
			
			return new ResponseEntity(selected,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/community/showSupportRank")
	public ResponseEntity showSupportRank() {
		 try {
			 List<Support> selected = supportService.showSupportRank();
		       System.out.println(selected);
		        return new ResponseEntity(selected,HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
	}
}
