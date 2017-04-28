package com.accountmanage.web.kdniao.network.vo.bean;

public class KdSubscriptionReqBean {
	private String CallBack;//O	用户自定义回调信息
	private String MemberID;//O	会员标识(备用字段)
	private String WareHouseID;//O	仓库标识(备用字段)
	private String CustomerName;//O	电子面单客户账号（与快递网点申请）
	private String CustomerPwd;//O	电子面单密码
	private String SendSite;//O	收件网点标识
	private String ShipperCode;//R	快递公司编码
	private String LogisticCode;//R	快递单号
	private String OrderCode;//O	订单编号
	private String MonthCode;//O	月结编码
	private int PayType;//邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付
	private String ExpType;//O	快递类型：1-标准快件
	private Double Cost;//O	寄件费（运费）
	private Double OtherCost;//O	其他费用
	private ReceiverBean Receiver;
	private SenderBean Sender; 
	private String StartDate;
	private String EndDate;
	private Double Weight;
	private int Quantity;
	private Double Volume;
	private String Remark;
	private String IsNotice;
	private AddServiceBean AddService;
	private CommodityBean Commodity;
	public String getCallBack() {
		return CallBack;
	}
	public void setCallBack(String callBack) {
		CallBack = callBack;
	}
	public String getMemberID() {
		return MemberID;
	}
	public void setMemberID(String memberID) {
		MemberID = memberID;
	}
	public String getWareHouseID() {
		return WareHouseID;
	}
	public void setWareHouseID(String wareHouseID) {
		WareHouseID = wareHouseID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerPwd() {
		return CustomerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		CustomerPwd = customerPwd;
	}
	public String getSendSite() {
		return SendSite;
	}
	public void setSendSite(String sendSite) {
		SendSite = sendSite;
	}
	public String getShipperCode() {
		return ShipperCode;
	}
	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}
	public String getLogisticCode() {
		return LogisticCode;
	}
	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getMonthCode() {
		return MonthCode;
	}
	public void setMonthCode(String monthCode) {
		MonthCode = monthCode;
	}
	public int getPayType() {
		return PayType;
	}
	public void setPayType(int payType) {
		PayType = payType;
	}
	public String getExpType() {
		return ExpType;
	}
	public void setExpType(String expType) {
		ExpType = expType;
	}
	public Double getCost() {
		return Cost;
	}
	public void setCost(Double cost) {
		Cost = cost;
	}
	public Double getOtherCost() {
		return OtherCost;
	}
	public void setOtherCost(Double otherCost) {
		OtherCost = otherCost;
	}
	public ReceiverBean getReceiver() {
		return Receiver;
	}
	public void setReceiver(ReceiverBean receiver) {
		Receiver = receiver;
	}
	public SenderBean getSender() {
		return Sender;
	}
	public void setSender(SenderBean sender) {
		Sender = sender;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public Double getWeight() {
		return Weight;
	}
	public void setWeight(Double weight) {
		Weight = weight;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public Double getVolume() {
		return Volume;
	}
	public void setVolume(Double volume) {
		Volume = volume;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getIsNotice() {
		return IsNotice;
	}
	public void setIsNotice(String isNotice) {
		IsNotice = isNotice;
	}
	public AddServiceBean getAddService() {
		return AddService;
	}
	public void setAddService(AddServiceBean addService) {
		AddService = addService;
	}
	public CommodityBean getCommodity() {
		return Commodity;
	}
	public void setCommodity(CommodityBean commodity) {
		Commodity = commodity;
	}
	
	
	
	
	
}

