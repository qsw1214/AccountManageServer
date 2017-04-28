package com.accountmanage.network.sms.yunxin;

import com.accountmanage.network.util.SMSCode;

public class SMSYunxinSendVO {

	private String sendTime;//响应时间
	private String respStatus;//状态
	private String stateMsg = "提交成功";//状态描述
	private String msgID;//
	private SMSCode smsCode;//本地状态
	
	public SMSCode getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(SMSCode smsCode) {
		this.smsCode = smsCode;
	}
	public String getMsgID() {
		return msgID;
	}
	public void setMsgID(String msgID) {
		this.msgID = msgID;
	}
	public String getRespStatus() {
		return respStatus;
	}
	public void setRespStatus(String respStatus) {
		this.respStatus = respStatus;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getStateMsg() {
		return stateMsg;
	}
	public void setStateMsg(String stateMsg) {
		this.stateMsg = stateMsg;
	}
}
