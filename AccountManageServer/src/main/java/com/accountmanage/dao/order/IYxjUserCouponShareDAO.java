package com.accountmanage.dao.order;

import com.accountmanage.pojo.order.YxjUserCouponShare;

public interface IYxjUserCouponShareDAO {
    
	/**
	 * 根据总单号查询红包信息
	 * @param baseOrderSn
	 * @return
	 */
	public YxjUserCouponShare findCouponShareByOrdersn(String baseOrderSn);
	
	/**
	 * 根据红包ID验证该红包是否过期
	 * @param shareId
	 * @return
	 */
	public YxjUserCouponShare validateTimeEndByShareId(String shareId);
	
	
	int insert(YxjUserCouponShare yxjUserCouponShare);
	
}