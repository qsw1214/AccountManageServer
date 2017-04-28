package com.accountmanage.network.sms.yunxin;

import static com.accountmanage.util.Constants.SMS_PROPERTIES;

import com.accountmanage.util.PropertyManager;

public class SMSYunxinUtil {

	private static PropertyManager proManager = PropertyManager.instance();
	private static String URL = null;
	private static String ACCOUNT = null;
	private static String PSWD = null;
	private static String DHURL = null;
	private static String DHACCOUNT = null;
	private static String DHPSWD = null;

	static {
		
		URL = proManager.getValue(SMS_PROPERTIES, "yunxin.send.url", true);
		ACCOUNT = proManager.getValue(SMS_PROPERTIES, "yunxin.account", true);
		PSWD = proManager.getValue(SMS_PROPERTIES, "yunxin.pswd", true);
		
		DHURL = proManager.getValue(SMS_PROPERTIES, "dahan.send.url", true);
		DHACCOUNT = proManager.getValue(SMS_PROPERTIES, "dahan.account", true);
		DHPSWD = proManager.getValue(SMS_PROPERTIES, "dahan.password", true);
	}
	
	/**
	 * 发短信
	 * */
	public static String send(String smsType,String mobiles, String content) throws Exception{
		SendSMSYunxin ss = new SendSMSYunxin();
		String msg = "";
		if(smsType.equals("YX")){
			msg = ss.send(ACCOUNT,PSWD,URL,mobiles,content);
		}else if(smsType.equals("DH")){
			msg = ss.send(DHACCOUNT,DHPSWD,DHURL,mobiles,content);
		}
		return msg;
	}
	
}
