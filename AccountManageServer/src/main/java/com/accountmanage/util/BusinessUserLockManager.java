package com.accountmanage.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BusinessUserLockManager {

	private static BusinessUserLockManager buserLockManager = new BusinessUserLockManager();
	private BusinessUserLockManager(){}
	
	private Lock createLock = new ReentrantLock();
	private Map <String,Lock>businessUserLockMap = new ConcurrentHashMap<String,Lock>();
	
	private Log log = LogFactory.getLog(BusinessUserLockManager.class);
	
	public static BusinessUserLockManager getBusinessUserLockManager(){
		return buserLockManager;
	}
	
	public Lock getBusinessUserLock(String buserID){
		if(!businessUserLockMap.containsKey(buserID)){
			this.log.info("商户:" + buserID + ",商户锁不存在.");
			//当不存在对应的商户锁信息需要进行注册
			doCreateBusinessUserLock(buserID);
		}
		this.log.info("商户:" + buserID + ",获取已经注册的商户锁.");
		return businessUserLockMap.get(buserID);
	}
	
	/**
	 * 注册新的商户锁
	 * */
	private void doCreateBusinessUserLock(String buserID){
		createLock.lock();
		try{
			if(!businessUserLockMap.containsKey(buserID)){
				businessUserLockMap.put(buserID, new BusinessUserTransactionLock(buserID));
				this.log.info("商户:" + buserID + ",进行商户锁注册.");
			}
		}finally{
			createLock.unlock();
		}
	}
	
	/**
	 * 移除商户锁
	 * */
	private void doRemoveBusinessUserLock(String buserID){
		businessUserLockMap.remove(buserID);
		this.log.info("商户:" + buserID + ",商户锁被移除.");
	}
	
	
	/**
	 * 商户事务锁
	 * */
	class BusinessUserTransactionLock implements Lock, java.io.Serializable{

		private static final long serialVersionUID = 20130524160900L;
		private String buserID;
		private ReentrantLock innerLock = new ReentrantLock();
		
		public BusinessUserTransactionLock(String buserID){
			this.buserID = buserID;
		}

		public void lock() {
			/*在商户获取商户锁与使用锁之间此时删除该商户锁,可能会发生同步现象。此处可能抛出空指针异常.*/
			innerLock.lock();
		}

		public void lockInterruptibly() throws InterruptedException {
			innerLock.lockInterruptibly();
		}

		public Condition newCondition() {
			return innerLock.newCondition();
		}

		public boolean tryLock() {
			return innerLock.tryLock();
		}

		public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
			return innerLock.tryLock(time, unit);
		}

		public void unlock() {
			int queueLength = innerLock.getQueueLength();
			long beginTime = System.currentTimeMillis();
			log.info("商户:" + buserID + ",等待获取商户锁的线程数:" + queueLength);
			
			innerLock.unlock();
			long endTime = System.currentTimeMillis();
			log.info("商户:" + buserID + ",移除商户锁耗时：" + (endTime - beginTime));
			
		}

		public String getBuserID() {
			return buserID;
		}

		

	}
}