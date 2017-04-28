package com.accountmanage.service.bills.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.dao.bills.IWeChatUserInfoDAO;
import com.accountmanage.service.bills.IWeChatUserInfoService;

@Service("weChatUserInfo")
public class WeChatUserInfoServiceImpl implements IWeChatUserInfoService {

	@Resource
	private IWeChatUserInfoDAO weChatUserInfoDAO;
}
