package com.accountmanage.service.bills.impl;

import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.service.bills.IBillsHandleService;
import com.accountmanage.service.bills.IBillsOperationService;
import com.accountmanage.util.BusinessUserLockManager;
import com.accountmanage.util.UserLockManager;
import com.accountmanage.web.bills.util.parambean.BUserParam;
import com.accountmanage.web.bills.util.parambean.CUserParam;
import com.accountmanage.web.bills.util.parambean.GiroParam;
import com.accountmanage.web.bills.util.parambean.InsideGiroParam;

@Service("billsHandleService")
public class BillsHandleServiceImpl implements IBillsHandleService{
	
	@Resource
	private IBillsOperationService billsOperationService;

	/**
	 * 处理商户账务处理
	 * @throws Exception 
	 */
	@Override
	public void doBuserBillsHandle(BUserParam buserParam) throws Exception {
//		获取用户锁
		BusinessUserLockManager businessUserLockManager = BusinessUserLockManager.getBusinessUserLockManager();
		Lock buserLock = businessUserLockManager.getBusinessUserLock(buserParam.getBuserId());
		buserLock.lock();
		try{
			this.billsOperationService.operateBuserBill(buserParam);
			
		}finally{
			buserLock.unlock();
		}
		
	}

	/**
	 * 处理用户账务处理
	 * @throws Exception 
	 */
	@Override
	public void doCUserBillsHandle(CUserParam cuserParam) throws Exception {
//		获取用户锁
		UserLockManager userLockManager = UserLockManager.getUserLockManager();
		Lock userLock = userLockManager.getUserLock(cuserParam.getUserId());
		userLock.lock();
		try{
			this.billsOperationService.operateCuserBill(cuserParam);
		}finally{
			userLock.unlock();
		}
	}

	/**
	 * 处理额度转账账务处理
	 * @throws Exception 
	 */
	@Override
	public void doAmountGiroHandle(GiroParam giroParam) throws Exception {
        //获取用户锁
		UserLockManager userLockManager = UserLockManager.getUserLockManager();
		Lock cuserLock = userLockManager.getUserLock(giroParam.getCuserParam().getUserId());
		
		BusinessUserLockManager businessUserLockManager = BusinessUserLockManager.getBusinessUserLockManager();
		Lock buserLock = businessUserLockManager.getBusinessUserLock(giroParam.getBuserParam().getBuserId());
		
		buserLock.lock();
		cuserLock.lock();

		try{
			this.billsOperationService.giroAmount(giroParam);
		}finally{
			cuserLock.unlock();
			buserLock.unlock();
		}
		
	}

	/**
	 * 处理B类用户与C类用户额度账户转账业务处理
	 * @throws Exception 
	 */
	@Override
	public void doinsideGiroUserAmountHandle(InsideGiroParam insideGiroParam) throws Exception {
//		获取用户锁
		UserLockManager userLockManager = UserLockManager.getUserLockManager();
		Lock cuserLock = userLockManager.getUserLock(insideGiroParam.getCuserParam().getUserId());
		
		Lock buserLock = userLockManager.getUserLock(insideGiroParam.getInsideBuserParam().getBuserId());
		
		buserLock.lock();
		cuserLock.lock();
		try{
			long starttime1 = System.currentTimeMillis();
			this.billsOperationService.insideGiroUserAmount(insideGiroParam);
			long endTime1 = System.currentTimeMillis();
			System.out.println("处理帐单时间:"+(endTime1-starttime1));
		}finally{
			cuserLock.unlock();
			buserLock.unlock();
		}
		
	}

	
}
