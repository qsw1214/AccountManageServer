package com.accountmanage.service.prod.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.dao.prod.ICouponRuleInfoDAO;

@Service("couponRuleInfoService")
public class CouponRuleInfoServiceImpl {

	@Resource
	private ICouponRuleInfoDAO couponRuleInfoDAO;
}
