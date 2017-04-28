package com.accountmanage.web.bills.util;

public enum BillReturnEnum {

	SUCCESS("00","成功"),
	FAIL_21("21","账户名ID不存在"),
	FAIL_22("22","余额不足"),
	FAIL_82("82","重复交易"),
	FAIL_83("83","非法金额"),
	
	FAIL_99("99","服务异常"),
	
	
	FAIL_91("91","参数校验异常");
	
	private String code;
	private String message;
	
	private BillReturnEnum(String code,String message){
		this.code = code;
		this.message = message;
	}
	
	public String getCode(){
		return code;
	}
	public String getMessage(){
		return message;
	}
	public void changetMessage(String message){
		this.message = message;
	}
}
