package com.accountmanage.service.bills.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import base.cn.exception.BaseException;
import base.cn.util.IdGenerator;
import base.cn.util.ObjectTools;

import com.accountmanage.dao.bills.IBusinessUserBillsDAO;
import com.accountmanage.dao.bills.IBusinessUserInfoDAO;
import com.accountmanage.dao.bills.IUserBillsDAO;
import com.accountmanage.dao.bills.IUserInfoDAO;
import com.accountmanage.pojo.bills.BusinessUserBills;
import com.accountmanage.pojo.bills.BusinessUserInfo;
import com.accountmanage.pojo.bills.UserBills;
import com.accountmanage.pojo.bills.UserInfo;
import com.accountmanage.service.bills.IBillsOperationService;
import com.accountmanage.web.bills.util.BillReturnEnum;
import com.accountmanage.web.bills.util.parambean.BUserParam;
import com.accountmanage.web.bills.util.parambean.CUserParam;
import com.accountmanage.web.bills.util.parambean.GiroParam;
import com.accountmanage.web.bills.util.parambean.InsideBUserParam;
import com.accountmanage.web.bills.util.parambean.InsideGiroParam;

@Service("billsOperationService")
public class BillsOperationServiceImpl implements IBillsOperationService{
	
	@Resource
	private IBusinessUserInfoDAO businessUserInfoDAO;
	
	@Resource
	private IUserInfoDAO userInfoDAO;
	
	@Resource 
	private IBusinessUserBillsDAO businessUserBillsDAO;
	
	@Resource
	private IUserBillsDAO userBillsDAO;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	/******************************************************************************************/
	
	/**
	 * 平台账务操作实现
	 */
	@Override
	public void operateBuserBill(BUserParam buserParam) throws Exception{
		
		this.makeBillsByBuserParam(buserParam);
	}

	/**
	 * 用户账务操作实现
	 * @throws Exception 
	 */
	@Override
	public void operateCuserBill(CUserParam cuserParam) throws Exception {
		
		this.makeCuserBillsByCuserParam(cuserParam);
	}
	
	/******************************************************************************************/

	/**
	 * 额度转账操作实现
	 * @throws Exception 
	 */
	@Override
	public void giroAmount(GiroParam giroParam) throws Exception {
		CUserParam cuserParam = giroParam.getCuserParam();
		BUserParam buserParam = giroParam.getBuserParam();
		String c_billsFlag = cuserParam.getBillsflag();
		String b_billsFlag = buserParam.getBillsflag();
		
		
		if("1".equals(c_billsFlag)){
			//用户做支出操作时，商户必须做存入操作
			if(!"0".equals(b_billsFlag)){
				BillReturnEnum.FAIL_91.changetMessage("账务类型参数错误");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
		}else if("0".equals(c_billsFlag)){
			//用户做存入操作时，商户必须做支出操作
			if(!"1".equals(b_billsFlag)){
				BillReturnEnum.FAIL_91.changetMessage("账务类型参数错误");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
		}else{
			BillReturnEnum.FAIL_91.changetMessage("账务类型参数错误");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		//账务处理
		this.makeBillsByGiroParam(giroParam);
	}
	
	/******************************************************************************************/

	/**
	 * C端用户与B端用户转账处理实现
	 * @throws Exception 
	 */
	@Override
	public void insideGiroUserAmount(InsideGiroParam insideGiroParam) throws Exception {
		CUserParam cuserParam = insideGiroParam.getCuserParam();
		InsideBUserParam insideBuserParam = insideGiroParam.getInsideBuserParam();
		String c_billsFlag = cuserParam.getBillsflag();
		String b_billsFlag = insideBuserParam.getBillsflag();
		
		if(cuserParam.getUserId().equals(insideBuserParam.getBuserId())){
			BillReturnEnum.FAIL_91.changetMessage("转账用户ID不能相同");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		if("1".equals(c_billsFlag)){
			//C类用户做支出操作时，B类用户必须做存入操作
			if(!"0".equals(b_billsFlag)){
				BillReturnEnum.FAIL_91.changetMessage("账务类型参数错误");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
			
		}else if("0".equals(c_billsFlag)){
			//C类用户做存入操作时，B类用户必须做支出操作
			if(!"1".equals(b_billsFlag)){
				BillReturnEnum.FAIL_91.changetMessage("账务类型参数错误");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
		}else{
			BillReturnEnum.FAIL_91.changetMessage("账务类型参数错误");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		//账务处理
		this.makeInsideTransferBillsByGiroParam(insideGiroParam);
	}
	
	
	
	
	
	/*######################################################################################*/
	
	/**
	 * 平台账户单独账务运作实现
	 * @param buserParam
	 * @return
	 */
	private void makeBillsByBuserParam(BUserParam buserParam){
		String buserId = buserParam.getBuserId();
		String billsFlag = buserParam.getBillsflag();
		String operateSn = buserParam.getOperatesn();
		BigDecimal operateMonye = buserParam.getOperatemoney();
		String operateDesc = buserParam.getOperatedesc();
		String remark = buserParam.getRemark();
		
		//验证是否重复交易
		String bbillId = this.businessUserBillsDAO.validateRepeatBill(buserId, operateSn, billsFlag);
		if(!ObjectTools.isNullByString(bbillId)){
			log.info("平台ID为: "+buserId+" 单号为："+operateSn+" 的交易出现重复请求,不做任何处理");
			return;
		}
		
		//查询平台余额
		Map<String, BigDecimal> amountMap = this.businessUserInfoDAO.selectAmount(buserId);
		
		BigDecimal amountBalance = amountMap.get("amount");
		BigDecimal couponBalance = amountMap.get("couponAmount");
		
		if(ObjectTools.isNullByObject(amountBalance)){
			log.info("平台ID为: "+buserId+" 的平台不存在！");
			throw new BaseException(BillReturnEnum.FAIL_21);
		}
		
		
		
		//计算平台余额
		if("0".equals(billsFlag)){
			amountBalance = amountBalance.add(operateMonye);
		}else if("1".equals(billsFlag)){
			amountBalance = amountBalance.subtract(operateMonye);
			if(amountBalance.doubleValue()<0){
				log.info("平台ID为: "+buserId+" 的平台余额不足！");
				throw new BaseException(BillReturnEnum.FAIL_22);
			}
		}else if("2".equals(billsFlag)){
			couponBalance = couponBalance.add(operateMonye);
			
		}else if("3".equals(billsFlag)){
			couponBalance = couponBalance.subtract(operateMonye);
			if(couponBalance.doubleValue()<0){
				log.info("平台ID为: "+buserId+" 的平台代金券余额不足！");
				throw new BaseException(BillReturnEnum.FAIL_22);
			}
		}else{
			BillReturnEnum.FAIL_91.changetMessage("账务类型参数错误");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		BusinessUserBills buserBills = new BusinessUserBills();
		buserBills.setBbillid(IdGenerator.instance().generate());///UUIDGenerator.getUUID()
		buserBills.setBuserid(buserId);
		buserBills.setOperatesn(operateSn);
		buserBills.setOperatetime(new Date());
		buserBills.setOperatemoney(operateMonye);
		buserBills.setAmountbalance(amountBalance);
		buserBills.setCouponBalance(couponBalance);
		buserBills.setBillsflag(billsFlag);
		buserBills.setOperatedesc(operateDesc);
		buserBills.setRemark(remark);
		
		//记录商户账单
		this.recordBuserBillInfo(buserBills);
	}
	
	/*######################################################################################*/
	
	/**
	 * 用户单独账务运作实现
	 * @param cuserParam
	 */
	private void makeCuserBillsByCuserParam(CUserParam cuserParam){
		String userId =  cuserParam.getUserId();
		String operateSn = cuserParam.getOperatesn();
		BigDecimal operateMoney = cuserParam.getOperatemoney();
		String billsFlag = cuserParam.getBillsflag();
		String operateDesc = cuserParam.getOperatedesc();
		String remark = cuserParam.getRemark();
		
		//验证是否重复交易
		String billId = this.userBillsDAO.validateRepeatBill(userId, operateSn, billsFlag);
		if(!ObjectTools.isNullByString(billId)){
			log.info("用户ID为: "+userId+" 单号为："+operateSn+" 的交易出现重复请求,不做任何处理");
			return;
		}
		
		//查询用户余额
		BigDecimal amountBalance = this.userInfoDAO.getAmountById(userId);
		if(ObjectTools.isNullByObject(amountBalance)){
			log.info("用户ID为: "+userId+" 的用户不存在！");
			throw new BaseException(BillReturnEnum.FAIL_21);
		}
		
		//计算用户余额
		if("0".equals(billsFlag)){
			amountBalance = amountBalance.add(operateMoney);
		}else if("1".equals(billsFlag)){
			amountBalance = amountBalance.subtract(operateMoney);
			
			if(amountBalance.doubleValue()<0){
				log.info("用户ID为: "+userId+" 的用户余额不足！");
				throw new BaseException(BillReturnEnum.FAIL_22);
			}
		}else{
			BillReturnEnum.FAIL_91.changetMessage("账务类型参数错误");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		UserBills userBills = new UserBills();
		userBills.setBillid(IdGenerator.instance().generate());
		userBills.setUserid(userId);
		userBills.setOperatesn(operateSn);
		userBills.setOperatetime(new Date());
		userBills.setOperatemoney(operateMoney);
		userBills.setAmountbalance(amountBalance);
		userBills.setBillsflag(billsFlag);
		userBills.setOperatedesc(operateDesc);
		userBills.setRemark(remark);
		
		//记录用户账单
		this.recordCuserBillInfo(userBills);
	}
	
	
/*######################################################################################*/
	
	/**
	 * 用户之间转账时，B类用户单独账务运作实现
	 * @param cuserParam
	 */
	private void makeInsideBuserBillsByInsideBuserParam(InsideBUserParam insideBuserParam){
		String userId =  insideBuserParam.getBuserId();
		String operateSn = insideBuserParam.getOperatesn();
		BigDecimal operateMoney = insideBuserParam.getOperatemoney();
		String billsFlag = insideBuserParam.getBillsflag();
		String operateDesc = insideBuserParam.getOperatedesc();
		String remark = insideBuserParam.getRemark();
		
		//验证是否重复交易
		String billId = this.userBillsDAO.validateRepeatBill(userId, operateSn, billsFlag);
		if(!ObjectTools.isNullByString(billId)){
			log.info("B类用户ID为: "+userId+" 单号为："+operateSn+" 的交易出现重复请求,不做任何处理");
			return;
		}
		
		//查询用户余额
		BigDecimal amountBalance = this.userInfoDAO.getAmountById(userId);
		if(ObjectTools.isNullByObject(amountBalance)){
			log.info("B类用户ID为: "+userId+" 的用户不存在！");
			throw new BaseException(BillReturnEnum.FAIL_21);
		}
		
		//计算用户余额
		if("0".equals(billsFlag)){
			amountBalance = amountBalance.add(operateMoney);
		}else if("1".equals(billsFlag)){
			amountBalance = amountBalance.subtract(operateMoney);
			
			if(amountBalance.doubleValue()<0){
				log.info("B类用户ID为: "+userId+" 的用户余额不足！");
				throw new BaseException(BillReturnEnum.FAIL_22);
			}
		}else{
			BillReturnEnum.FAIL_91.changetMessage("账务类型参数错误");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		UserBills userBills = new UserBills();
		userBills.setBillid(IdGenerator.instance().generate());
		userBills.setUserid(userId);
		userBills.setOperatesn(operateSn);
		userBills.setOperatetime(new Date());
		userBills.setOperatemoney(operateMoney);
		userBills.setAmountbalance(amountBalance);
		userBills.setBillsflag(billsFlag);
		userBills.setOperatedesc(operateDesc);
		userBills.setRemark(remark);
		
		//记录用户账单
		this.recordCuserBillInfo(userBills);
	}
	
	/*######################################################################################*/
	
	/**
	 * 平台与用户转账账务运作实现
	 * @param giroParam
	 * @throws Exception 
	 */
	private void makeBillsByGiroParam(GiroParam giroParam) throws Exception{
		CUserParam cuserParam = giroParam.getCuserParam();
		BUserParam buserParam = giroParam.getBuserParam();
		
		this.makeBillsByBuserParam(buserParam);

		this.makeCuserBillsByCuserParam(cuserParam);
	}
	
	/*######################################################################################*/
	
	/**
	 * 用户账单及用户额度操作处理
	 * @param userBills
	 */
	private void recordCuserBillInfo(UserBills userBills){
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userBills.getUserid());
		userInfo.setAmount(userBills.getAmountbalance());
		
	    log.info("修改后用户余额："+userInfo.getAmount());
		long starttime1 = System.currentTimeMillis();
		this.userInfoDAO.updateUser(userInfo);
		long endTime1 = System.currentTimeMillis();
		System.out.println("修改用户余额耗时:"+(endTime1-starttime1)+"ms");
		
		this.userBillsDAO.insertUserBills(userBills);
		
		
	}

	
	/*######################################################################################*/
	
	/**
	 * 平台账单及平台额度操作处理
	 */
	private void recordBuserBillInfo(BusinessUserBills buserBills){
		BusinessUserInfo bUserInfo = new BusinessUserInfo();
		bUserInfo.setAmount(buserBills.getAmountbalance());
		bUserInfo.setCouponAmount(buserBills.getCouponBalance());
		bUserInfo.setBuserId(buserBills.getBuserid());
		
		this.businessUserInfoDAO.updateAmount(bUserInfo);
		this.businessUserBillsDAO.insertBusinessUserBills(buserBills);
	}
	
	
	/*######################################################################################*/
	
	/**
	 * C类用户与B类用户转账账务运作实现
	 * @param giroParam
	 * @throws Exception 
	 */
	private void makeInsideTransferBillsByGiroParam(InsideGiroParam insideGiroParam) throws Exception{
		CUserParam cuserParam = insideGiroParam.getCuserParam();
		InsideBUserParam insideBuserParam = insideGiroParam.getInsideBuserParam();
		
		this.makeInsideBuserBillsByInsideBuserParam(insideBuserParam);

		this.makeCuserBillsByCuserParam(cuserParam);
	}

}
