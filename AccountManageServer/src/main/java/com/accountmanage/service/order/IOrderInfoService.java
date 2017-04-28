package com.accountmanage.service.order;

import java.util.Map;

import base.cn.web.mybatis.util.PageInfo;

import com.accountmanage.pojo.order.OrderInfo;

public interface IOrderInfoService {

	/**
	 * 根据条件分页查询订单信息
	 * @param paramHashMap
	 * @return
	 */
	public PageInfo<OrderInfo> getPageOrderList(Map<String, String> paramMap);
	
	public OrderInfo getOrderInfoByOrderSn(String ordersn);
}
