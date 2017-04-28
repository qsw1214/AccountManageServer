package bills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import base.cn.util.IdGenerator;

import com.accountmanage.util.GsonTools;
import com.accountmanage.web.bills.util.parambean.BUserParam;
import com.accountmanage.web.bills.util.parambean.CUserParam;
import com.accountmanage.web.bills.util.parambean.GiroParam;

public class TestGiroBillsRequest {
	
	public void giroBillSend(){
		CUserParam cuserParam = new CUserParam();
		
		cuserParam.setUserId("8eb87273e4dd4f8c90a93972ad6d680b");
		cuserParam.setOperatesn(IdGenerator.instance().generate());
		cuserParam.setOperatemoney(new BigDecimal(10));
		cuserParam.setBillsflag("1");
		cuserParam.setOperatedesc("商品购买");
		
		BUserParam buserParam = new BUserParam();
		buserParam.setBuserId("1");
		buserParam.setOperatesn(IdGenerator.instance().generate());
		buserParam.setOperatemoney(new BigDecimal(10));
		buserParam.setBillsflag("0");
		buserParam.setOperatedesc("商城销售");
		
		GiroParam giroParam = new GiroParam();
		giroParam.setCuserParam(cuserParam);
		giroParam.setBuserParam(buserParam);
		
		String json_giroBills = GsonTools.getJsonString(giroParam);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("json_giroBills", json_giroBills)); 
		
		
		String url = "http://localhost:9290/AccountManageServer/orderBills/giroBillsControl";
		
		HttpTools tools = new HttpTools();
		try {
			String str = tools.excute(url,formparams);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String []args){
		CUserParam cuserParam = new CUserParam();
		
		cuserParam.setUserId("8eb87273e4dd4f8c90a93972ad6d680b");
		cuserParam.setOperatesn(IdGenerator.instance().generate());
		cuserParam.setOperatemoney(new BigDecimal(10));
		cuserParam.setBillsflag("1");
		cuserParam.setOperatedesc("商品购买");
		
		BUserParam buserParam = new BUserParam();
		buserParam.setBuserId("1");
		buserParam.setOperatesn(IdGenerator.instance().generate());
		buserParam.setOperatemoney(new BigDecimal(10));
		buserParam.setBillsflag("0");
		buserParam.setOperatedesc("商城销售");
		
		GiroParam giroParam = new GiroParam();
		giroParam.setCuserParam(cuserParam);
		giroParam.setBuserParam(buserParam);
		
		String json_giroBills = GsonTools.getJsonString(giroParam);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("json_giroBills", json_giroBills)); 
		
		
		String url = "http://localhost:9290/AccountManageServer/orderBills/giroBillsControl";
		
		HttpTools tools = new HttpTools();
		try {
			String str = tools.excute(url,formparams);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
