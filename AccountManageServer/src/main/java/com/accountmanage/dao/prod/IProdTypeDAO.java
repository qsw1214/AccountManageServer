package com.accountmanage.dao.prod;

import java.util.List;

import com.accountmanage.pojo.prod.ProdType;



public interface IProdTypeDAO{
	
	public List<ProdType> getProdTypeList(String level) ;
	


}
