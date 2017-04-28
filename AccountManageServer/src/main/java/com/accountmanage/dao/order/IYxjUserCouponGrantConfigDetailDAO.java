package com.accountmanage.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accountmanage.pojo.order.YxjUserCouponGrantConfigDetail;


public interface IYxjUserCouponGrantConfigDetailDAO {
	
	List<YxjUserCouponGrantConfigDetail> findListGrantConfigDetail(
			@Param("configId")String configId);
	
    
}