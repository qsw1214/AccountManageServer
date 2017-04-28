package bills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import base.cn.util.IdGenerator;

import com.accountmanage.util.GsonTools;
import com.accountmanage.web.bills.util.parambean.BUserParam;

public class TestBuserBillsRequest {
	
	public void buserBillsend(){
		BUserParam buserParam = new BUserParam();
		
		buserParam.setBuserId("1");
		buserParam.setOperatesn(IdGenerator.instance().generate());
		buserParam.setOperatemoney(new BigDecimal(100));
		buserParam.setBillsflag("2");
		buserParam.setOperatedesc("代金券调额");
		
		String json_buserBills = GsonTools.getJsonString(buserParam);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("json_buserBills", json_buserBills)); 
		
		
		String url = "http://localhost:9290/AccountManageServer/orderBills/buserBillsControl";
		
		HttpTools tools = new HttpTools();
		try {
			String str = tools.excute(url,formparams);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String []args){
		BUserParam buserParam = new BUserParam();
		
		buserParam.setBuserId("1");
		buserParam.setOperatesn(IdGenerator.instance().generate());
		buserParam.setOperatemoney(new BigDecimal(100));
		buserParam.setBillsflag("0");
		buserParam.setOperatedesc("账户调额");
		
		String json_buserBills = GsonTools.getJsonString(buserParam);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("json_buserBills", json_buserBills)); 
		
		
		String url = "http://localhost:8080/AccountManageServer/orderBills/buserBillsControl";
		
		HttpTools tools = new HttpTools();
		try {
			String str = tools.excute(url,formparams);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
