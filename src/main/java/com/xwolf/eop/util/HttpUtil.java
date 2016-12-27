package com.xwolf.eop.util;

import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Date 2016-01-30 15:17
 * @author xuejz
 * @descr 获取请求参数等
 */
public class HttpUtil {

	/**
	 * 获取ip地址
	 * @param request
	 * @return
	 */
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip != null && !ip.isEmpty()) {
			ip = ip.split(",")[0].trim();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("PRoxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 获取url
	 * @param request
	 * @return
	 */
	public static String getUrl(HttpServletRequest request){
		return request.getRequestURL().toString();
	}
	/**
	 * 获取请求的方法
	 * @param request
	 * @return
	 */
	public static String getMethod(HttpServletRequest request){
		return request.getMethod();
	}
	/**
	 * 获取项目名称
	 * @param request
	 * @return
	 */
	public static String getContextPath(HttpServletRequest request){
		return request.getContextPath();
	}
	/**
	 * 获取端口
	 * @param request
	 * @return
	 */
	public static int getPort(HttpServletRequest request){
		return request.getServerPort();
	}
	
	
	/**
	 * 获取主机
	 * @param request
	 * @return
	 */
	public static String getHost(HttpServletRequest request){
		
		return request.getRemoteHost();
	}
	
	/**
	 * 获取查询字符串
	 * @param request
	 * @return
	 */
    public static String getParam(HttpServletRequest request){
		Map<String,String[]> maps = getParamMap(request);
		Set<String> sets=maps.keySet();
		StringBuffer querys=new StringBuffer("");
		for(String set:sets){
            String value = request.getParameter(set);
            querys.append(set+"="+value+"&");
		}
		return querys.substring(0,querys.toString().length()-1);
	}
    
    /**
     * 获取上下文
     * @param request
     * @return
     */
    public static ServletContext getServletContext(HttpServletRequest request){
    	return request.getServletContext();
    }
    
    /**
     * 获取请求协议
     * @param request
     * @return
     */
    public static String getProtocol(HttpServletRequest request){
    	return request.getProtocol();
    }
	/**
	 * 获取请求参数Map
	 * */
	public static Map<String,String[]> getParamMap(HttpServletRequest request){

		return request.getParameterMap();
	}
	
	
	/**************************和session相关***********************************/
	/**
	 * 获取session
	 * @param request
	 * @return
	 */
	public static HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	
	/**
	 * 设置验证码到session中
	 * @param request
	 * @param checkCode
	 */
	public static void setCheckCode(HttpServletRequest request,String checkCode){
		request.getSession().setAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, checkCode);
	}
	
	/**
	 * 获取session验证码
	 * @param request
	 * @param
	 */
	public static String getCheckCode(HttpServletRequest request){
		return (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
	}
	
	/**
	 * 设置验证码到session中
	 * @param request
	 * @param
	 */
	/*public static void setUser(HttpServletRequest request,User user){
		request.getSession().setAttribute("sysUser", user);
	}
	
	*//**
	 * 获取session中用户信息
	 * @param request
	 *//*
	public static User getUser(HttpServletRequest request){
		return (User) request.getSession().getAttribute("sysUser");
	}*/
	
	/**
	 * 删除session中的信息
	 * @param request
	 * @param attr
	 */
	public static void removeAttr(HttpServletRequest request,String attr){
		request.getSession().removeAttribute(attr);
	}
	/**
	 * 移除所有session信息
	 * @param request
	 */
	public static void removeAllSessionAttr(HttpServletRequest request){
		HttpSession session=request.getSession();
	Enumeration<?> enumeration=session.getAttributeNames();
	while (enumeration.hasMoreElements()) {
		String attrName = (String) enumeration.nextElement();
		//System.out.println("session属性名称为:"+attrName);
		session.removeAttribute(attrName);
	}
  }
}