package com.accountmanage.service.system;

import java.util.Map;

import base.cn.web.mybatis.util.PageInfo;

import com.accountmanage.pojo.system.LogInfo;


public interface ILogInfoService {
	
	public PageInfo<LogInfo> getPageListByCondition(
			Map<String, String> hashMap);
	
	public void saveLogInfo(LogInfo logInfo);
	
	public void updateLogInfo(LogInfo logInfo);
	
	public LogInfo getLogById(String id);
	
}
