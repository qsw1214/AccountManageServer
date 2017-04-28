package com.accountmanage.web.kdniao.network.vo.recv;

import java.util.List;

import com.accountmanage.web.kdniao.network.vo.bean.TracesBean;

public class RecvDataBean {
	private String EBusinessID;
	private String OrderCode;
	private String ShipperCode;
	private String LogisticCode;
	private String Success;
	private String Reason;
	private String State;
	private String CallBack;
	private List<TracesBean> Traces;
	private String EstimatedDeliveryTime;
	private PickerInfoBean PickerInfo;
	private SenderInfoBean SenderInfo;
	public String getEBusinessID() {
		return EBusinessID;
	}
	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getShipperCode() {
		return ShipperCode;
	}
	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}
	public String getLogisticCode() {
		return LogisticCode;
	}
	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}
	public String getSuccess() {
		return Success;
	}
	public void setSuccess(String success) {
		Success = success;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCallBack() {
		return CallBack;
	}
	public void setCallBack(String callBack) {
		CallBack = callBack;
	}

	
	public List<TracesBean> getTraces() {
		return Traces;
	}
	public void setTraces(List<TracesBean> traces) {
		Traces = traces;
	}
	public String getEstimatedDeliveryTime() {
		return EstimatedDeliveryTime;
	}
	public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
		EstimatedDeliveryTime = estimatedDeliveryTime;
	}
	public PickerInfoBean getPickerInfo() {
		return PickerInfo;
	}
	public void setPickerInfo(PickerInfoBean pickerInfo) {
		PickerInfo = pickerInfo;
	}
	public SenderInfoBean getSenderInfo() {
		return SenderInfo;
	}
	public void setSenderInfo(SenderInfoBean senderInfo) {
		SenderInfo = senderInfo;
	}
	
	
	
	
	

     
     
     
}
