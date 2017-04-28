package com.accountmanage.dao.network;

import com.accountmanage.pojo.network.SmsContentInfo;

public interface ISmsContentInfoDAO {

	/**
	 * 插入短信信息表
	 * @param smsContentInfo
	 */
	public void insertSmsContentInfo(SmsContentInfo smsContentInfo);
	
	/**
	 * 修改短信信息表
	 * @param smsContentInfo
	 */
	public void updateSmsContentInfo(SmsContentInfo smsContentInfo);
	
	/**
	 * 根据smsId获取短信信息
	 * @param msgId
	 * @return
	 */
	public SmsContentInfo getBySmsId(String smsId);
	
	/**
	 * 根据msgId获取短信
	 * @param msgId
	 * @return
	 */
	public SmsContentInfo getByMsgId(String msgId);
}
