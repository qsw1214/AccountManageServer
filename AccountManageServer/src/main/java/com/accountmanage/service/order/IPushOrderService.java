package com.accountmanage.service.order;


public interface IPushOrderService {

	public String doKdniaoPushOrder(String jsonStr) throws Exception;
	
	public String doPjPushOrder(String jsonStr) throws Exception;
}
