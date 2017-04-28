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

public class TestCouponGiroBillsRequest {

	public static void main(String []args){
CUserParam cuserParam = new CUserParam();
		
		cuserParam.setUserId("1");
		cuserParam.setOperatesn(IdGenerator.instance().generate());
		cuserParam.setOperatemoney(new BigDecimal(100));
		cuserParam.setBillsflag("0");
		cuserParam.setOperatedesc("代金券存入");
		
		BUserParam buserParam = new BUserParam();
		buserParam.setBuserId("1");
		buserParam.setOperatesn(IdGenerator.instance().generate());
		buserParam.setOperatemoney(new BigDecimal(100));
		buserParam.setBillsflag("3");
		buserParam.setOperatedesc("代金券支出");
		
		GiroParam giroParam = new GiroParam();
		giroParam.setCuserParam(cuserParam);
		giroParam.setBuserParam(buserParam);
		
		String json_couponGiroBills = GsonTools.getJsonString(giroParam);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("json_couponGiroBills", json_couponGiroBills)); 
		
		
		String url = "http://localhost:8080/AccountManageServer/orderBills/couponGiroBillsControl";
		
		HttpTools tools = new HttpTools();
		try {
			String str = tools.excute(url,formparams);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
