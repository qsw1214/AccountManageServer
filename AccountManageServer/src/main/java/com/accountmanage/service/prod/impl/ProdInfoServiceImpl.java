package com.accountmanage.service.prod.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import base.cn.web.mybatis.plugin.PageInterceptor;
import base.cn.web.mybatis.util.PageInfo;

import com.accountmanage.dao.prod.IProdInfoDAO;
import com.accountmanage.dao.prod.IProdTypeDAO;
import com.accountmanage.pojo.prod.ProdInfo;
import com.accountmanage.pojo.prod.ProdType;
import com.accountmanage.service.prod.IProdInfoService;

@Service("prodInfoService")
public class ProdInfoServiceImpl implements IProdInfoService {

	@Resource
	private IProdInfoDAO prodInfoDAO;
	@Resource
	private IProdTypeDAO prodTypeDAO;

	@Override
	public List<ProdInfo> getProdInfoList() {

		return prodInfoDAO.getProdInfoList();
	}

	@Override
	public List<ProdType> getProdTypeList(String level) {
		return prodTypeDAO.getProdTypeList(level);
	}

	@Override
	public List<ProdInfo> getProdInfoListByType(String type) {
		
		return prodInfoDAO.getProdInfoListByType(type);
	}

	@Override
	public ProdInfo getProdInfoById(String prodId) {
		
		return prodInfoDAO.getById(prodId);
	}

	@Override
	public PageInfo<ProdInfo> getPageListProdInfo(Map<String, String> paramsMap) {
		PageInterceptor.startPage(Integer.parseInt(paramsMap.get("page")));
		prodInfoDAO.getProdInfoListByParamsMap(paramsMap);
		return PageInterceptor.endPage();
	}
		
}
