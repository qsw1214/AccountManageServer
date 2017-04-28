package bills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import base.cn.util.IdGenerator;

import com.accountmanage.util.GsonTools;
import com.accountmanage.web.bills.util.parambean.CUserParam;

public class TestCuserBillsRequest {
	
	public void cuserSend(){
		CUserParam cuserParam = new CUserParam();
		
		cuserParam.setUserId("8eb87273e4dd4f8c90a93972ad6d680b");
		cuserParam.setOperatesn(IdGenerator.instance().generate());
		cuserParam.setOperatemoney(new BigDecimal(10));
		cuserParam.setBillsflag("0");
		cuserParam.setOperatedesc("用户充值");
		
		String json_cuserBills = GsonTools.getJsonString(cuserParam);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("json_cuserBills", json_cuserBills)); 
		
		
		String url = "http://localhost:9290/AccountManageServer/orderBills/cuserBillsControl";
		
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
		
		cuserParam.setUserId("1");
		cuserParam.setOperatesn(IdGenerator.instance().generate());
		cuserParam.setOperatemoney(new BigDecimal(10));
		cuserParam.setBillsflag("0");
		cuserParam.setOperatedesc("用户充值");
		
		String json_cuserBills = GsonTools.getJsonString(cuserParam);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("json_cuserBills", json_cuserBills)); 
		
		
		String url = "http://localhost:9290/AccountManageServer/orderBills/cuserBillsControl";
		
		HttpTools tools = new HttpTools();
		try {
			String str = tools.excute(url,formparams);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
