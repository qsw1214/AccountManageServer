package com.accountmanage.service.bills;

import com.accountmanage.web.bills.util.parambean.BUserParam;
import com.accountmanage.web.bills.util.parambean.CUserParam;
import com.accountmanage.web.bills.util.parambean.GiroParam;
import com.accountmanage.web.bills.util.parambean.InsideGiroParam;

public interface IBillsHandleService {

	/**
	 * 商户账单处理（存入或支出）
	 * @throws Exception 
	 */
	public void doBuserBillsHandle(BUserParam buserParam) throws Exception;
	
	
	/**
	 * 用户账单处理（存入或支出）
	 * @throws Exception 
	 */
	public void doCUserBillsHandle(CUserParam cuserParam) throws Exception;
	
	/**
	 * 额度转账处理（用户转出，商户存入  或 商户转出，用户存入）
	 * @throws Exception 
	 */
	public void doAmountGiroHandle(GiroParam giroParam) throws Exception;
	
	
	/**
	 * 商户代金券与用户额度转账（商户代金券额度转出，用户额度转入 或 用户额度转出，商户代金券额度转入）
	 * @throws Exception 
	 */
	public void doinsideGiroUserAmountHandle(InsideGiroParam insideGiroParam) throws Exception;
	
	
}
