package com.accountmanage.service.prod;

import java.util.List;

import com.accountmanage.pojo.prod.ProdDetailInfo;

public interface IProdDetailInfoService {

	public List<ProdDetailInfo> getListProdDetailInfoByProdId(String prodId);
	
}
