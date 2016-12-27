package com.wshsoft.springmvc.service.log.impl;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wshsoft.mybatis.service.impl.ServiceImpl;
import com.wshsoft.springmvc.common.aop.LogPoint;
import com.wshsoft.springmvc.common.utils.HttpHelper;
import com.wshsoft.springmvc.common.utils.IpHelper;
import com.wshsoft.springmvc.mapper.log.SysLogMapper;
import com.wshsoft.springmvc.model.log.SysLog;
import com.wshsoft.springmvc.service.log.ISysLogService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Carry xie
 * @since 2016-12-08
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService, LogPoint {

	private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s";

	private static final Logger logger = LoggerFactory.getLogger(SysLogServiceImpl.class);

	public static final int TYPE_ACCESS = 0; // 操作日志

	public static final int TYPE_EXCEPTION = 1; // 异常日志

	@Override
	public void saveLog(JoinPoint joinPoint, String methodName, String operate, Throwable e) {
		// TODO Auto-generated method stub
		try {

			HttpServletRequest request = HttpHelper.getHttpServletRequest();
			SysLog log = new SysLog();
			if (joinPoint.getArgs() != null) {
				StringBuffer rs = new StringBuffer();
				for (int i = 0, len = joinPoint.getArgs().length; i < len; i++) {
					Object info = joinPoint.getArgs()[i];
					if (info != null) {
						String paramType = info.getClass().getSimpleName();
						rs.append("[参数" + (i + 1) + "，类型:" + paramType + "，值:" + info.toString() + "]");
					} else {
						rs.append("[参数" + (i + 1) + "，值:null]");
					}
				}
				log.setParams(String.format(LOG_CONTENT, joinPoint.getTarget().getClass().getName(), methodName,
						rs.toString()));
			}
			/** 登录用户信息 */
			/*
			 * UserEntity user = ((UserEntity)
			 * SecurityUtils.getSubject().getPrincipal()); if(null!=user){
			 * log.setUserId(user.getId());
			 * log.setLoginName(user.getAccountName()); }
			 */
			log.setOperation(operate);
			log.setCreateDate(new Date(System.currentTimeMillis()));
			log.setRemoteAddr(IpHelper.getIpAddr(request));
			log.setRequestUri(request.getRequestURI());
			log.setUserAgent(request.getHeader("user-agent"));
			log.setException(e == null ? null : e.toString());
			log.setMethod(request.getMethod());
			log.setType(e == null ? TYPE_ACCESS : TYPE_EXCEPTION);
			/** 异常、日志操作内容分开 */
			if (e == null) {
				log.setParams(operateContent(joinPoint, methodName, request));
			}
			insertOrUpdate(log);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	private String adminOptionContent(JoinPoint joinPoint, String methodName, HttpServletRequest request) {
		if (joinPoint == null) {
			return null;
		}
		String operateClassName = joinPoint.getTarget().getClass().getName();
		Object[] args = joinPoint.getArgs();
		StringBuffer rs = new StringBuffer();
		// rs.append(methodName);
		String className = null;
		int index = 1;
		// 遍历参数对象
		for (Object info : args) {
			// 获取对象类型
			className = info.getClass().getName();
			className = className.substring(className.lastIndexOf(".") + 1);
			rs.append("[参数" + index + "，类型：" + className + "，值：");
			// 获取对象的所有方法
			Method[] methods = info.getClass().getDeclaredMethods();
			// 遍历方法，判断get方法
			for (Method method : methods) {
				String childMethodName = method.getName();
				// 判断是不是get方法
				if (childMethodName.indexOf("get") == -1) {// 不是get方法
					continue;// 不处理
				}
				Object rsValue = null;
				try {
					// 调用get方法，获取返回值
					rsValue = method.invoke(info);
					if (rsValue == null) {// 没有返回值
						continue;
					}
				} catch (Exception e) {
					continue;
				}
				// 将值加入内容中
				rs.append("(" + childMethodName + " : " + rsValue + ")");
			}
			rs.append("]");
			index++;
		}
		return String.format(LOG_CONTENT, operateClassName, methodName, rs.toString());
	}

	private String operateContent(JoinPoint joinPoint, String methodName, HttpServletRequest request) {
		String className = joinPoint.getTarget().getClass().getName();
		Object[] params = joinPoint.getArgs();
		StringBuffer bf = new StringBuffer();
		if (params != null && params.length > 0) {
			Enumeration<String> paraNames = request.getParameterNames();
			while (paraNames.hasMoreElements()) {
				String key = paraNames.nextElement();
				bf.append(key).append("=");
				bf.append(request.getParameter(key)).append("&");
			}
			if (StringUtils.isBlank(bf.toString())) {
				bf.append(request.getQueryString());
			}
		}
		return String.format(LOG_CONTENT, className, methodName, bf.toString());
	}
}
