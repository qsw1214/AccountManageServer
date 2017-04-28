package base.cn.util;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


public class IdGenerator{
	
	private static IdGenerator idGenerator = new IdGenerator();
	//原子增加方式的计数器
	private static AtomicInteger intSequence;
	
	public static IdGenerator instance(){
		return idGenerator;
	}

	
	static{
		intSequence = new AtomicInteger(0);
	}
	
	private static String getUUIDHashcode() {  
        UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();  
        // 去掉"-"符号  
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);  
        int hashCodeV = temp.hashCode();
        if(hashCodeV<0){
        	hashCodeV = -hashCodeV;
        }
        return String.format("%010d", hashCodeV);  
    }  
	
	
	public String generate(){
		//获取系统时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		String key = dateFormat.format(new Date());
		long keyLong = Long.parseLong(key);
		int keyInt = intSequence.getAndIncrement();
		//设置原子计数器的范围
		intSequence.compareAndSet(9999,0);
		return String.valueOf(keyLong * 10000 + keyInt);
	}
	
	public String generate(String os){
		String channel = "1";
		
		if("wechat".equals(os)){
			channel = "2";
		}else if("ios".equals(os)){
			channel = "3";
		}else if("android".equals(os)){
			channel = "4";
		}
		String uuidHashcode = getUUIDHashcode();
		String naoTimeIntercept = String.valueOf(System.nanoTime()).substring(7,10);
		int keyInt = intSequence.getAndIncrement();
		//设置原子计数器的范围
		intSequence.compareAndSet(9999,0);
		String sequenceStr  = String.format("%04d", keyInt);
		
		String onlyId = channel+uuidHashcode+naoTimeIntercept+sequenceStr;
		return onlyId;
	}
	
	public static void main(String []args){
		for(int i=0;i<10000;i++){
			System.out.println(IdGenerator.instance().generate("wechat"));
		}
	}
}
