package com.accountmanage.pojo.system;

public class yxj_system_sms_config {

	private String configId;//主键
	private String pointName;//发送短信点名称
	private String pointCode;//发送短信点编码
	private Yxj_system_sms_channel smsChannel;//短信渠道外键
	private String activeState;//激活状态 0.未激活 1.已激活
	public String getConfigId() {
		return configId;
	}
	public void setConfigId(String configId) {
		this.configId = configId;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public String getPointCode() {
		return pointCode;
	}
	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
	}
	
	public Yxj_system_sms_channel getSmsChannel() {
		return smsChannel;
	}
	public void setSmsChannel(Yxj_system_sms_channel smsChannel) {
		this.smsChannel = smsChannel;
	}
	public String getActiveState() {
		return activeState;
	}
	public void setActiveState(String activeState) {
		this.activeState = activeState;
	}
	
	
	

}
