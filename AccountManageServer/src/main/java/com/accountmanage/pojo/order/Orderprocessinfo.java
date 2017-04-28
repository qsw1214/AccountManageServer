package com.accountmanage.pojo.order;

public class Orderprocessinfo {
	
	
	private String processid;//流程id
	private String ordersn;//订单号
	private String processdesc;//流程描述
	private String processtime ;//流程处理时间
	private String processremark;//流程备注
	private String logisticsstate;//'物流状态 0.提交成功 1.支付成功  2.库房已处理 3.物流已揽件 4.配送在途 5.签收 6.问题件7.订单取消8.退货中，9退款成功',
	private String waybillno;
	

	
	public String getWaybillno() {
		return waybillno;
	}
	public void setWaybillno(String waybillno) {
		this.waybillno = waybillno;
	}
	public String getLogisticsstate() {
		return logisticsstate;
	}
	public void setLogisticsstate(String logisticsstate) {
		this.logisticsstate = logisticsstate;
	}
	public String getProcessid() {
		return processid;
	}
	public void setProcessid(String processid) {
		this.processid = processid;
	}
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	public String getProcessdesc() {
		return processdesc;
	}
	public void setProcessdesc(String processdesc) {
		this.processdesc = processdesc;
	}
	public String getProcesstime() {
		return processtime;
	}
	public void setProcesstime(String processtime) {
		this.processtime = processtime;
	}
	public String getProcessremark() {
		return processremark;
	}
	public void setProcessremark(String processremark) {
		this.processremark = processremark;
	}
	

}
