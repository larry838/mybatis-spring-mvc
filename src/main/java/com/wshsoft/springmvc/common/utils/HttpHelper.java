package com.wshsoft.springmvc.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * 
 * @ClassName: HttpHelper
 * @Description: 公共
 * @author carry xie
 * @date 2016年7月12日 下午4:03:46
 *
 */
public class HttpHelper {

	/**
	 * 获取 HttpServletRequest
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

}
