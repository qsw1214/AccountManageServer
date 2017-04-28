package network;

import org.junit.Test;

import com.accountmanage.util.GsonTools;
import com.accountmanage.util.vo.BaseReturnMsg;
import com.accountmanage.web.pinjun.network.PjQueryOrderTrade;
import com.accountmanage.web.pinjun.network.vo.PjQueryOrderRequest;
import com.accountmanage.web.pinjun.network.vo.PjRequestConfig;

public class TestPinjun {

	@Test
	public void testQueryTrace() throws Exception{
		PjQueryOrderRequest request = new PjQueryOrderRequest();
		request.setOrderSn("216932654420000118");
		
		PjRequestConfig reqConfig = new PjRequestConfig(
				"pjbest.logistics.order.DeliveryOrderService",
				"getDeliveryOrderTraceByOrderSn", 
				GsonTools.getJsonString(request));
	
		BaseReturnMsg res = new PjQueryOrderTrade().execute(reqConfig);
		
		if(res != null){
			System.out.println(GsonTools.getJsonString(res));
		}
		
	}
	
	
	
}














