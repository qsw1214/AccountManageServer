package com.accountmanage.network.sms.dahan.vo;

import com.accountmanage.network.util.SMSCode;

public class DahanResponseVO {

	private String msgid;
	private String result;
	private String desc;
	private String failPhones;
	private String stateMsg = "提交成功";//状态描述
	private SMSCode smsCode;//本地状态
	public String getStateMsg() {
		return stateMsg;
	}
	public void setStateMsg(String stateMsg) {
		this.stateMsg = stateMsg;
	}
	public SMSCode getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(SMSCode smsCode) {
		this.smsCode = smsCode;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getFailPhones() {
		return failPhones;
	}
	public void setFailPhones(String failPhones) {
		this.failPhones = failPhones;
	}
	
	
}
