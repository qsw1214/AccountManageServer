package com.accountmanage.dao.order;

import java.util.Map;

import base.cn.web.mybatis.util.PageInfo;

import com.accountmanage.pojo.order.BaseOrderInfo;

public interface IBaseOrderInfoDAO {
	
	int insert (BaseOrderInfo baseorder);
	
	int update (BaseOrderInfo order);
	
	public BaseOrderInfo getByBaseOrderSn(String baseorderSn);
	
	/**
	 * 根据条件分页查询订单信息
	 * @param paramHashMap
	 * @return
	 */
	public PageInfo<BaseOrderInfo> getPageBaseOrderList(Map<String, String> paramMap);

}
