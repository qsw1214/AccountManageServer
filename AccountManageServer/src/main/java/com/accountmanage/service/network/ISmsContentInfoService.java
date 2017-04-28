package com.accountmanage.service.network;

import com.accountmanage.pojo.network.SmsContentInfo;

public interface ISmsContentInfoService {

	/**
	 * 插入短信信息操作
	 * @param smsContentInfo
	 */
	public void insertSmsContentInfo(SmsContentInfo smsContentInfo);
	
	/**
	 * 修改短信信息操作
	 * @param smsContentInfo
	 */
	public void updateSmsContentInfo(SmsContentInfo smsContentInfo);
	
	/**
	 * 根据msgId获取短信信息
	 * @param msgId
	 * @return
	 */
	public SmsContentInfo getBySmsId(String smsId);
	
	/**
	 * 修改短信信息
	 * @param msgId
	 * @param updateData
	 */
	public void EditSmsContentInfo(String smsId,SmsContentInfo updateData);
	
	/**
	 * 修改短信信息
	 * @param msgId
	 * @param updateData
	 */
	public void EditForNotifySms(String smsId,SmsContentInfo updateData);
	
	/**
	 * 保存短信信息
	 * @param mobiles
	 * @param content
	 * @param sendType
	 * @param userName
	 * @param superName
	 */
	public SmsContentInfo saveSmsContentInfo(String mobiles,String content,String sendType,String userName,String superName);
	
	/**
	 * 根据msgId获取短信
	 * @param msgId
	 * @return
	 */
	public SmsContentInfo getByMsgId(String msgId);
}
