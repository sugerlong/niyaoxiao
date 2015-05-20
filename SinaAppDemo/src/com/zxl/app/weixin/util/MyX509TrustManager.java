package com.zxl.app.weixin.util;


import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/** 
 * 消息工具类 
 *  
 * @author zxl 
 * @date 2014-09-10 
 */
public class MyX509TrustManager implements X509TrustManager{
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
    }  
  
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
    }  
  
    public X509Certificate[] getAcceptedIssuers() {  
        return null;  
    }  
}  