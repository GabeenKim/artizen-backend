package com.service.spring.service;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.service.spring.aws.config.S3Config;
import com.service.spring.dto.MultipartDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

@Service
public class ImageService {
	
	@Autowired
    private S3Config s3Config;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private String localLocation = "C:\\Users\\Jo\\Desktop\\test-img";

    public String imageUpload(MultipartDTO dto, HttpServletRequest request) throws IOException {
    	
    	/* request 인자에서 이미지 파일을 뽑아냄 */
        MultipartFile file = dto.getUploadFile(); //key값 

        /* 뽑아낸 이미지 파일에서 이름 및 확장자 추출 */
        String fileName = file.getOriginalFilename(); //file명
        String ext = fileName.substring(fileName.indexOf(".")); //확장자

        /* 이미지 파일 이름 유일성을 위해 uuid 생성*/
        String uuidFileName = UUID.randomUUID() + ext;
        
        /* 서버환경에 저장할 경로 생성 */
        String localPath = request.getSession().getServletContext().getRealPath("/") + uuidFileName;

        /* 서버 환경에 이미지 파일을 저장 */
        File localFile = new File(localPath);
        file.transferTo(localFile);

        /* s3 저장 */
        s3Config.amazonS3Client().putObject(new PutObjectRequest(bucket, uuidFileName, localFile).withCannedAcl(CannedAccessControlList.PublicRead));
        String s3Url = s3Config.amazonS3Client().getUrl(bucket, uuidFileName).toString();

        localFile.delete();
        
        return s3Url;

    }
    

}