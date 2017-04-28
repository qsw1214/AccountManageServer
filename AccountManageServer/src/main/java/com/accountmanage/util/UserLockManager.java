package com.accountmanage.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import base.cn.util.ObjectTools;

public class UserLockManager {

	private static UserLockManager userLockManager = new UserLockManager();
	private UserLockManager(){}
	
	private Lock createLock = new ReentrantLock();
	private Map <String,Lock>userLockMap = new ConcurrentHashMap<String,Lock>();
	
	private Log log = LogFactory.getLog(UserLockManager.class);
	
	public static UserLockManager getUserLockManager(){
		return userLockManager;
	}
	
	public Lock getUserLock(String userID){
		while(true){
			synchronized (userID.intern()) {
				if(!userLockMap.containsKey(userID)){

					this.log.info("用户:" + userID + ",用户锁不存在.");
					//当不存在对应的用户锁信息时，需要进行注册
					doCreateUserLock(userID);
					return userLockMap.get(userID);
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 注册新的用户锁
	 * */
	private void doCreateUserLock(String userID){
		createLock.lock();
		try{
			if(!userLockMap.containsKey(userID)){
				userLockMap.put(userID, new UserTransactionLock(userID));
				this.log.info("用户:" + userID + ",进行用户锁注册.");
			}
		}finally{
			createLock.unlock();
		}
	}
	
	/**
	 * 移除用户锁
	 * */
	private void doRemoveUserLock(String userID){
		Lock removeLock = userLockMap.remove(userID);
		if(ObjectTools.isNullByObject(removeLock)){
			removeLock = null;
		}
		this.log.info("用户:" + userID + ",用户锁被移除.");
	}
	
	
	/**
	 * 用户事务锁
	 * */
	class UserTransactionLock implements Lock, java.io.Serializable{

		private static final long serialVersionUID = 20130524160900L;
		private String userID;
		private ReentrantLock innerLock = new ReentrantLock();
		
		public UserTransactionLock(String userID){
			this.userID = userID;
		}

		public void lock() {
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
			log.info("用户:" + userID + ",等待获取用户锁的线程数:" + queueLength);
			if(queueLength == 0){
				
				doRemoveUserLock(userID);
			}
			innerLock.unlock();
			
		}

		public String getUserID() {
			return userID;
		}

	}
}