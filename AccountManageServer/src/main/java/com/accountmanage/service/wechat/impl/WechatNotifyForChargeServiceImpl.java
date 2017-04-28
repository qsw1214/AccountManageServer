package com.accountmanage.service.wechat.impl;


import static com.accountmanage.util.Constants.SMS_PROPERTIES;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.accountmanage.dao.bills.IUserInfoDAO;
import com.accountmanage.dao.order.IUserThirdChargeDAO;
import com.accountmanage.network.sms.yunxin.SMSYunxinThread;
import com.accountmanage.network.util.SmsSendType;
import com.accountmanage.pojo.bills.UserInfo;
import com.accountmanage.pojo.order.UserThirdCharge;
import com.accountmanage.pojo.system.yxj_system_sms_config;
import com.accountmanage.pojo.wechat.WechatNotifyModel;
import com.accountmanage.service.bills.IBillsHandleService;
import com.accountmanage.service.system.IyxjSystemSmsConfigService;
import com.accountmanage.service.wechat.WechatNotifyForChargeService;
import com.accountmanage.util.PropertyManager;
import com.accountmanage.web.bills.util.parambean.CUserParam;

import base.cn.util.ObjectTools;

@Service("wechatNotifyForChargeService")
public class WechatNotifyForChargeServiceImpl implements WechatNotifyForChargeService {
	
	private Logger log = Logger.getLogger(WechatNotifyForChargeServiceImpl.class);
	@Resource
	private IUserThirdChargeDAO userThirdChargeDAO;
    @Resource
    private IBillsHandleService billsHandleService;
    @Resource
	private IUserInfoDAO userInfoDAO;
    @Resource
    private IyxjSystemSmsConfigService yxjSystemSmsConfigService;
	
	public boolean doWechatNotifyForCharge(WechatNotifyModel notify) throws RuntimeException,Exception {
		//订单是否已处理
		String chargeSn = notify.getOut_trade_no(); //平台订单号
		UserThirdCharge thirdCharge = userThirdChargeDAO.getUserThirdChargeByOrderSn(chargeSn);

		if(thirdCharge == null){
			log.info("充值订单不存在");
			return false;
		}
		//判断金额是否和页面提交金额一致
		BigDecimal cmoney = thirdCharge.getChargemoney().multiply(new BigDecimal("100"));
		if(new BigDecimal(notify.getTotal_fee()).compareTo(cmoney) != 0){
			log.info("回调通知金额"+notify.getTotal_fee()+"和页面提交金额"+cmoney+"不一致");
			return false;
		}
		//获取用户编号
		String muserId = thirdCharge.getUserid();
		//取得支付状态
		String trade_status = notify.getResult_code();
		String third_no = notify.getTransaction_id();   //微信订单号
		//支付成功
		if("SUCCESS".equals(trade_status) 
				|| "SUCCESS".equals(trade_status)){
			
			if(!"1".equals(thirdCharge.getState())){
				this.log.info("订单状态为："+thirdCharge.getChargesn()+",不是待付款状态，不能进行处理！");
				return true;
			}
			thirdCharge.setState("2");
			thirdCharge.setChargetime(new Date());
			thirdCharge.setCpordersn(third_no);;
			userThirdChargeDAO.update(thirdCharge);
			//给用户账户转账（手机用户+）
			bill(muserId, thirdCharge.getChargemoney(),thirdCharge.getChargesn());
			//把用户设为会员
			final UserInfo persistUserInfo = userInfoDAO.getById(muserId);
			if(persistUserInfo != null && "0".equals(persistUserInfo.getIsMember())){
				UserInfo user = new UserInfo();
				user.setUserId(muserId);
				user.setIsMember("1");
				userInfoDAO.updateUser(user);
			}
			String code = SmsSendType.CZCG.getCode();
  			yxj_system_sms_config byPointCode = yxjSystemSmsConfigService.getSmsConfigByPointCode(code);
  			String agentCode = "";
  			if(!ObjectTools.isNullByObject(byPointCode)){
					agentCode = byPointCode.getSmsChannel().getChannelCode();
				}
			PropertyManager proManager = PropertyManager.instance();
			String content = proManager.getValue(SMS_PROPERTIES,"yunxin.charge.content",true);
			SMSYunxinThread smsThread = new SMSYunxinThread(agentCode,
					persistUserInfo.getTelephone(),content.replace("@amount@", thirdCharge.getChargemoney().toString()));
			smsThread.start();
		}else{
			thirdCharge.setState("3");
			thirdCharge.setChargetime(new Date());
			thirdCharge.setCpordersn(third_no);;
			userThirdChargeDAO.update(thirdCharge);
		}
		return true;
	}
	
	  
	
	//手机用户账单操作（微信充值）
	private void bill(String mid, BigDecimal amt, String orderSn)  throws RuntimeException,Exception{

	    CUserParam cuserParam = new CUserParam();

		cuserParam.setUserId(mid);
		cuserParam.setOperatesn(orderSn);
		cuserParam.setOperatemoney(amt);
		cuserParam.setAmountbalance(null);
		cuserParam.setBillsflag("0");
		cuserParam.setOperatedesc("微信额度充值");
		cuserParam.setRemark("微信额度充值");
		billsHandleService.doCUserBillsHandle(cuserParam);
		
	}
	
	

	
}
