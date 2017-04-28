package com.accountmanage.dao.bills;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import base.cn.web.mybatis.util.PageInfo;

import com.accountmanage.pojo.bills.UserBills;


public interface IUserBillsDAO {
	
	/**
	 * 根据用户ID、账单单号、账务类型判断是否已经存在该账务
	 * @param userId
	 * @param operateSn
	 * @param billsFlag
	 * @return
	 */
	public String validateRepeatBill(String userId,String operateSn,String billsFlag);
	
	

	/**
	 * 添加用户账单信息
	 * @param userBills
	 */
	public void insertUserBills(UserBills userBills);
}
