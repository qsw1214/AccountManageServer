package com.accountmanage.dao.prod;

import java.util.List;
import java.util.Map;

import com.accountmanage.pojo.prod.ProdInfo;



public interface IProdInfoDAO {
	
	   public ProdInfo getById(String prodId);
	   
	   public List<ProdInfo> getProdInfoList();
	   
	   public List<ProdInfo> getProdInfoListByParamsMap(Map<String,String> paramsMap);
	   
	   public List<ProdInfo> getProdInfoListByType(String type);
	   
	   
   
}
