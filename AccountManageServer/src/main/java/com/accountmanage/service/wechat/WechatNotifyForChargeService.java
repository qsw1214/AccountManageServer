package com.accountmanage.service.wechat;

import com.accountmanage.pojo.wechat.WechatNotifyModel;


public interface WechatNotifyForChargeService {

	/**
	 * 订单微信支付回调处理
	 * @param notify
	 * @return boolean
	 */
	public boolean doWechatNotifyForCharge(WechatNotifyModel notify) throws RuntimeException,Exception;
	
}
