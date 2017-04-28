package com.accountmanage.service.prod.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.dao.prod.ICouponUseInfoDAO;
import com.accountmanage.service.prod.ICouponUseInfoService;

@Service("couponUseInfoService")
public class CouponUseInfoServiceImpl implements ICouponUseInfoService {

	@Resource
	private ICouponUseInfoDAO couponUseInfoDAO;
	
}
