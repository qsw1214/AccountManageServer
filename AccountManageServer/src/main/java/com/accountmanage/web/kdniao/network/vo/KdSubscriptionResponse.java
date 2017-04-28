package com.accountmanage.web.kdniao.network.vo;


public class KdSubscriptionResponse{
	
	private String EBusinessID;//R	电商用户ID
	private String UpdateTime;//R	时间
	private boolean Success;//R	成功与否:true,false
	private String Reason;//O	失败原因
	private String EstimatedDeliveryTime;//O	订单预计到货时间yyyy-mm-dd
	public String getEBusinessID() {
		return EBusinessID;
	}
	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}
	public String getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getEstimatedDeliveryTime() {
		return EstimatedDeliveryTime;
	}
	public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
		EstimatedDeliveryTime = estimatedDeliveryTime;
	}
	
	
	
	
	
}
