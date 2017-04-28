package com.accountmanage.web.kdniao.network;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.accountmanage.util.Base64Util;
import com.accountmanage.util.Constants;
import com.accountmanage.util.GsonTools;
import com.accountmanage.util.MD5Tools;
import com.accountmanage.util.PropertyManager;
import com.accountmanage.util.vo.BaseReturnMsg;
import com.accountmanage.web.kdniao.network.vo.KdBaseRequest;
import com.accountmanage.web.kdniao.network.vo.KdSubscriptionResponse;

public class KdSubscriptionTrade extends AbsKdTrade {

	@Override
	protected List<NameValuePair> getRequestParams(KdBaseRequest request)
			throws Exception {
		PropertyManager pm = PropertyManager.instance();

		List<NameValuePair> tempPairs = new ArrayList<NameValuePair>();
		
		tempPairs.add(new BasicNameValuePair("RequestData",request.getRequestData()));
		tempPairs.add(new BasicNameValuePair("EBusinessID",pm.getValue(Constants.KD_PUSH_PROPERTIES, "kdniao_EBusinessID")));
		tempPairs.add(new BasicNameValuePair("RequestType","1008"));
		String md5String = MD5Tools.getKeyedDigest(request.getRequestData(), pm.getValue(Constants.KD_PUSH_PROPERTIES, "kdniao_appkey"));
		tempPairs.add(new BasicNameValuePair("DataSign",Base64Util.Encode(md5String)));
		tempPairs.add(new BasicNameValuePair("DataType",pm.getValue(Constants.KD_PUSH_PROPERTIES, "kdniao_dataType")));
		
		return tempPairs;
	}

	@Override
	protected BaseReturnMsg toParseResponse(String responseString)
			throws Exception {
		
		if(responseString!=null && !"".equals(responseString) && responseString.startsWith("{")){
			
			KdSubscriptionResponse  response = (KdSubscriptionResponse)GsonTools.getSignObject(responseString, KdSubscriptionResponse.class);
			return new BaseReturnMsg(response.isSuccess(), response.getReason());
	    
		}else{
	    	return new BaseReturnMsg(false, "");
	    }
	}

	
	
	
	
	
}
