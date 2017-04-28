package com.accountmanage.dao.system;

import com.accountmanage.pojo.system.yxj_system_sms_config;

public interface IyxjSystemSmsConfigDAO {

	public yxj_system_sms_config getSysSmsConfigByPointCode(String pointCode);
}
