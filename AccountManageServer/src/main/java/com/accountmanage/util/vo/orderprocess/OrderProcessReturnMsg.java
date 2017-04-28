package com.accountmanage.util.vo.orderprocess;

import java.util.List;

import com.accountmanage.util.vo.BaseReturnMsg;

public class OrderProcessReturnMsg extends BaseReturnMsg{

	public OrderProcessReturnMsg(){
		
	}
	public OrderProcessReturnMsg(boolean success, String message) {
		super(success, message);
	}

	
	private List<OrderProcessBean> processlist;//
	private String logisticsstate;//'物流状态 0.提交成功 1.支付成功  2.库房已处理 3.物流已揽件 4.配送在途 5.签收 6.问题件',
	private String waybillno;
	private String ordersn;
	
	
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	public String getLogisticsstate() {
		return logisticsstate;
	}
	public void setLogisticsstate(String logisticsstate) {
		this.logisticsstate = logisticsstate;
	}
	public String getWaybillno() {
		return waybillno;
	}
	public void setWaybillno(String waybillno) {
		this.waybillno = waybillno;
	}
	public List<OrderProcessBean> getProcesslist() {
		return processlist;
	}

	public void setProcesslist(List<OrderProcessBean> processlist) {
		this.processlist = processlist;
	}
	
	
	
	
}
