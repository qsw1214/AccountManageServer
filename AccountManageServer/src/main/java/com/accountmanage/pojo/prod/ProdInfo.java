package com.accountmanage.pojo.prod;

import java.math.BigDecimal;
import java.util.Date;

import com.accountmanage.pojo.bills.BusinessUserInfo;

public class ProdInfo {

	 private String prodid;//'商品ID',
	 private String prodname;//'商品名称',
	 private BigDecimal sellPrice;//'商品会员价格',
	 private BigDecimal valuePrice;//'商品普通价格'
	 private String typeid;//'商品类别ID',
	 private Integer prodstock;//商品库存',
	 private String imageUrl;//'商品默认图片,
	 private ProdDetailInfo detailInfo;//'商品详情信息ID',
	 private String weight;//'商品重量',
	 private String cpackage;//'商品包装',
	 private String remark;//'商品备注',
	 private String preSellTag;//'销售标记 1.现售 2.预售',
	 private String prodUnit;//'商品单位'
	 private Date preSellTime;//'预售时间'
	 private BusinessUserInfo businessUser;//所属商户
	 private String ishome;//'是否为首页 0.不是  1.是'
	 private String isfreshman;//'是否为新人 0.不是 1.是'
	 private BigDecimal freshmanprice;//新人价格
	 
	 
	 
	public String getIshome() {
		return ishome;
	}
	public void setIshome(String ishome) {
		this.ishome = ishome;
	}
	public String getIsfreshman() {
		return isfreshman;
	}
	public void setIsfreshman(String isfreshman) {
		this.isfreshman = isfreshman;
	}
	public BigDecimal getFreshmanprice() {
		return freshmanprice;
	}
	public void setFreshmanprice(BigDecimal freshmanprice) {
		this.freshmanprice = freshmanprice;
	}
	public BusinessUserInfo getBusinessUser() {
		return businessUser;
	}
	public void setBusinessUser(BusinessUserInfo businessUser) {
		this.businessUser = businessUser;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
	public BigDecimal getValuePrice() {
		return valuePrice;
	}
	public void setValuePrice(BigDecimal valuePrice) {
		this.valuePrice = valuePrice;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public Integer getProdstock() {
		return prodstock;
	}
	public void setProdstock(Integer prodstock) {
		this.prodstock = prodstock;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public ProdDetailInfo getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(ProdDetailInfo detailInfo) {
		this.detailInfo = detailInfo;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getCpackage() {
		return cpackage;
	}
	public void setCpackage(String cpackage) {
		this.cpackage = cpackage;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPreSellTag() {
		return preSellTag;
	}
	public void setPreSellTag(String preSellTag) {
		this.preSellTag = preSellTag;
	}
	public String getProdUnit() {
		return prodUnit;
	}
	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}
	public Date getPreSellTime() {
		return preSellTime;
	}
	public void setPreSellTime(Date preSellTime) {
		this.preSellTime = preSellTime;
	}
	
	 
	
	
	
}
