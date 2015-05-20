package com.zxl.app.interceptor;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zxl.app.common.manager.CookieManager;

/**
 * 后台登陆拦截
 * @time: 2015-04-28
 * @author: suger
 * @Version: 1.0
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 537458288805517850L;
	public static final String OPERATOR_LOGIN_TIME_COOKIE = "loginCookie";//用户登陆后的cookie
	
	@SuppressWarnings("rawtypes")
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		// 采用新会话cookie的验证机制
		if (!validateHasLogin()) {
			String logOutUrl = getLogOutUrl();
			if (StringUtils.isBlank(logOutUrl))
				throw new IllegalArgumentException("The redirect Url is null");
			
			Map map = ServletActionContext.getRequest().getParameterMap();		
			Iterator it = map.keySet().iterator();
			StringBuffer sb = new StringBuffer();
			String urlStr ="";
			while(it.hasNext()){
				String key = it.next().toString();
				String value = ServletActionContext.getRequest().getParameter(key);
				sb.append(key);
				sb.append("=");
				sb.append(value);
				sb.append("&");
			}
			urlStr = sb.toString();
			if(null!=sb && StringUtils.isNotEmpty(urlStr)){
				if((urlStr.substring(urlStr.length()-1, urlStr.length())).equals("&")){
					urlStr = urlStr.substring(0,urlStr.length()-1);
				}
			}
			String redirectURL = ServletActionContext.getRequest().getRequestURL().toString();
			if(StringUtils.isNotEmpty(urlStr)){
				redirectURL = redirectURL+"?"+urlStr;
			}
			ServletActionContext.getResponse().sendRedirect(logOutUrl+"?redirectURL="+URLEncoder.encode(redirectURL, "UTF-8"));
			return null;
		}
		return invocation.invoke();
	}

	/**
	 * 验证会话cookie是否存在
	 * 
	 * @param name
	 * @return
	 */
	public boolean validateHasLogin() {
		CookieManager cookieManager = new CookieManager(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		String cookieValue = cookieManager.getCookieValue(OPERATOR_LOGIN_TIME_COOKIE);
		if(StringUtils.isNotEmpty(cookieValue)){
			//填写从mameche中获取值
			return true;
		}else{
			return false;
		}
	}
	long convertDaysToMilliseconds(long sessionCookieTimeout) { 
		return sessionCookieTimeout* 60 * 1000L; 
	}
	/**
	 * 获取会话验证失败后的跳转URL
	 * 
	 * @return
	 */
	public String getLogOutUrl() {
		return "";
	}
}
