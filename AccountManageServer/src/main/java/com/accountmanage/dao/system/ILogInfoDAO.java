package com.accountmanage.dao.system;

import java.util.List;

import com.accountmanage.pojo.system.LogInfo;

public interface ILogInfoDAO {
	
	public List<LogInfo> getLogInfoList();
	
	public int insert(LogInfo logInfo);
	
	public int update(LogInfo logInfo);
	
	public LogInfo getLogById(String id);

}
