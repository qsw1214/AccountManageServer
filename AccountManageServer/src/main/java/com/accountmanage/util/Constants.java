package com.accountmanage.util;

public class Constants {

	/*-----------------------------  属性文件配置区域  ----------------------------------*/
	
	public static final String KD_PUSH_PROPERTIES = "/config/property/kdPush.properties";
	
	public static final String SMS_PROPERTIES = "/config/property/sms.properties";//短信接口
	
	public static final String PAYINTERFACE_PROPERTIES = "/config/property/payInterface.properties";
	
	
	/*-----------------------------  管理平台参数配置区域  ----------------------------------*/

	public static final String CONSOLE_SESSION = "adminInfo";//管理平台登录SESSION信息标识
	
	public static final String CONSOLE_LOGIN_TIME = "adminLoginTime";//平台登录时间
	
	public static final Integer PAGE_SIZE = 15 ;//查询每页条数
	
	/*#########################  权限管理参数区域 ##################################*/
	
	
	
	
	/*-----------------------------  订单标识区域  ----------------------------------*/
	
	
	
	/*-----------------------------  校验加密区域  ----------------------------------*/
	/**
	 * DES
	 */
	public static final String strDefaultKey = "36EDD707E7C5FFDA";
	
	public static final String ENC_BEFORE_KEY = "shenghuobanxiaoshi_supperScanner_2016";
	
	//订单标示
	//订单状态 0.初始 1.待付款 2.已支付 3.已发货 4.已到货 5.订单取消 6.退货中 7.已退货
	public static final String ORDER_INIT = "0";
	public static final String ORDER_NO_PAY = "1";
	public static final String ORDER_YES_PAY = "2";
	public static final String ORDER_SEND = "3";
	public static final String ORDER_ARRIVED = "4";
	public static final String ORDER_CANCEL = "5";
	public static final String ORDER_APPROVE_REFUND = "6";
	public static final String ORDER_ALREADY_REFUND_ = "7";
	
}
