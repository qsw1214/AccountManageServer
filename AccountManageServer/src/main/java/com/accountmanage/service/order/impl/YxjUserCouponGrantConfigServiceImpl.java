package com.accountmanage.service.order.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import base.cn.util.UUIDGenerator;

import com.accountmanage.dao.order.IYxjUserCouponGrantConfigDAO;
import com.accountmanage.dao.order.IYxjUserCouponGrantConfigDetailDAO;
import com.accountmanage.dao.order.IYxjUserCouponShareDAO;
import com.accountmanage.dao.order.IYxjUserCouponShareDetailDAO;
import com.accountmanage.pojo.order.YxjUserCouponGrantConfig;
import com.accountmanage.pojo.order.YxjUserCouponGrantConfigDetail;
import com.accountmanage.pojo.order.YxjUserCouponShare;
import com.accountmanage.pojo.order.YxjUserCouponShareDetail;
import com.accountmanage.pojo.prod.CouponRuleInfo;
import com.accountmanage.service.order.IYxjUserCouponGrantConfigService;
import com.accountmanage.util.DateUtil;



@Service("yxjUserCouponGrantConfigService")
public class YxjUserCouponGrantConfigServiceImpl implements IYxjUserCouponGrantConfigService {

	@Resource
	private IYxjUserCouponShareDAO yxjUserCouponShareDAO;
	
	@Resource
	private IYxjUserCouponShareDetailDAO yxjUserCouponShareDetailDAO;
	
    @Resource
    private IYxjUserCouponGrantConfigDAO yxjUserCouponGrantConfigDAO;
    
    @Resource
    private IYxjUserCouponGrantConfigDetailDAO yxjUserCouponGrantConfigDetailDAO;
	
	//支付完成发放红包
	@Override
	public void doGrantRedPacket(String shareUserId,String baseOrdersn) throws Exception{
		YxjUserCouponGrantConfig grantConfig = yxjUserCouponGrantConfigDAO.findGrantConfig("2");
		
		YxjUserCouponShare oldShare = yxjUserCouponShareDAO.findCouponShareByOrdersn(baseOrdersn);
		if(grantConfig != null && oldShare == null){
			List<YxjUserCouponGrantConfigDetail> configDetailList = yxjUserCouponGrantConfigDetailDAO.findListGrantConfigDetail(grantConfig.getConfigId());
			if(configDetailList != null && configDetailList.size() > 0){
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date currDate = sdf.parse(sdf.format(new Date()));
				
				YxjUserCouponShare share = new YxjUserCouponShare();
				share.setBaseOrdersn(baseOrdersn);
				share.setBeginTime(currDate);
				share.setEndTime(DateUtil.nextSomeDay(currDate, grantConfig.getTimeLength()-1));
				share.setShareId(UUIDGenerator.getUUID());
				share.setShareUserId(shareUserId);
				share.setTotalMoney(grantConfig.getTotalMoney());
				yxjUserCouponShareDAO.insert(share);
				
				int i = 0;
				for(YxjUserCouponGrantConfigDetail configDetail:configDetailList){
					for(i=0;i<configDetail.getGrantQuantity();i++){
						CouponRuleInfo ruleInfo = configDetail.getCouponRuleInfo();
						YxjUserCouponShareDetail shareDetail = new YxjUserCouponShareDetail();
						shareDetail.setCouponAmount(new BigDecimal(ruleInfo.getCouponMoney()));
						shareDetail.setCouponDesc(ruleInfo.getCouponDesc());
						shareDetail.setCouponId(ruleInfo.getCouponId());
						shareDetail.setCouponName(ruleInfo.getCouponName());
						shareDetail.setCouponTitle("通用红包");
						shareDetail.setDetailId(UUIDGenerator.getUUID());
						shareDetail.setShareId(share.getShareId());
						shareDetail.setSinceMoney(new BigDecimal(ruleInfo.getSinceMoney()));
						shareDetail.setBeginTime(currDate);
						shareDetail.setEndTime(DateUtil.nextSomeDay(currDate, ruleInfo.getTimeLength()-1));
						
						shareDetail.setReceiveTime(null);
						shareDetail.setReceiveUser(null);
						
						yxjUserCouponShareDetailDAO.insert(shareDetail);
					}
					
					
				}
			}
		}
		
		
	}

	
}
