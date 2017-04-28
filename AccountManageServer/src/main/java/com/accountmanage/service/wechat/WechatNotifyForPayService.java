package com.accountmanage.service.wechat;

import com.accountmanage.pojo.wechat.WechatNotifyModel;


public interface WechatNotifyForPayService {

	/**
	 * 订单微信支付回调处理
	 * @param notify
	 * @return boolean
	 */
	public boolean doWechatNotifyForPay(WechatNotifyModel notify) throws RuntimeException,Exception;
	
}
