package com.accountmanage.network.util;

/**
 * 本方短信状态
 * */
public enum SMSCode {
	
	FAIL("3"),//失败
	SENDOVER("2"),//发送完毕
	COMMITSUCCESS("1"),//提交成功
	INIT("0");//初始化
	
	private final String code;
	
	SMSCode(String code){
		this.code = code;
	}
	
	public String getCode(){
		return this.code;
	}
}
