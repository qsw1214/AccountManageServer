package com.accountmanage.web.pinjun.network;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accountmanage.network.util.ConnectUtil;
import com.accountmanage.util.vo.BaseReturnMsg;
import com.accountmanage.web.pinjun.network.util.HmacUtils;
import com.accountmanage.web.pinjun.network.util.PjConstants;
import com.accountmanage.web.pinjun.network.util.WebUtil;
import com.accountmanage.web.pinjun.network.vo.PjRequestConfig;

public abstract class PjAbsTrade {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	protected Map<String,String> doSign(PjRequestConfig configure)throws Exception{
		
		Map<String,String> params = getSysParam(configure);
		String data = WebUtil.convertToSortStr(params) + configure.getBusinessData();
		System.out.println("data:" + data);
		String sign = HmacUtils.byte2hex(HmacUtils.encryptHMAC(data, configure.getAppSecrect()));
		System.out.println("签名结果：" + sign);
		params.put("sign", sign);
		return params;
	}
	
	protected Map<String,String> getSysParam(PjRequestConfig configure){
		Map<String, String> params = new HashMap<String, String>();
		params.put(PjConstants.SERVICE_NAME, configure.getService());//addressService-getChannelOrderList
		params.put(PjConstants.METHOD_NAME, configure.getMethod());
		params.put(PjConstants.TIMESTAMP, configure.getTimestamp());
		params.put(PjConstants.FORMAT, configure.getFormat());
		params.put(PjConstants.APP_KEY, configure.getAppKey());
		params.put(PjConstants.VERSION, configure.getVersion());
		return params;
	}
	
	
	

	/**
	 * 交易请求应答
	 * */
	public BaseReturnMsg execute(PjRequestConfig request) throws Exception{
		
		Map<String,String> sysParams = doSign(request);
		String url = request.getUrl()+"?"+WebUtil.getQueryString(sysParams);
		
		this.log.info("请求Url："+url);
		
		String pairs = this.getVerifyString(request);
		
		String res =  new ConnectUtil().excuteStr(url, pairs, "json");
		
		this.log.info("返回串："+res);
		
		return this.toParseResponse(res);

	}
	
	/**
	 * 生成请求参数
	 * */
	protected abstract String getRequestParams(PjRequestConfig request)throws Exception;
	
	/**
	 * 组织请求串
	 * @throws Exception 
	 * */
	protected String getVerifyString(PjRequestConfig request) throws Exception{
		
		return this.getRequestParams(request);
	}
	
	/**
	 * 解析应答串
	 * */
	protected abstract BaseReturnMsg toParseResponse(String responseString)throws Exception;

	
}
