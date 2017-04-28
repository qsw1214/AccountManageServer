package com.accountmanage.service.network.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import base.cn.util.UUIDGenerator;

import com.accountmanage.dao.network.ISmsContentInfoDAO;
import com.accountmanage.network.util.SMSCode;
import com.accountmanage.pojo.network.SmsContentInfo;
import com.accountmanage.service.network.ISmsContentInfoService;

@Service("smsContentInfoService")
public class SmsContentInfoServiceImpl implements ISmsContentInfoService{
	
	@Resource
	private ISmsContentInfoDAO smsContentInfoDAO;

	/**
	 * 插入短信信息操作
	 * @param smsContentInfo
	 */
	@Override
	public void insertSmsContentInfo(SmsContentInfo smsContentInfo) {
		
		this.smsContentInfoDAO.insertSmsContentInfo(smsContentInfo);
	}

	/**
	 * 修改短信信息操作
	 * @param smsContentInfo
	 */
	@Override
	public void updateSmsContentInfo(SmsContentInfo smsContentInfo) {
		
		this.smsContentInfoDAO.updateSmsContentInfo(smsContentInfo);
	}

	

	/**
	 * 修改短信信息
	 * @param msgId
	 * @param updateData
	 */
	@Override
	public void EditSmsContentInfo(String smsId, SmsContentInfo updateData) {
		SmsContentInfo sci = this.getBySmsId(smsId);
		sci.setSendTimes(updateData.getSendTimes());
		sci.setStateCode(updateData.getStateCode());
		sci.setStateMsg(updateData.getStateCode()+":"+updateData.getStateMsg());
		sci.setSendDatetime(new Date());
		sci.setMsgId(updateData.getMsgId());
		sci.setCode(updateData.getCode());
		
		this.updateSmsContentInfo(sci);
		
	}

	/**
	 * 保存短信信息
	 * @param mobiles
	 * @param content
	 * @param sendType
	 * @param userName
	 * @param superName
	 */
	@Override
	public SmsContentInfo saveSmsContentInfo(String mobiles, String content,
			String sendType, String userName, String superName) {
		
		SmsContentInfo smsContentInfo = new SmsContentInfo();
		smsContentInfo.setSmsId(UUIDGenerator.getUUID());
		smsContentInfo.setMobiles(mobiles);
		smsContentInfo.setMobileNums(mobiles.split(",").length);
		smsContentInfo.setContent(content);
		smsContentInfo.setSendType(sendType);
		smsContentInfo.setUserName(userName);
		smsContentInfo.setSuperName(superName);
		smsContentInfo.setCode(SMSCode.INIT.getCode());
		
		this.insertSmsContentInfo(smsContentInfo);
		
		return smsContentInfo;
	}

	/**
	 * 根据msgId获取短信信息
	 * @param msgId
	 * @return
	 */
	@Override
	public SmsContentInfo getBySmsId(String smsId) {
		
		return this.smsContentInfoDAO.getBySmsId(smsId);
	}

	/**
	 * 根据msgId获取短信
	 * @param msgId
	 * @return
	 */
	@Override
	public SmsContentInfo getByMsgId(String msgId) {
		
		return this.smsContentInfoDAO.getByMsgId(msgId);
	}

	/**
	 * 修改短信信息
	 * @param msgId
	 * @param updateData
	 */
	@Override
	public void EditForNotifySms(String smsId, SmsContentInfo updateData) {
		SmsContentInfo sci = this.getBySmsId(smsId);
		sci.setStateCode(updateData.getStateCode());
		sci.setStateMsg(updateData.getStateCode()+":"+updateData.getStateMsg());
		sci.setNotifyDatetime(updateData.getNotifyDatetime());
		sci.setCode(updateData.getCode());
		
		this.updateSmsContentInfo(sci);
		
	}

}
