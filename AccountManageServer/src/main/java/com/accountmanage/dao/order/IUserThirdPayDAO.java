package com.accountmanage.dao.order;

import com.accountmanage.pojo.order.UserThirdPay;


public interface IUserThirdPayDAO {

	public UserThirdPay getUserThirdPayByOrderSn(String orderSn);
	
	public void update(UserThirdPay thirdPay);
}
