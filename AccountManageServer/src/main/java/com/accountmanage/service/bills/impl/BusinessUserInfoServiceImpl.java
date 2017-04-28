package com.accountmanage.service.bills.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.dao.bills.IBusinessUserInfoDAO;
import com.accountmanage.pojo.bills.BusinessUserInfo;
import com.accountmanage.service.bills.IBusinessUserInfoService;

@Service("businessUserService")
public class BusinessUserInfoServiceImpl implements IBusinessUserInfoService{
	
	@Resource
	private IBusinessUserInfoDAO businessUserInfoDAO;

}
