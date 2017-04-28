package com.accountmanage.service.bills.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.dao.bills.IUserInfoDAO;
import com.accountmanage.pojo.bills.UserInfo;
import com.accountmanage.service.bills.IUserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService{
	
	@Resource
	private IUserInfoDAO userInfoDAO;

	

}
