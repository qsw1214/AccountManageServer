package com.accountmanage.service.wechat;



public interface CustomerWechatNotifyForPayService {

	/**
	 * 订单微信支付回调处理
	 * @param notify
	 * @return boolean
	 */
	public boolean doWechatNotifyForPay(String orderSn,String third_no) throws RuntimeException,Exception;
	
}
