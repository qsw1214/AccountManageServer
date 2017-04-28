package com.accountmanage.network.sms.dahan;

import static com.accountmanage.util.Constants.SMS_PROPERTIES;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import base.cn.util.UUIDGenerator;

import com.accountmanage.util.PropertyManager;
import com.dahantc.api.sms.json.JSONHttpClient;
import com.dahantc.api.sms.json.SmsData;

public class SMSDahanSigleSend {

	private static PropertyManager proManager = PropertyManager.instance();
	private static String ACCOUNT = null;
	private static String PSWD = null;
	private static String URL = null;
	private static String SUBCODE = null;
	private static String SIGN = "【优鲜季】";
	
	private static String BATCH_ACCOUNT = null;
	private static String BATCH_SUBCODE = null;
	private static String BATCH_PSWD = null;
	
	private static Logger log = Logger.getLogger(SMSDahanSigleSend.class);

	static {
		ACCOUNT = proManager.getValue(SMS_PROPERTIES, "dahan.account", true);
		PSWD = proManager.getValue(SMS_PROPERTIES, "dahan.password", true);
		URL = proManager.getValue(SMS_PROPERTIES, "dahan.send.url", true);
		SUBCODE = proManager.getValue(SMS_PROPERTIES, "dahan.subcode", true);
		
		BATCH_ACCOUNT = proManager.getValue(SMS_PROPERTIES, "batch.dahan.account", true);
		BATCH_SUBCODE = proManager.getValue(SMS_PROPERTIES, "batch.dahan.subcode", true);
		BATCH_PSWD = proManager.getValue(SMS_PROPERTIES, "batch.dahan.password", true);
		
		
	}
	
	/**
	 * 发短信
	 * */
	public static String send(String mobiles, String content) throws Exception{
		JSONHttpClient jsonHttpClient = new JSONHttpClient(URL);
		jsonHttpClient.setRetryCount(1);
		String sendhRes = jsonHttpClient.sendSms(ACCOUNT, PSWD, mobiles, content, SIGN,SUBCODE, UUIDGenerator.getUUID());
		log.info("提交单条普通短信响应：" + sendhRes);
		return sendhRes;
	}
	
	
	/**
	 * 批量发短信
	 * */
	public static String sendBatchSms(String mobiles, String content) throws Exception{

		 JSONHttpClient jsonHttpClient = new JSONHttpClient(URL);
		 
		 List<SmsData> list = new ArrayList<SmsData>();
		 list.add(new SmsData(mobiles,
		 content, UUIDGenerator.getUUID(), SIGN, BATCH_SUBCODE
		 , ""));

		 String sendBatchRes = jsonHttpClient.sendBatchSms(BATCH_ACCOUNT, BATCH_PSWD, list);
		 log.info("提交批量短信响应：" + sendBatchRes);
		
		 //String reportRes = jsonHttpClient.getReport(ACCOUNT, PSWD);
		 //log.info("获取状态报告响应：" + reportRes);
		
		 //String smsRes = jsonHttpClient.getSms(ACCOUNT, PSWD);
		 //log.info("获取上行短信响应：" + smsRes);

		
		return sendBatchRes;
	}
	
	
	public static void main(String[] args) throws Exception{
		sendBatchSms("13671277367,18601245439,18618126334", "小主～！您的账户里多了35元红包，进入优鲜季微信商城我的-红包查看吧！回复TD退订");
	}
}
