package com.service.spring.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
	private int infoId;
	private String name;
	private String nickname;
	private String password;
	private String email;
	private String accounts;
	private String bank;
	private int balance;
	
}
