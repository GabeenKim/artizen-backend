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
public class Writer {
	private int writerId;
	
	private UserInfo userInfo;

	private List<Contents> contents;
	
}
