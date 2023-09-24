package com.service.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartRequest;

import com.service.spring.dto.ImageRequestDTO;
import com.service.spring.dto.MultipartDTO;
import com.service.spring.service.ImageService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	
	@PostMapping("/image/upload")
    public Map<String, Object> imageUpload(ImageRequestDTO dto, HttpServletRequest request) throws Exception {

        Map<String, Object> responseData = new HashMap<>();
        System.out.println("hihi");
    try {
        System.out.println(dto.getUploadFile());
        String s3Url = imageService.imageUpload(dto, request);
        
        responseData.put("uploaded",true);
        responseData.put("url",s3Url);
        System.out.println(s3Url);

        return responseData;
    }catch(IOException e) {
        System.out.println(e.getMessage());
        responseData.put("uploaded",true);
        
        return responseData;
    }
}
}
