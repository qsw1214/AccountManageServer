package com.accountmanage.dao.order;

import com.accountmanage.pojo.order.UserThirdCharge;


public interface IUserThirdChargeDAO {

	public UserThirdCharge getUserThirdChargeByOrderSn(String chargeSn);
	
	public void update(UserThirdCharge thirdCharge);
}
