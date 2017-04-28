package com.accountmanage.service.order.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import base.cn.web.mybatis.plugin.PageInterceptor;
import base.cn.web.mybatis.util.PageInfo;

import com.accountmanage.dao.order.IOrderInfoDAO;
import com.accountmanage.pojo.order.OrderInfo;
import com.accountmanage.service.order.IOrderInfoService;

@Service("orderInfoService")
public class OrderInfoServiceImpl implements IOrderInfoService{
	
	@Resource
	private IOrderInfoDAO orderInfoDAO;

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<OrderInfo> getPageOrderList(Map<String, String> paramMap) {
		PageInterceptor.startPage(Integer.parseInt(paramMap.get("page")));
		orderInfoDAO.getPageOrderList(paramMap);
		
		return PageInterceptor.endPage();
	}

	@Override
	public OrderInfo getOrderInfoByOrderSn(String ordersn) {
		// TODO Auto-generated method stub
		return null;
	}

}
