package com.accountmanage.dao.bills;

import com.accountmanage.pojo.bills.BusinessUserBills;


public interface IBusinessUserBillsDAO {

	/**
	 * 商户账单信息插入
	 * @param buserBills
	 */
	public void insertBusinessUserBills(BusinessUserBills buserBills);
	
	/**
	 * 根据商户ID、账单单号、账务类型判断是否存在该账务
	 * @param buserId
	 * @param operateSn
	 * @param billsFlag
	 * @return
	 */
	public String validateRepeatBill(String buserId,String operateSn,String billsFlag);
	
}
