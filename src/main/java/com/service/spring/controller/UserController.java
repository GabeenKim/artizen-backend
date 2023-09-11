package com.service.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.service.UserService;
import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;
import com.service.spring.vo.Writer;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody UserInfo userInfo) {
		try{
			UserInfo loginUser = userService.login(userInfo);
			return new ResponseEntity(loginUser, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/register/user")
	public ResponseEntity registerUser(@RequestBody UserInfo userInfo) {
		try{
			User loginUser = userService.registerUser(userInfo);
			return new ResponseEntity(loginUser, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/register/writer")
	public ResponseEntity registerWriter(@RequestBody UserInfo userInfo) {
		try{
			Writer loginWriter = userService.registerWriter(userInfo);
			return new ResponseEntity(loginWriter, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}
