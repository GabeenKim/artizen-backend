package com.service.spring.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int userId;
	private int identity;
	private String character;
	private String interests;   //List 할지말지
	
	private UserInfo userInfo;
	private Support support;
	private Reviews reviews;
	private Ticket ticket;
}
