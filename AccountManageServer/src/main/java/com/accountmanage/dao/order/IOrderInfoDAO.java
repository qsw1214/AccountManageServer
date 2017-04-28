package com.accountmanage.dao.order;

import java.util.List;
import java.util.Map;

import base.cn.web.mybatis.util.PageInfo;

import com.accountmanage.pojo.order.OrderInfo;

public interface IOrderInfoDAO {
	
	int insert (OrderInfo order);
	
	int update (OrderInfo order);
	
	public OrderInfo getByOrderSn(String orderSn);
	
	public List<OrderInfo> getListByBaseOrderSn(String baseOrderSn);
	
	/**
	 * 根据条件分页查询订单信息
	 * @param paramHashMap
	 * @return
	 */
	public PageInfo<OrderInfo> getPageOrderList(Map<String, String> paramMap);

}
