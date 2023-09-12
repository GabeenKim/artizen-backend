package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.dto.ContentIdRequestDTO;
import com.service.spring.service.ContentsService;
import com.service.spring.vo.Contents;

@RestController
public class ContentsController {
	@Autowired
	private ContentsService contentsService;
	
	@PostMapping("/poster/addContents")
	public int addContents(@RequestBody Contents contents) throws Exception{
		return contentsService.addContents(contents);
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
	
	@GetMapping("/community/showContentsRank")
	public ResponseEntity showContentsRank() {
	    try {
	        List<Contents> selected = contentsService.showContentsRank();
	        
	        return new ResponseEntity(selected,HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	}

	
	//합치기
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

	
	

}
