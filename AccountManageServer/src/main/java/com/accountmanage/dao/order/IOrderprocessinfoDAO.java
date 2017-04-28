package com.accountmanage.dao.order;

import java.util.List;

import com.accountmanage.pojo.order.Orderprocessinfo;


public interface IOrderprocessinfoDAO {
	
	public List<Orderprocessinfo> findByOrdersn(String ordersn);
	
	public void insert(Orderprocessinfo orderprocessinfo);
}
