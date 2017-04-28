package com.accountmanage.service.prod.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountmanage.dao.prod.IActivityProdInfoDAO;
import com.accountmanage.service.prod.IActivityProdInfoService;

@Service("activityProdInfoService")
public class ActivityProdInfoServiceImpl implements IActivityProdInfoService {

	@Resource
	private IActivityProdInfoDAO activityProdInfoDAO;
}
