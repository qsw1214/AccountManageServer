package com.accountmanage.pojo.order;

import java.util.Date;

public class YxjUserCouponGrantConfig {
	private String configId;///红包发放配置信息表
	private String configFlag;//发放类型 1.注册发放 2.订单分享 3.客服发放
	private Date createTime;//创建时间
	private Date editTime;//修改时间
	private String configRemark;//备注
	private Date beginTime;//生效起始时间
	private Date endTime;//生效截止时间
	private String state;//状态 0.删除 1.正常
	private int timeLength;
	private int totalMoney;
	
	
	
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getConfigId() {
		return configId;
	}
	public void setConfigId(String configId) {
		this.configId = configId;
	}
	public String getConfigFlag() {
		return configFlag;
	}
	public void setConfigFlag(String configFlag) {
		this.configFlag = configFlag;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEditTime() {
		return editTime;
	}
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	public String getConfigRemark() {
		return configRemark;
	}
	public void setConfigRemark(String configRemark) {
		this.configRemark = configRemark;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(int timeLength) {
		this.timeLength = timeLength;
	}
	
	
	
	
}
