package com.accountmanage.dao.bills;

import java.math.BigDecimal;

import com.accountmanage.pojo.bills.UserInfo;

public interface IUserInfoDAO {
	
	/**
	 * 根据用户ID获取用户信息
	 * @param userId
	 * @return
	 */
	public UserInfo getById(String userId);
	
	/**
	 * 根据用户ID获取用户额度
	 * @param userId
	 * @return
	 */
	public BigDecimal getAmountById(String userId);
	
	/**
	 * 修改用户信息
	 * @param userInfo
	 */
	public void updateUser(UserInfo userInfo);

}
