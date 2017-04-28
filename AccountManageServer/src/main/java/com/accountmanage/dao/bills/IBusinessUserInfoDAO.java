package com.accountmanage.dao.bills;

import java.math.BigDecimal;
import java.util.Map;

import com.accountmanage.pojo.bills.BusinessUserInfo;

public interface IBusinessUserInfoDAO{
	
	/**
	 * 根据商户ID查询商户代金券余额
	 */
	public Map<String, BigDecimal> selectAmount(String buserId);
	
	/**
	 * 修改商户信息
	 */
	public void updateAmount(BusinessUserInfo businessUserInfo);
   
}