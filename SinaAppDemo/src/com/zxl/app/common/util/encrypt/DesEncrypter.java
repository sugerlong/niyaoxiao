package com.zxl.app.common.util.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES对称加密算法
 * 
 * @author zengbin
 * 
 */
public final class DesEncrypter {
	private static Cipher ecipher;
	private static Cipher dcipher;

	private static final String alg = "DESede";

	// 密钥长度只能为24字节
	public DesEncrypter(String keys) {
		try {
			SecretKey skey = new SecretKeySpec(keys.getBytes(), alg);
			ecipher = Cipher.getInstance(alg);
			dcipher = Cipher.getInstance(alg);
			ecipher.init(Cipher.ENCRYPT_MODE, skey);
			dcipher.init(Cipher.DECRYPT_MODE, skey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static {
	}

	/**
	 * 加密字符串
	 * 
	 * @param str
	 * @return
	 */
	public String encrypt(String str) throws Exception {
		if (str == null || "" == str)
			return "";
		byte[] utf8 = str.getBytes("UTF8");
		byte[] enc = ecipher.doFinal(utf8);
		return Base64Support.toUrlStr(enc);
	}

	/**
	 * 解密字符串
	 * 
	 * @param str
	 * @return
	 */
	public String decrypt(String str) throws Exception {
		if (str == null || "" == str)
			return "";
		byte[] dec = Base64Support.fromUrlStr(str);
		byte[] utf8 = dcipher.doFinal(dec);
		return new String(utf8, "UTF8");
	}

	public static void main(String[] args) throws Exception {
		DesEncrypter de = new DesEncrypter("123!!#!@#sdf%#!@!$##lAkj");
		DesEncrypter de2 = new DesEncrypter("123!!#!@#)()&^S#!@!$##lA");
		System.out.println(de.decrypt(de2
				.decrypt("w3_LpMieY49YvJgLD5NwWO0Fsxf6XbpxCPXniGB9ofw.")));
	}

}
