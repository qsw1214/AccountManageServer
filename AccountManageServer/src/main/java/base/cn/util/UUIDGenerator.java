package base.cn.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDGenerator {

	public UUIDGenerator() {  
    }  
  
    public static String getUUID() {  
        UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();  
     // 去掉"-"符号
        String returnStr = str.replace("-", "");
       /*   
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);  */
        return returnStr;  
    }  
   
  
    public static void main(String[] args) {  
     
    	System.out.println(getUUID());
    	SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssSSS");
    	System.out.println(format.format(new Date()));
    }  
}
