package com.service.spring.vo;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	private int imageId;
	private String imageUrl;
	private String imageName;
	
	private int contentId; 
}
