package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import javax.annotation.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.service.spring.dao.ContentsDAO;
import com.service.spring.vo.Contents;
import com.service.spring.vo.FundingContents;
import com.service.spring.vo.SupportContents;

@SpringBootTest
@Transactional
@Commit
class ContentsTest1 {
	
    @Autowired
    private ContentsDAO contentsDAO;
    //private SqlSession sqlSession;
    
    @Test
    public void unitTest() throws Exception{
           

       //3. 쿼리문 실행
//    	String sDay = "2023-01-09" , eDay = "2023-11-30";
//
//        java.sql.Date startDay = java.sql.Date.valueOf(sDay);
//        java.sql.Date endDay = java.sql.Date.valueOf(eDay);
//        
//    	Contents contents = new Contents(11,0,"엘리멘탈",500000,"movie",startDay, endDay, 0,1,23,null,null,null, null,null,null);
// 
    	FundingContents fundingContents = new FundingContents(5,"디테일이다.",2000,5000000,"영화 성공 기원 ",200,26);
        SupportContents supportContents = new SupportContents(6, "이거시  detail", "이게 teamDetail", "무계획", 25);
//
//
//        System.out.println("========1. addContents ==============");
//        int result = contentsDAO.addContents(contents);
//        System.out.println(result+"개의 펀딩 콘탠츠 생성 성공.");



//        System.out.println("========addSupportContents ==============");
//
//        int result = contentsDAO.addSupportContents(supportContents);
//        System.out.println(result+"개의 펀딩 콘탠츠 생성 성공.");

//
//       System.out.println("========addfundingContents ==============");
//
//        int result1 = contentsDAO.addFundingContents(fundingContents);
//        System.out.println(result1+"개의 펀딩 콘탠츠 생성 성공.");


    
//        System.out.println("========updateContents ==============");
//
//        int result = session.update("updateContents",contents);
//        System.out.println(result+"개의 콘탠츠 수정 성공.");
//        //session.commit();
//
//        System.out.println("========updateSupportContents ==============");
//
//        int result2 = session.update("updateSupportContents",supportContents);
//        System.out.println(result2+"개의 콘탠츠 수정 성공.");
//        session.commit();

//        System.out.println("========updateFundingContents ==============");
//
//        int result = session.update("updateFundingContents",fundingContents);
//        System.out.println(result+"개의 콘탠츠 수정 성공.");
//        session.commit();

////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("========deleteContents ==============");
//
//        int result = session.delete("deleteContents",contents);
//        System.out.println(result+"개의 콘탠츠 삭제 성공.");
//        session.commit();
//////////////////////////////////////////////////////////////////////////////////////////


//null 값 나옴 
        System.out.println("========1. showAllContents ==============");
        List<Contents> list1 = contentsDAO.showAllContents();
        for(Contents li : list1) {
            System.out.println(li);
        }

        System.out.println("======== findContentsByName ==============");
        Contents list2 = contentsDAO.findContentsByName("오펜하이머");
        System.out.println(list2);
        


/////////////////////////////////////////////////////////////////////////

        System.out.println("========1. showSpportContnetsDetail ==============");
        Contents list3 = contentsDAO.showSupportContentsDetail(22);
        System.out.println(list3);

        System.out.println();
        System.out.println("========1. showFundingContentsDetail ==============");
        Contents list4 = contentsDAO.showFundingContentsDetail(23);
        System.out.println(list4);

        
        


    	
       System.out.println("========1. findContentsByCreator==============");
       Contents content = new Contents();
       
       List<Contents> contents1 = contentsDAO.findContentsByCreator("John Doe");
       for(Contents c : contents1) {
    	   System.out.println(c);
       }
    	  
       
       System.out.println("========2. showMyContents==============");
       List<Contents> contents2 = contentsDAO.showMyContents(1);
       for(Contents c : contents2) {
    	   System.out.println(c);
       }
       
       System.out.println("========3. showAdminContents==============");
       List<Contents> contents3 = contentsDAO.showAdminContents(0);
       for(Contents c : contents3) {
    	   System.out.println(c);
       }
       
       System.out.println("========4. showNotableContents==============");
       List<Contents> contents4 = contentsDAO.showNotableContents();
       for(Contents c : contents4) {
    	   System.out.println(c);
       }
       
       System.out.println("========5. showContentsRank==============");
       List<Contents> contents5 = contentsDAO.showContentsRank();
       for(Contents c : contents5) {
    	   System.out.println(c);
       }
       
       

    }
    

}
