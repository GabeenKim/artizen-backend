package com.service.spring.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.ContentsDAO;
import com.service.spring.dao.SupportDAO;
import com.service.spring.dao.UserDAO;
import com.service.spring.service.SupportService;
import com.service.spring.vo.Contents;
import com.service.spring.vo.Support;
import com.service.spring.vo.User;
import com.service.spring.vo.UserInfo;

@Service
public class SupportServiceImpl implements SupportService{
	
	@Autowired
	private SupportDAO supportDAO;
	@Autowired
	private ContentsDAO contentDAO;
	@Autowired
	private UserDAO userDAO;
	

	@Override
	public int addFunding(Support support) throws Exception{
		supportDAO.addFunding(support);
		int price = support.getPrice();
		int newPrice = contentDAO.findContentsById(support.getContentId()).getContentSum() + price;
		Contents content = contentDAO.findContentsById(support.getContentId());
		content.setContentSum(newPrice);
		return contentDAO.updateContents(content);
		
	}

	@Override
	public int deleteFunding(int supportId) throws Exception {
		Support support = supportDAO.showFundingDetail(supportId);
		int price = support.getPrice();
		int newPrice = contentDAO.findContentsById(support.getContentId()).getContentSum() - price;
		Contents content = contentDAO.findContentsById(support.getContentId());
		content.setContentSum(newPrice);
		supportDAO.deleteFunding(supportId);
		return contentDAO.updateContents(content);
	}

	@Override
	public Support showFundingDetail(int supportId) throws Exception{
		return supportDAO.showFundingDetail(supportId);
	}

	@Override
	public List<Map<String, Contents>> showFunding(int userId) throws Exception{
		return supportDAO.showFunding(userId);
	}

	@Override
	public List<User> showFundingUser(int contentId) throws Exception{
		List<Support> support = supportDAO.showFundingUser(contentId);
		List<User> users = new ArrayList<>();
		for(Support s : support) {
			int userId = s.getUserId();
			User user = userDAO.showUserById(userId);
			users.add(user);
		}
		return users;
	}

	@Override
	public int satisfied(int contentId) throws Exception {
		List<User> users = showFundingUser(contentId);
		List<Support> support = supportDAO.showFundingUser(contentId);
		Contents content = contentDAO.findContentsById(contentId);
		int profits = (int) Math.round((content.getContentSum() - content.getTarget()) + 3000 / content.getContentSum() * 100)  ;
		System.out.println(profits);
		for(User u : users) {
			for(Support s : support) {
				if(s.getUserId() == u.getUserId()) {
					int newPrice = (int) Math.round(s.getPrice() * profits);
					System.out.println(newPrice);
					u.getUserInfo().setBalance(newPrice);
					int infoId = u.getUserInfo().getInfoId();
					HashMap<String, Object> map = new HashMap<>();
					map.put("amount", (Integer)newPrice);
					map.put("infoId", (Integer) infoId);
					userDAO.updateAccount(map);
				}
			}
		}
		return profits;
	}

	@Override
    public int notSatisfied(int contentId) throws Exception {
        List<User> users = showFundingUser(contentId);
        List<Support> support = supportDAO.showFundingUser(contentId);
        Contents content = contentDAO.findContentsById(contentId);
        for(User u : users) {
            for(Support s : support) {
                if(s.getUserId() == u.getUserId()) {
                	int returnPrice = s.getPrice();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("amount", (Integer)returnPrice);
                    map.put("infoId",(Integer)u.getUserInfo().getInfoId());
                    userDAO.updateAccount(map);   //delete 할지말지 고민...
                }
            }
        }
        return content.getContentSum();
    }
	@Override
	public List<Support> showSupportRank() throws Exception {
		System.out.println(supportDAO.showSupportRank());
		System.out.println(supportDAO.showSupportRank());
		return supportDAO.showSupportRank();
	}

}
