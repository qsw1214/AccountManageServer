package com.accountmanage.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {

	private static String CODING = "utf-8";

	public Base64Util(String coding)
	{
		CODING = coding;
	}

	public Base64Util()
	{
	}

	public static String Decode(String base64String)
	{
		String rs = null;
		if (base64String != null)
		{
			try
			{
				rs = new String(Base64.decodeBase64(base64String), CODING);
			}
			catch (UnsupportedEncodingException ex)
			{
				ex.printStackTrace();
			}
		}
		return rs;
	}

	public static String Encode(String sourceString)
	{
		String rs = null;
		if (sourceString != null)
		{
			try
			{
				rs = Base64.encodeBase64String(sourceString.getBytes(CODING));
			}
			catch (UnsupportedEncodingException ex)
			{
				ex.printStackTrace();
			}
		}
		return rs;
	}

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args)
	{
		Base64Util base64Util = new Base64Util();
		//System.out.println(base64Util.Encode("00000000-0000-0000-0000-000000000000CCE7AED4"));
		//System.out.println(base64Util.Decode("MDAwMDAwMDAtMDAwMC0wMDAwLTAwMDAtMDAwMDAwMDAwMDAwQ0NFN0FFRDQ="));

	    System.out.println(base64Util.Encode("啦啦啦啦啦"));
	    
	}

}
