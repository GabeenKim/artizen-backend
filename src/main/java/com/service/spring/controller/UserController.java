package com.service.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
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

import com.service.spring.dto.RegisterDTO;
import com.service.spring.service.UserService;
import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;
import com.service.spring.vo.Writer;

@CrossOrigin(origins =  "*",allowedHeaders = "*" )
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/account/login")
	public ResponseEntity login(@RequestBody UserInfo userInfo) {
//		System.out.println(userInfo);

		try{
			UserInfo loginUser = userService.login(userInfo);
			int identity = userService.showIdentity(loginUser.getInfoId());
			int id = 0;
			if(identity == 1) { //유저
				System.out.println("hihi");
				id = userService.getUserId(loginUser.getInfoId());
				User userResult = new User();
				userResult.setUserInfo(loginUser);
				userResult.setUserId(id);
				return new ResponseEntity(userResult, HttpStatus.OK);
			}else if(identity == 2) { //작가
				id = userService.getWriterId(loginUser.getInfoId());
				Writer writerResult = new Writer();
				writerResult.setUserInfo(loginUser);
				writerResult.setWriterId(id);
				return new ResponseEntity(writerResult, HttpStatus.OK);
			}else {
				//관리자
				return new ResponseEntity(id, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/account/registerUser")
	public ResponseEntity register(@RequestBody RegisterDTO registerDTO) {
		try{
			UserInfo userInfo = new UserInfo();
			userInfo.setEmail(registerDTO.getEmail());
			userInfo.setName(registerDTO.getName());
			userInfo.setPassword(registerDTO.getPassword());
			userInfo.setNickname(registerDTO.getNickname());

			if(registerDTO.getIdentity()==1) { //유저
				User loginUser = userService.registerUser(userInfo);
				return new ResponseEntity(loginUser, HttpStatus.OK);
			} else if(registerDTO.getIdentity()==2) { //작가
				Writer loginWriter = userService.registerWriter(userInfo);
				return new ResponseEntity(loginWriter, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/account/showUser/{infoId}")
	public ResponseEntity showUser(@PathVariable int infoId) {
		try {
//			System.out.println(infoId);
			int identity = userService.showIdentity(infoId);
//			System.out.println(identity);
			if(identity==1) { //유저
				User userReturn = userService.showUser(infoId);
				return new ResponseEntity(userReturn, HttpStatus.OK);
			} else if(identity==2) { //작가
				Writer writerReturn = userService.showWriter(infoId);
				return new ResponseEntity(writerReturn, HttpStatus.OK);
			}
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PatchMapping("/account/updateUser")
	public ResponseEntity update(@RequestBody UserInfo userInfo) {
		try {
			UserInfo userReturn = userService.updateUser(userInfo);
			if(userReturn != null) {
				return new ResponseEntity(userReturn, HttpStatus.OK);
			}else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PatchMapping("/account/updateUserNickname")
	public ResponseEntity updateNickname(@RequestBody UserInfo userInfo) {
		try {
			UserInfo userReturn = userService.updateNickname(userInfo);
			if(userReturn != null) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("nickname", userReturn.getNickname());
				return new ResponseEntity(result, HttpStatus.OK);
			}else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/account/addAccount")
	public ResponseEntity addAccount(@RequestBody HashMap<String, Object> param) {
		try {
			int result = userService.addAccount(param);
			if(result != 0) {
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PatchMapping("/account/updateAccount")
	public ResponseEntity updateAccount(@RequestBody HashMap<String, Object> param) {
		try {
			int result = userService.updateAccount(param);
			if(result != 0) {
				return new ResponseEntity( HttpStatus.OK);
			}else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/account/deleteAccount/{infoId}")
	public ResponseEntity deleteAccount(@PathVariable int infoId) {
		try {
			int result = userService.deleteAccount(infoId);
			if(result != 0) {
				return new ResponseEntity(HttpStatus.OK);
			}else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/account/isExist/{email}")
	public ResponseEntity isExist(@PathVariable String email) {
		try {
//			System.out.println(email);
			String result = userService.isExist(email);
			if(result == null) {
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
//			System.out.println(e);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/account/registerCharacter")
	public int registerCharacter(@RequestBody  HashMap<String, Object> request) {
	    int userId = (int) request.get("userId");
	    String character = (String) request.get("character");
	    
	    System.out.println(userId);
	    System.out.println(character);
	    
		HashMap<String, Object> map  = new HashMap<String, Object>();
		map.put("userId",userId);
		map.put("character",character);
		System.out.println(map);
		return userService.registerCharacter(map);
	}
	
	@GetMapping("/account/getWriterRanking")
	public ResponseEntity getWriterRanking() {
		try {
			List<HashMap<String, Object>> result = userService.getWriterRanking();
			return new ResponseEntity(result, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/account/getWriterInfo/{writerId}")
	public ResponseEntity getWriterInfo(@PathVariable int writerId) {
		System.out.println(writerId);
		try {
			HashMap<String, Object> result = userService.getWriterInfo(writerId);
			System.out.println(result);
			return new ResponseEntity(result, HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
