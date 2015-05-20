package com.zxl.app.weixin.util;


import java.io.UnsupportedEncodingException;
/** 
 * 公共工具类 
 *  
 * @author zxl 
 * @date 2014-09-10 
 */
public class CommonUtil {
	/** 
	 * 计算采用utf-8编码方式时字符串所占字节数 
	 *  
	 * @param content 
	 * @return 
	 */  
	public static int getByteSize(String content) {  
	    int size = 0;  
	    if (null != content) {  
	        try {  
	            // 汉字采用utf-8编码时占3个字节  
	            size = content.getBytes("utf-8").length;  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    return size;  
	}
}