package com.accountmanage.util;

import com.accountmanage.service.order.IYxjUserCouponGrantConfigService;



public class OrderSendTicketThread extends Thread{
	
	private String shareUserId;
	private String baseOrdersn;
	private IYxjUserCouponGrantConfigService yxjUserCouponGrantConfigService;
	
	public OrderSendTicketThread(IYxjUserCouponGrantConfigService yxjUserCouponGrantConfigService,
			String shareUserId,String baseOrdersn){
		this.yxjUserCouponGrantConfigService = yxjUserCouponGrantConfigService;
		this.shareUserId = shareUserId;
		this.baseOrdersn = baseOrdersn;
	}
	
	@Override
	public void run() {
		
		try {
			yxjUserCouponGrantConfigService.doGrantRedPacket(shareUserId, baseOrdersn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
