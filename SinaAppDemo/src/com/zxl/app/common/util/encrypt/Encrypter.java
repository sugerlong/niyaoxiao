package com.zxl.app.common.util.encrypt;

/**
 * DES算法
 * 为了保证算法统一，但是这个加密这的密钥已经固定，跟后台其他的一样
 */
public final class Encrypter {
	// 必须24个字符
	private static final String key = "*:@1$7!a*:@1$7!a*:@1$7!a";

	/**
	 * 加密字符串
	 * @param str
	 * @return
	 */
	public static String encrypt(String str) {
		if (str == null)
			return "";
		DesEncrypter desEncrypter = new DesEncrypter(key);
		try {
			return desEncrypter.encrypt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 解密字符串
	 */
	public static String decrypt(String str) {
		if (str == null)
			return "";
		DesEncrypter desEncrypter = new DesEncrypter(key);
		try {
			return desEncrypter.decrypt(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(encrypt("zhangxiulong"));
	}
}
