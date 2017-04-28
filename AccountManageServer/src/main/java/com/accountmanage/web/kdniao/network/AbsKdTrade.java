package com.accountmanage.web.kdniao.network;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.log4j.Logger;

import com.accountmanage.network.util.ConnectUtil;
import com.accountmanage.util.vo.BaseReturnMsg;
import com.accountmanage.web.kdniao.network.vo.KdBaseRequest;

public abstract class AbsKdTrade {
    
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 生成请求参数
	 * */
	protected abstract List<NameValuePair> getRequestParams(KdBaseRequest request) throws Exception;
	
	/**
	 * 组织请求串
	 * @throws Exception 
	 * */
	protected List<NameValuePair> getVerifyString(KdBaseRequest request) throws Exception{
		
		List<NameValuePair> tempPairs = this.getRequestParams(request);
		
		return tempPairs;
	}
	
	
	/**
	 * 交易请求应答
	 * */
	public BaseReturnMsg execute(KdBaseRequest request) throws Exception{
		List<NameValuePair> pairs = this.getVerifyString(request);
		String res =  new ConnectUtil().excute(request.getReqUrl(),pairs);
		this.log.info("返回串："+res);
		return this.toParseResponse(res);

	}
	
	
	/**
	 * 解析应答串
	 * */
	protected abstract BaseReturnMsg toParseResponse(String responseString)throws Exception;

}
