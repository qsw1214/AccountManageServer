package com.accountmanage.service.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.dao.system.ISubStoreInfoDAO;
import com.accountmanage.service.system.ISubStoreInfoService;

@Service("subStoreInfo")
public class ISubStoreInfoServiceImpl implements ISubStoreInfoService {

		@Resource
		private ISubStoreInfoDAO subStoreInfoDAO;
		
}
