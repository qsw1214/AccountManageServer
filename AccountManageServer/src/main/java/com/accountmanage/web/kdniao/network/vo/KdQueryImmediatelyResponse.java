package com.accountmanage.web.kdniao.network.vo;

import java.util.List;

import com.accountmanage.web.kdniao.network.vo.bean.TracesBean;

public class KdQueryImmediatelyResponse extends KdBaseResponse{
	
	private String EBusinessID;//用户ID	R
	private String OrderCode;//订单编号	O
	private String ShipperCode;//快递公司编码	R
	private String LogisticCode;//物流运单号	O
	private Boolean Success;//成功与否	R
	private String Reason;//失败原因	O
	private String State;//物流状态：2-在途中,3-签收,4-问题件	R
	private List<TracesBean> Traces; 
	
	
	
	public List<TracesBean> getTraces() {
		return Traces;
	}
	public void setTraces(List<TracesBean> traces) {
		Traces = traces;
	}
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
	public Boolean getSuccess() {
		return Success;
	}
	public void setSuccess(Boolean success) {
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
	
	
	
}
