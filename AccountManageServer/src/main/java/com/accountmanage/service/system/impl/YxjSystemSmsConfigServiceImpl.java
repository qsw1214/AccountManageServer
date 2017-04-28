package com.accountmanage.service.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.dao.system.IyxjSystemSmsConfigDAO;
import com.accountmanage.pojo.system.yxj_system_sms_config;
import com.accountmanage.service.system.IyxjSystemSmsConfigService;

@Service("yxjSystemSmsConfigService")
public class YxjSystemSmsConfigServiceImpl implements IyxjSystemSmsConfigService {

	@Resource
	private IyxjSystemSmsConfigDAO yxjSystemSmsConfigDAO;

	@Override
	public yxj_system_sms_config getSmsConfigByPointCode(String pointCode) {
		return yxjSystemSmsConfigDAO.getSysSmsConfigByPointCode(pointCode);
	}
	
}
