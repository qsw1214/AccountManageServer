package com.accountmanage.network.util;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.accountmanage.web.pinjun.network.util.WebUtil;


public class ConnectUtil {
	private static  Logger logger = Logger.getLogger(ConnectUtil.class);
	public String excute(String url,List<NameValuePair> formparams)throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(10000)//连接超时时间（连接初始化时间）
													 .setSocketTimeout(30000)//读取数据超时时间
													 .build();
		try{
			UrlEncodedFormEntity reqEntity = new UrlEncodedFormEntity(formparams, "UTF-8"); 
			HttpPost post = new HttpPost(url);
			post.setEntity(reqEntity);
			post.setConfig(config);
			
			CloseableHttpResponse httpResponse = httpClient.execute(post);
			try{
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				if(statusCode == 200){
					HttpEntity entity = httpResponse.getEntity();
					if(entity != null){
						return EntityUtils.toString(entity,"UTF-8");
					}else{
						logger.info("entity返回为空！！");
					}
				}else{
					throw new Exception("statusCode = " + statusCode);
				}
			}finally{
				httpResponse.close();
			}
		}finally{
			if(httpClient != null){
				httpClient.close();
			}
		}
		return null;
	}
	
	
	
	public String excuteStr(String url,String reqStr,String dataFormat)throws Exception{
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(10000)//连接超时时间（连接初始化时间）
													 .setSocketTimeout(30000)//读取数据超时时间
													 .build();
		try{
			
			StringEntity entity = new StringEntity(reqStr,
					WebUtil.getContentType(dataFormat));
			HttpPost post = new HttpPost(url);
			post.setEntity(entity);
			post.setConfig(config);
			
			CloseableHttpResponse httpResponse = httpClient.execute(post);
			try{
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				if(statusCode == 200){
					HttpEntity retentity = httpResponse.getEntity();
					if(retentity != null){
						return EntityUtils.toString(retentity,"UTF-8");
					}else{
						logger.info("entity返回为空！！");
					}
				}else{
					throw new Exception("statusCode = " + statusCode);
				}
			}finally{
				httpResponse.close();
			}
		}finally{
			if(httpClient != null){
				httpClient.close();
			}
		}
		
		return null;
		
	}
	
	private String doResponse(HttpResponse res)throws Exception{
		int code = res.getStatusLine().getStatusCode();
		if (code == 200) {
			HttpEntity entity = res.getEntity();
			if (entity.getContentLength() == 0) {
				throw new Exception("business-Interface no response data!");
			}
			return WebUtil.stream2Str(entity.getContent());
		} else {
			throw new Exception("Request vipapis interface Exception【" + code + "】！");
		}
	}
	
	/*private CloseableHttpClient getHttpClient(){
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();        
		cm.setMaxTotal(6);//连接池最大并发连接数        
		cm.setDefaultMaxPerRoute(3);//单路由最大并发数(即指定的某一个ip)
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
		
		return httpClient;
	}*/
}
