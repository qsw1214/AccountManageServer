package com.accountmanage.service.bills.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.dao.bills.IBusinessUserBillsDAO;
import com.accountmanage.pojo.bills.BusinessUserBills;
import com.accountmanage.service.bills.IBusinessUserBillsService;

@Service("businessUserBills")
public class BusinessUserBillsServiceImpl implements IBusinessUserBillsService {
	
	@Resource
	private IBusinessUserBillsDAO businessUserBillsDAO;

	
	
	
}
