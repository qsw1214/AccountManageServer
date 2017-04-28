package com.accountmanage.web.pinjun.network.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import com.accountmanage.util.Base64Util;

public class AESUtil {

	
	/**
	 * 将base64密文 AES解密
	 * @param encryptStr 待解密的base 64 code
	 * @param decryptKey 解密密钥
	 * @return 解密后的string
	 */
	public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
		byte[] encryptBytes = (decryptKey == null || "".equals(decryptKey)) ? null
				: Base64Util.Decode(encryptStr).getBytes();
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
		random.setSeed(decryptKey.getBytes());
		kgen.init(128, random);
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
		byte[] decryptBytes = cipher.doFinal(encryptBytes);
		return new String(decryptBytes, "UTF-8");
	}
	
}
