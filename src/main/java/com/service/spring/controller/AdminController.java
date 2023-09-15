package com.service.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.dao.AdminDAO;
import com.service.spring.service.AdminService;
import com.service.spring.vo.Contents;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/okList")
	public ResponseEntity okList() throws Exception{
		try {
			List<Contents> contents = adminService.okList();
			return new ResponseEntity(contents, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/failList")
	public ResponseEntity failList() throws Exception{
		try {
			List<Contents> contents = adminService.failList();
			return new ResponseEntity(contents, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/checkList")
	public ResponseEntity checkList() throws Exception{
		try {
			List<Contents> contents = adminService.checkList();
			return new ResponseEntity(contents, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/ok/{contentId}")
	public ResponseEntity ok(@PathVariable int contentId) throws Exception{
		try {
			adminService.ok(contentId);
			return new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/fail/{contentId}")
	public ResponseEntity fail(@PathVariable int contentId) throws Exception{
		try {
			adminService.fail(contentId);
			return new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/userList")
	public ResponseEntity userList() throws Exception{
		try {
			List<Map<String, Object>> users = adminService.userList();
			return new ResponseEntity(users, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}
