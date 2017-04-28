package com.accountmanage.web.wechat.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accountmanage.pojo.wechat.WechatNotifyModel;
import com.accountmanage.service.wechat.WechatNotifyForPayService;
import com.accountmanage.web.wechat.util.Signature;



/**
 * 订单支付微信回调通知
 * @author rg
 */
@Controller
@RequestMapping("/wechat")
public class WechatNotifyForPayController {

	@Resource
	private WechatNotifyForPayService wechatNotifyForPayService;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private boolean returnSign;
	
	public void setReturnSign(boolean returnSign) {
		this.returnSign = returnSign;
	}
	
	@RequestMapping(value = "/forpay", method = RequestMethod.POST)
	public void toSendDispose(HttpServletRequest request,HttpServletResponse response){
		this.logger.info("接入微信订单支付接口的IP:" + request.getRemoteHost());
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			this.doDispose(request, response);
		}catch(Exception e){
			//如果失败返回给微信信息
			Element root = DocumentHelper.createDocument().addElement("xml");
			root.addElement("return_code").addCDATA("FAIL");
			root.addElement("return_msg").addCDATA("");
			sendResponseMsg(response,root.asXML());
			e.printStackTrace();
		}
	}
	
	/**
	 * 报文接收与回复处理
	 * */
	private void doDispose(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		
		Element root = DocumentHelper.createDocument().addElement("xml");
		WechatNotifyModel notify = buildNotify(request);;
		//验证微信签名
		if(returnSign){
			if("SUCCESS".equals(notify.getReturn_code()) && "SUCCESS".equals(notify.getResult_code())){			
				boolean isOk = wechatNotifyForPayService.doWechatNotifyForPay(notify);
				if(isOk){
					root.addElement("return_code").addCDATA("SUCCESS");
					root.addElement("return_msg").addCDATA("OK");
				} else {
					//如果失败返回给微信信息
					root.addElement("return_code").addCDATA("FAIL");
					root.addElement("return_msg").addCDATA("");
				}
				logger.info("微信支付结果:"+root.asXML());
				sendResponseMsg(response,root.asXML());
			}else{
				logger.info("微信支付返回结果有误！");
			}
		}else{
			root.addElement("return_code").addCDATA("FAIL");
			root.addElement("return_msg").addCDATA("签名不正确");
			logger.info("签名不正确！");
		}
	}
	
	public Map<String, String> parseXml(HttpServletRequest request) 
			throws Exception {
			    // 解析结果存储在HashMap
			    Map<String, String> map = new HashMap<String, String>();
			    InputStream inputStream = request.getInputStream();
			    // 读取输入流
			    SAXReader reader = new SAXReader();
			    Document document = reader.read(inputStream);
			    
			    // 得到xml根元素
			    Element root = document.getRootElement();
			    // 得到根元素的所有子节点
			    List<Element> elementList = root.elements();
			 
			    // 遍历所有子节点
			    logger.info("=============== wechat 参数 开始 =================");
			    for (Element e : elementList){
			        map.put(e.getName(), e.getText());
			        logger.info("name = " + e.getName() + ", value = " + e.getText());
			    }    
			    logger.info("=============== wechat 参数 结束 =================");   
			 
			    setReturnSign(Signature.checkIsSignValidFromResponseString(root.asXML()));
			    // 释放资源
			    inputStream.close();
			    inputStream = null;
			 
			    return map;
	}
	
	private WechatNotifyModel buildNotify(HttpServletRequest request)throws Exception{
		Map<String,String> paramsMap = parseXml(request);
		WechatNotifyModel newWechatNotifyModel = new WechatNotifyModel();
		newWechatNotifyModel.setReturn_code(paramsMap.get("return_code"));
		newWechatNotifyModel.setReturn_msg(paramsMap.get("return_msg"));
		if("SUCCESS".equals(newWechatNotifyModel.getReturn_code())){
			
			newWechatNotifyModel.setAppid(paramsMap.get("appid"));
			newWechatNotifyModel.setMch_id(paramsMap.get("mch_id"));
			newWechatNotifyModel.setNonce_str(paramsMap.get("nonce_str"));
			newWechatNotifyModel.setSign(paramsMap.get("sign"));
			newWechatNotifyModel.setResult_code(paramsMap.get("result_code"));
			newWechatNotifyModel.setErr_code(paramsMap.get("err_code"));
			newWechatNotifyModel.setErr_code_des(paramsMap.get("err_code_des"));
			newWechatNotifyModel.setDevice_info(paramsMap.get("device_info"));

			if("SUCCESS".equals(newWechatNotifyModel.getResult_code())){
				newWechatNotifyModel.setOpenid(paramsMap.get("openid"));
				newWechatNotifyModel.setIs_subscribe(paramsMap.get("is_subscribe"));
				newWechatNotifyModel.setTrade_type(paramsMap.get("trade_type"));
				newWechatNotifyModel.setBank_type(paramsMap.get("bank_type"));
				newWechatNotifyModel.setTotal_fee(paramsMap.get("total_fee"));
				newWechatNotifyModel.setCoupon_fee(paramsMap.get("coupon_fee"));
				newWechatNotifyModel.setFee_type(paramsMap.get("fee_type"));
				newWechatNotifyModel.setTransaction_id(paramsMap.get("transaction_id"));
				newWechatNotifyModel.setOut_trade_no(paramsMap.get("out_trade_no"));
				newWechatNotifyModel.setAttach(paramsMap.get("attach"));
				newWechatNotifyModel.setTime_end(paramsMap.get("time_end"));
			}
		}
		
		return newWechatNotifyModel;
	}
	
	/**
	 * 发送应答信息
	 * */
	private void sendResponseMsg(HttpServletResponse response,String state){
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.write(state);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			printWriter.close();
		}
	}
	
	
	
	
	
	
}
