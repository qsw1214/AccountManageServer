package com.accountmanage.dao.order;

import com.accountmanage.pojo.order.YxjUserCouponGrantConfig;


public interface IYxjUserCouponGrantConfigDAO {
	
	YxjUserCouponGrantConfig findGrantConfig(
			String configFlag);
	
    
}