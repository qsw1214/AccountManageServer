package com.accountmanage.web.kdniao.network.vo.bean;

public class KdQueryImmeidatelyReqBean {
	private String OrderCode;//订单编号	O
	private String ShipperCode;//快递公司编码	R
	private String LogisticCode;//物流单号	R
	
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
	
}
