package com.accountmanage.dao.prod;

import java.util.List;

import com.accountmanage.pojo.prod.ProdDetailInfo;

public interface IProdDetailInfoDAO {

	public List<ProdDetailInfo> getProdDetailInfoList(String prodId);
	
}
