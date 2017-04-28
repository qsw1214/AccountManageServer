package com.accountmanage.service.bills.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import base.cn.web.mybatis.plugin.PageInterceptor;
import base.cn.web.mybatis.util.PageInfo;

import com.accountmanage.dao.bills.IUserBillsDAO;
import com.accountmanage.pojo.bills.UserBills;
import com.accountmanage.service.bills.IUserBillsService;

@Service("userBillsService")
public class UserBillsServiceImpl implements IUserBillsService {

	@Resource
	private IUserBillsDAO userBillsDAO;

	

}
