package com.xwolf.eop.util;

import com.xwolf.eop.common.pojo.Global;

import java.security.MessageDigest;

public class MD5 {

	private MD5() {}
	
	public final static String getMessageDigest(String strs,String charset) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strs.getBytes(charset));
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 默认UTF-8加密
	 * @param str
	 * @return
	 */
	public final static String getMessageDigest(String str){
		return getMessageDigest(str, Global.DEFAULT_ENCODING);
	}
}
