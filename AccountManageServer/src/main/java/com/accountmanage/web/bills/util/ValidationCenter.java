package com.accountmanage.web.bills.util;

import java.math.BigDecimal;




import base.cn.exception.BaseException;
import base.cn.util.ObjectTools;

import com.accountmanage.web.bills.util.parambean.BUserParam;
import com.accountmanage.web.bills.util.parambean.CUserParam;
import com.accountmanage.web.bills.util.parambean.GiroParam;
import com.accountmanage.web.bills.util.parambean.InsideBUserParam;
import com.accountmanage.web.bills.util.parambean.InsideGiroParam;

public class ValidationCenter {
	

	
	//验证用户账务操作请求参数BEAN参数有效性
	public void validateCuserParam(CUserParam cuserParam){
		
		if(ObjectTools.isNullByObject(cuserParam)){
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		//被操作账户对象ID
		String userId = cuserParam.getUserId();
		if(ObjectTools.isNullByString(userId.trim())){
			BillReturnEnum.FAIL_91.changetMessage("用户ID为空");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		//操作金额
		BigDecimal operateMoney = cuserParam.getOperatemoney();
		if(ObjectTools.isNullByString(operateMoney.toString().trim())){
			BillReturnEnum.FAIL_91.changetMessage("账单金额为空");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		//操作金额
		if(operateMoney.doubleValue()<=0){
			throw new BaseException(BillReturnEnum.FAIL_83);
		}
		
		//账单单号
		String operateSn = cuserParam.getOperatesn();
		if(ObjectTools.isNullByString(operateSn.toString().trim())){
			BillReturnEnum.FAIL_91.changetMessage("账单单号为空");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
		
		//账务类型
		String billsFlag = cuserParam.getBillsflag();
		if(ObjectTools.isNullByString(billsFlag.toString().trim())){
			BillReturnEnum.FAIL_91.changetMessage("账务类型为空");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}
				
		//账务描述
		String operateDesc = cuserParam.getOperatedesc();
		if(ObjectTools.isNullByString(operateDesc.toString().trim())){
			BillReturnEnum.FAIL_91.changetMessage("账单描述为空");
			throw new BaseException(BillReturnEnum.FAIL_91);
		}				
		
		
	}
	
	
	//验证B类用户账务操作请求参数BEAN参数有效性
		public void validateInsideBuserParam(InsideBUserParam insideBuserParam){
			
			if(ObjectTools.isNullByObject(insideBuserParam)){
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
			//被操作账户对象ID
			String userId = insideBuserParam.getBuserId();
			if(ObjectTools.isNullByString(userId.trim())){
				BillReturnEnum.FAIL_91.changetMessage("用户ID为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
			//操作金额
			BigDecimal operateMoney = insideBuserParam.getOperatemoney();
			if(ObjectTools.isNullByString(operateMoney.toString().trim())){
				BillReturnEnum.FAIL_91.changetMessage("账单金额为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
			//操作金额
			if(operateMoney.doubleValue()<=0){
				throw new BaseException(BillReturnEnum.FAIL_83);
			}
			
			//账单单号
			String operateSn = insideBuserParam.getOperatesn();
			if(ObjectTools.isNullByString(operateSn.toString().trim())){
				BillReturnEnum.FAIL_91.changetMessage("账单单号为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
			//账务类型
			String billsFlag = insideBuserParam.getBillsflag();
			if(ObjectTools.isNullByString(billsFlag.toString().trim())){
				BillReturnEnum.FAIL_91.changetMessage("账务类型为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
					
			//账务描述
			String operateDesc = insideBuserParam.getOperatedesc();
			if(ObjectTools.isNullByString(operateDesc.toString().trim())){
				BillReturnEnum.FAIL_91.changetMessage("账单描述为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}				
			
			
		}
	
	//验证商户账务操作请求参数BEAN参数有效性
	public void validateBuserParam(BUserParam buserParam){
			
			if(ObjectTools.isNullByObject(buserParam)){
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
			//被操作账户对象ID
			String buserId = buserParam.getBuserId();
			if(ObjectTools.isNullByString(buserId.trim())){
				BillReturnEnum.FAIL_91.changetMessage("商户ID为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
			//操作金额
			BigDecimal operateMoney = buserParam.getOperatemoney();
			if(ObjectTools.isNullByString(operateMoney.toString().trim())){
				BillReturnEnum.FAIL_91.changetMessage("账单金额为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
			//操作金额
			if(operateMoney.doubleValue()<=0){
				throw new BaseException(BillReturnEnum.FAIL_83);
			}
			
			//账单单号
			String operateSn = buserParam.getOperatesn();
			if(ObjectTools.isNullByString(operateSn.toString().trim())){
				BillReturnEnum.FAIL_91.changetMessage("账单单号为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
			
			//账务类型
			String billsFlag = buserParam.getBillsflag();
			if(ObjectTools.isNullByString(billsFlag.toString().trim())){
				BillReturnEnum.FAIL_91.changetMessage("账务类型为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}
					
			//账务描述
			String operateDesc = buserParam.getOperatedesc();
			if(ObjectTools.isNullByString(operateSn.toString().trim())){
				BillReturnEnum.FAIL_91.changetMessage("账单描述为空");
				throw new BaseException(BillReturnEnum.FAIL_91);
			}				
			
			
	}
	
	//验证用户与平台转账请求参数BEAN有效性
	public void validateAmountGiroParam(GiroParam giroParam){
		//验证商户端请求参数有效性
		this.validateBuserParam(giroParam.getBuserParam());
		
		//验证用户端请求参数有效性
		this.validateCuserParam(giroParam.getCuserParam());
	}
	
	//验证C类用户与B类用户转账请求参数BEAN有效性
		public void validateInsideUserAmountGiroParam(InsideGiroParam insideGiroParam){
			//验证商户端请求参数有效性
			this.validateInsideBuserParam(insideGiroParam.getInsideBuserParam());
			
			//验证用户端请求参数有效性
			this.validateCuserParam(insideGiroParam.getCuserParam());
		}
	
}
