package com.accountmanage.service.prod.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accountmanage.dao.prod.IProdDetailInfoDAO;
import com.accountmanage.dao.prod.IProdInfoDAO;
import com.accountmanage.dao.prod.IProdTypeDAO;
import com.accountmanage.pojo.prod.ProdDetailInfo;
import com.accountmanage.pojo.prod.ProdInfo;
import com.accountmanage.pojo.prod.ProdType;
import com.accountmanage.service.prod.IProdDetailInfoService;

@Service("prodDetailInfoService")
public class ProdDetailInfoServiceImpl implements IProdDetailInfoService {

	@Resource
	private IProdDetailInfoDAO prodDetailInfoDAO;

	@Override
	public List<ProdDetailInfo> getListProdDetailInfoByProdId(String prodId) {
		
		return prodDetailInfoDAO.getProdDetailInfoList(prodId);
	}
			
}
