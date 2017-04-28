package com.accountmanage.service.prod;

import java.util.List;
import java.util.Map;

import base.cn.web.mybatis.util.PageInfo;

import com.accountmanage.pojo.prod.ProdInfo;
import com.accountmanage.pojo.prod.ProdType;

public interface IProdInfoService {

	public List<ProdInfo> getProdInfoList();
	
	public PageInfo<ProdInfo> getPageListProdInfo(Map<String,String> paramsMap);
	
	public List<ProdInfo> getProdInfoListByType(String type);
	
	/**
	 * 如果level为NULL则查询全部级别
	 * @param level
	 * @return
	 */
	public List<ProdType> getProdTypeList(String level);
	/**
	 * 获取商品详情接口
	 * 
	 */
	public ProdInfo getProdInfoById(String prodId);
	
}
