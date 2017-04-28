package com.accountmanage.pojo.order;

import java.math.BigDecimal;

public class OrderDetail {

	private String detailid;//'订单明细ID',
	private String ordersn;//'订单号',
	private String prodid;//'商品ID',
	private Integer quantity;//'商品数量',
	private BigDecimal sellprice;//'总售价',
	private String prodname;//'商品名称',
	private String isreview;//'是否评价 0.未评价 1.已评价',
	
	public String getDetailid() {
		return detailid;
	}
	public void setDetailid(String detailid) {
		this.detailid = detailid;
	}
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getSellprice() {
		return sellprice;
	}
	public void setSellprice(BigDecimal sellprice) {
		this.sellprice = sellprice;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getIsreview() {
		return isreview;
	}
	public void setIsreview(String isreview) {
		this.isreview = isreview;
	}
	
	
	
	
	
	
}
