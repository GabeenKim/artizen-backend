package com.service.spring.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.ContentsDAO;
import com.service.spring.dto.ContentIdRequestDTO;
import com.service.spring.service.ContentsService;
import com.service.spring.vo.Contents;
import com.service.spring.vo.FundingContents;
import com.service.spring.vo.SupportContents;

@Service
public class ContentsServiceImpl implements ContentsService{
	
	@Autowired
	private ContentsDAO contentsDAO;
	
	@Override
	public int addContents(Contents contents) throws Exception {
		contentsDAO.addContents(contents);
		int id = contentsDAO.findContentsByName(contents.getContentName()).getContentId();
		if(contents.getFundingContents()==null) {
			SupportContents sc = contents.getSupportContents();
			sc.setContentId(id);
			return contentsDAO.addSupportContents(sc);
		} else {
			FundingContents fc = contents.getFundingContents();
			fc.setContentId(id);
			return contentsDAO.addFundingContents(fc);
		}
	}

	@Override
	public int addAdminContents(int contentId) throws Exception {
		return contentsDAO.addAdminContents(contentId);    //isAccepted = 1 로 수정
	}

	@Override
	public int updateContents(Contents contents) throws Exception {
		contentsDAO.updateContents(contents);
		System.out.println(contents.getContentId());
		if(contents.getFundingContents()==null) {
			SupportContents sc = contents.getSupportContents();
			sc.setContentId(contents.getContentId());
			return contentsDAO.updateSupportContents(sc);
		} else {
			FundingContents fc = contents.getFundingContents();
			fc.setContentId(contents.getContentId());
			return contentsDAO.updateFundingContents(fc);
		}
	}

	@Override
	public int deleteContents(int contentId) throws Exception {
		return contentsDAO.deleteContents(contentId);
	}

	@Override
	public List<Contents> showAllContents() throws Exception {
		return contentsDAO.showAllContents();
	}

	@Override
	public Contents showFundingContentsDetail(int fundingId) throws Exception {
		return contentsDAO.showFundingContentsDetail(fundingId);
	}

	@Override
	public Contents showSupportContentsDetail(int scId) throws Exception {
		return contentsDAO.showSupportContentsDetail(scId);
	}

	@Override
	public List<Contents> findContentsByCreator(String name) throws Exception {
		return contentsDAO.findContentsByCreator(name);
	}

	@Override
	public Contents findContentsByName(String contentName) throws Exception {
		return contentsDAO.findContentsByName(contentName);
	}

	@Override
	public List<Contents> showMyContents(int userId) throws Exception {
		return contentsDAO.showMyContents(userId);
	}

	@Override
	public List<Contents> showAdminContents(int isAccepted) throws Exception {
		return contentsDAO.showAdminContents(isAccepted);
	}

	@Override
	public List<Contents> showNotableContents() throws Exception {
		return contentsDAO.showNotableContents();
	}

	@Override
	public List<Contents> showContentsRank() throws Exception {
		return contentsDAO.showContentsRank();
	}

	
	@Override
    public List<Contents> showEndedContents() throws Exception {
        List<Contents> endedContents = new ArrayList<Contents>();
        List<Contents> list = showAllContents();
        java.util.Date currDate = Calendar.getInstance().getTime();

    for(Contents content : list) {
        if(currDate.after(content.getEndDay())) {
            endedContents.add(content);
        }
    }
    return endedContents;
}

	@Override
	public List<Contents> showCustomizedContents() throws Exception {
    // TODO Auto-generated method stub
    return null;
	}

	@Override
	public List<Contents> showAllSupportContents() throws Exception {
    return contentsDAO.showAllSupportContents();
	}

	@Override
	public List<Contents> showAllFundingContents() throws Exception {
		return contentsDAO.showAllFundingContents();
	}

}
