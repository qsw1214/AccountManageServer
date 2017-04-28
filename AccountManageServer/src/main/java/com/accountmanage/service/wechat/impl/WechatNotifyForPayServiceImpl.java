package com.accountmanage.service.wechat.impl;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import base.cn.util.IdGenerator;

import com.accountmanage.dao.bills.IUserInfoDAO;
import com.accountmanage.dao.order.IBaseOrderInfoDAO;
import com.accountmanage.dao.order.IOrderInfoDAO;
import com.accountmanage.dao.order.IOrderprocessinfoDAO;
import com.accountmanage.dao.order.IUserThirdPayDAO;
import com.accountmanage.dao.prod.ICouponUseInfoDAO;
import com.accountmanage.pojo.bills.UserInfo;
import com.accountmanage.pojo.order.BaseOrderInfo;
import com.accountmanage.pojo.order.OrderInfo;
import com.accountmanage.pojo.order.Orderprocessinfo;
import com.accountmanage.pojo.order.UserThirdPay;
import com.accountmanage.pojo.prod.CouponUseInfo;
import com.accountmanage.pojo.wechat.WechatNotifyModel;
import com.accountmanage.service.bills.IBillsHandleService;
import com.accountmanage.service.order.IYxjUserCouponGrantConfigService;
import com.accountmanage.service.wechat.WechatNotifyForPayService;
import com.accountmanage.util.Constants;
import com.accountmanage.util.DateUtil;
import com.accountmanage.util.OrderSendTicketThread;
import com.accountmanage.web.bills.util.parambean.BUserParam;
import com.accountmanage.web.bills.util.parambean.CUserParam;
import com.accountmanage.web.bills.util.parambean.GiroParam;

@Service("wechatNotifyForPayService")
public class WechatNotifyForPayServiceImpl implements WechatNotifyForPayService {
	
	private Logger log = Logger.getLogger(WechatNotifyForPayServiceImpl.class);
	@Resource
	private IOrderInfoDAO orderInfoDAO;
	@Resource
	private IUserThirdPayDAO userThirdPayDAO;
	@Resource
	private ICouponUseInfoDAO couponUseInfoDAO;
    @Resource
    private IBillsHandleService billsHandleService;
    @Resource
    private IOrderprocessinfoDAO orderprocessinfoDAO;
    @Resource
    private IUserInfoDAO userInfoDAO;
    @Resource
    private IBaseOrderInfoDAO baseOrderInfoDAO;
    @Resource
    private IYxjUserCouponGrantConfigService yxjUserCouponGrantConfigService;

	
	public boolean doWechatNotifyForPay(WechatNotifyModel notify) throws RuntimeException,Exception {
		
		//订单是否已处理
		String baseOrderSn = notify.getOut_trade_no(); //平台订单号
		BaseOrderInfo baseOrder = baseOrderInfoDAO.getByBaseOrderSn(baseOrderSn);
		if(!(Constants.ORDER_NO_PAY.equals(baseOrder.getOrderstate())
				|| Constants.ORDER_CANCEL.equals(baseOrder.getOrderstate()))){
			this.log.info("订单状态为："+baseOrder.getOrderstate()+",不是待付款或订单取消状态，不能进行处理！");
			return true;
		}
		UserThirdPay thirdPay = userThirdPayDAO.getUserThirdPayByOrderSn(baseOrderSn);
		if(thirdPay == null){
			this.log.info("订单记录不存在");
			return false;
		} 
		//判断金额是否和页面提交金额一致
		BigDecimal cmoney = baseOrder.getSellprice().multiply(new BigDecimal("100"));
		if(new BigDecimal(notify.getTotal_fee()).compareTo(cmoney) != 0){
			log.info("回调通知金额"+notify.getTotal_fee()+"和页面提交金额"+cmoney+"不一致");
			return false;
		}
		//获取用户编号
		String muserId = baseOrder.getUserInfo().getUserId();
		//取得支付状态
		String trade_status = notify.getResult_code();
		String third_no = notify.getTransaction_id();   //微信订单号
		//支付成功
		if("SUCCESS".equals(trade_status) 
				|| "SUCCESS".equals(trade_status)){
			
			
			//给用户账户转账（手机用户+）
			bill(muserId, baseOrder.getSellprice(), baseOrderSn);
			//手机用户转账给商户（手机用户+,商户-）
			transferBill(baseOrder);
			
			//微信支付此时的金额为分，应转成元
			thirdPay.setState("2");
			thirdPay.setPaytime(new Date());
			thirdPay.setThirdordersn(third_no);
			userThirdPayDAO.update(thirdPay);
			
			updateOrderState(baseOrder, muserId);
			
			 //发放代金券
		    new OrderSendTicketThread(
		    		yxjUserCouponGrantConfigService
		    		, muserId
		    		, baseOrder.getBaseordersn())
		    .start();
			
		}else{
			thirdPay.setState("3");
			thirdPay.setPaytime(new Date());
			thirdPay.setThirdordersn(third_no);
			userThirdPayDAO.update(thirdPay);
		}
		return true;
	}
	
	private void updateOrderState(BaseOrderInfo baseOrder,String muserId){
		baseOrder.setOrderstate(Constants.ORDER_YES_PAY);
		baseOrder.setPaytime(new Date());
		baseOrderInfoDAO.update(baseOrder);
		
		
		List<OrderInfo> orderInfoList = orderInfoDAO.getListByBaseOrderSn(baseOrder.getBaseordersn());
		for(OrderInfo order:orderInfoList){
			order.setOrderstate(Constants.ORDER_YES_PAY);
			order.setPaytime(new Date());
			orderInfoDAO.update(order);
			
			if("1".equals(order.getCouponflag())
					&& order.getCouponamt().doubleValue() > 0){
				CouponUseInfo couponUse = new CouponUseInfo();
				couponUse.setUserInfo(order.getUserInfo());
				couponUse.setState("3");
				couponUse.setOrdersn(order.getOrdersn());
				couponUseInfoDAO.update(couponUse);
			}
			
			UserInfo persistUser = userInfoDAO.getById(muserId);
			//如果是一份购订单
			if("1".equals(order.getIsOnecent()) && "0".equals(persistUser.getIsOnecent())){
				persistUser.setIsOnecent("1");
				userInfoDAO.updateUser(persistUser);
			}else if("1".equals(persistUser.getIsfreshman())){
				persistUser.setIsfreshman("0");
				userInfoDAO.updateUser(persistUser);
			}
			
			
			Orderprocessinfo orderprocessinfo = new Orderprocessinfo();
		    orderprocessinfo.setOrdersn(order.getOrdersn());
		    orderprocessinfo.setProcessdesc("订单支付成功");
		    orderprocessinfo.setProcessid(IdGenerator.instance().generate(""));
		    orderprocessinfo.setProcesstime(DateUtil.toStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		    orderprocessinfo.setLogisticsstate("1");
		    orderprocessinfoDAO.insert(orderprocessinfo);
		    
			
		}
	}
	//转账操作
	private void transferBill(BaseOrderInfo baseOrder) throws Exception{
		String orderSn = baseOrder.getBaseordersn();
		String cuserId = baseOrder.getUserInfo().getUserId();
        //获取用户锁
	
		BUserParam buserParam = new BUserParam();
		buserParam.setBuserId(baseOrder.getBusinessUser().getBuserId());
		buserParam.setBillsflag("0");
		buserParam.setOperatemoney(baseOrder.getSellprice());
		buserParam.setOperatesn(orderSn);
		buserParam.setAmountbalance(null);
		buserParam.setOperatedesc("商城销售");
		buserParam.setRemark("");
		
		CUserParam cuserParam = new CUserParam();
		cuserParam.setUserId(cuserId);
		cuserParam.setOperatesn(orderSn);
		cuserParam.setOperatemoney(baseOrder.getSellprice());
		cuserParam.setAmountbalance(null);
		cuserParam.setBillsflag("1");
		cuserParam.setOperatedesc("商品购买");
		cuserParam.setRemark("");
		
		GiroParam giroParam = new GiroParam();
		giroParam.setBuserParam(buserParam);
		giroParam.setCuserParam(cuserParam);
		
	    billsHandleService.doAmountGiroHandle(giroParam);

	}
	
	//手机用户账单操作（微信充值）
	private void bill(String mid, BigDecimal amt, String orderSn) throws RuntimeException,Exception{
		//获取用户锁
	    CUserParam cuserParam = new CUserParam();
		cuserParam.setUserId(mid);
		cuserParam.setOperatesn(orderSn);
		cuserParam.setOperatemoney(amt);
		cuserParam.setAmountbalance(null);
		cuserParam.setBillsflag("0");
		cuserParam.setOperatedesc("微信充值");
		cuserParam.setRemark("微信支付时,先进行微信充值");
		
		billsHandleService.doCUserBillsHandle(cuserParam);
	
	}
	
	

	
}
