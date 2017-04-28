package com.accountmanage.service.bills;

import com.accountmanage.web.bills.util.parambean.BUserParam;
import com.accountmanage.web.bills.util.parambean.CUserParam;
import com.accountmanage.web.bills.util.parambean.GiroParam;
import com.accountmanage.web.bills.util.parambean.InsideGiroParam;

public interface IBillsOperationService {

	/**
	 * 平台账单处理实现
	 * @param buserParam
	 * @throws Exception 
	 */
	public void operateBuserBill(BUserParam buserParam) throws Exception;
	
	/**
	 * 用户账单处理实现
	 * @param cuserParam
	 * @throws Exception 
	 */
	public void operateCuserBill(CUserParam cuserParam) throws Exception;
	
	
	/**
	 * 用户额度与平台转账账单处理实现
	 * @param giroParam
	 */
	public void giroAmount(GiroParam giroParam)throws Exception;
	
	/**
	 * C端用户与B端用户转账处理实现
	 */
	public void insideGiroUserAmount(InsideGiroParam insideGiroParam)throws Exception;
	
}
