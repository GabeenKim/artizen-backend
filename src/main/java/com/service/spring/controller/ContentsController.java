package com.service.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.dto.ContentIdRequestDTO;
import com.service.spring.dto.MultipartDTO;
import com.service.spring.service.ContentsService;
import com.service.spring.service.ImageService;
import com.service.spring.vo.Contents;
import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;
import com.service.spring.vo.Writer;

@CrossOrigin(origins =  "*",allowedHeaders = "*" )
@RestController
public class ContentsController {
	@Autowired
	private ContentsService contentsService;
	
	@Autowired ImageService imageService;
	
	@PostMapping("/poster/addFundingContents")
	public int addFundingContents(@RequestBody MultipartDTO dto, HttpServletRequest request) throws Exception{
		return contentsService.addFundingContents(dto, request);
	}
	
	@PostMapping("/poster/addSupportContents")
	public int addSupportContents(@RequestBody MultipartDTO dto, HttpServletRequest request) throws Exception{
		return contentsService.addSupportContents(dto, request);
	}

	
	
	@PatchMapping("/poster/addAdminContents")
	public int addAdminContents(@RequestBody ContentIdRequestDTO req) throws Exception{
		return contentsService.addAdminContents(req.getContentId());
		
	}
	
	@PutMapping("/poster/updateContents")  
	public int updateContents(@RequestBody Contents contents) throws Exception{
		return contentsService.updateContents(contents);
	}
	
	@DeleteMapping("/poster/deleteContents/{contentId}")
	public int deleteContents(@PathVariable int contentId) throws Exception {
		return contentsService.deleteContents(contentId);
	}
	
	@GetMapping("/poster/showFundingContentsDetail/{contentId}")
	public Contents showFundingContentsDetail(@PathVariable int contentId) throws Exception {
		return contentsService.showFundingContentsDetail(contentId);

	}
	
	@GetMapping("/poster/showSupportContentsDetail/{contentId}")
	public Contents showSupportContentsDetail(@PathVariable int contentId) throws Exception {
		return contentsService.showSupportContentsDetail(contentId);
	}
	
	@GetMapping("/poster/findContentsByName/{contentName}")
	public Contents findContentsByName(@PathVariable String contentName) throws Exception {
		return contentsService.findContentsByName(contentName);
	}
	
	@GetMapping("/poster/findContentsByCreator/{name}")
	public List<Contents> findContentsByCreator(@PathVariable String name) throws Exception {
		return contentsService.findContentsByCreator(name);
	}
	

	@GetMapping("/poster/showAdminContents/{isAccepted}")
	public List<Contents> showAdminContents(@PathVariable int isAccepted) throws Exception {
		return contentsService.showAdminContents(isAccepted);
	}
	
	@GetMapping("/community/showContentsRank1")
	public ResponseEntity showContentsRank1() {
		
	    try {
	        List<Contents> selected = contentsService.showContentsRank();
			List<Contents> fundingSelected = new ArrayList<>();
			for(Contents c : selected) {
				int identity = contentsService.showContentIdentity(c.getContentId());
				if(identity == 1) { //funding
					fundingSelected.add(c);
				}
			}
				return new ResponseEntity(fundingSelected, HttpStatus.OK);
	    }catch (Exception e) {
		        return new ResponseEntity(HttpStatus.NO_CONTENT);
		    }
	}
	
	@GetMapping("/community/showContentsRank2")
	public ResponseEntity showContentsRank2() {
	    try {
	        List<Contents> selected = contentsService.showContentsRank();
	        List<Contents> supportSelected = new ArrayList<>();
	        for(Contents c : selected) {
	            int identity = contentsService.showContentIdentity(c.getContentId());
	   
	            if(identity == 2) { //funding
	                supportSelected.add(c);
	            }
	        }
	            return new ResponseEntity(supportSelected, HttpStatus.OK);
	    }catch (Exception e) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	        }
	}

	
	//합치기
	@GetMapping("/poster/showNotableContents1")
	public ResponseEntity showNotableContents1() {
		try{
			List<Contents> selected = contentsService.showNotableContents();
			List<Contents> fundingSelected = new ArrayList<>();
			for(Contents c : selected) {
				int identity = contentsService.showContentIdentity(c.getContentId());
			
				if(identity == 1) { //funding
					fundingSelected.add(c);
				}
			}
			return new ResponseEntity(fundingSelected, HttpStatus.OK);
			
		}  catch (Exception e) {
	        return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	}
	
	@GetMapping("/poster/showNotableContents2")
	public ResponseEntity showNotableContents2() {
		try{
			List<Contents> selected = contentsService.showNotableContents();
			List<Contents> supportSelected = new ArrayList<>();
			for(Contents c : selected) {
				int identity = contentsService.showContentIdentity(c.getContentId());
				int id = 0;
				if(identity == 2) { //support
					supportSelected.add(c);
				}
			}
			return new ResponseEntity(supportSelected, HttpStatus.OK);
			
		}  catch (Exception e) {
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

	@GetMapping("/poster/showMyContents1/{writerId}")
	public ResponseEntity showMyContents1(@PathVariable int writerId) {
	    try {
	        //인자값으로 writerId 넘겨줘야 함. 
	        List<Contents> selected = contentsService.showMyContents(writerId);
	        List<Contents> supportSelected = new ArrayList<>();
			for(Contents c : selected) {
				int identity = contentsService.showContentIdentity(c.getContentId());
				int id = 0;
				if(identity == 1) { //support
					supportSelected.add(c);
				}
			}
			return new ResponseEntity(supportSelected, HttpStatus.OK);
			
		}  catch (Exception e) {
	        return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	
	}
	
	@GetMapping("/poster/showMyContents2/{writerId}")
	public ResponseEntity showMyContents2(@PathVariable int writerId) {
	    try {
	        //인자값으로 writerId 넘겨줘야 함. 
	        List<Contents> selected = contentsService.showMyContents(writerId);
	        List<Contents> supportSelected = new ArrayList<>();
			for(Contents c : selected) {
				int identity = contentsService.showContentIdentity(c.getContentId());
				int id = 0;
				if(identity == 2) { //support
					supportSelected.add(c);
				}
			}
			return new ResponseEntity(supportSelected, HttpStatus.OK);
			
		}  catch (Exception e) {
	        return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	
	}

}