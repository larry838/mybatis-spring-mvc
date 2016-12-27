package com.wshsoft.springmvc.model.log;

import com.wshsoft.mybatis.activerecord.Model;
import com.wshsoft.mybatis.annotations.TableId;
import com.wshsoft.mybatis.annotations.TableField;
import com.wshsoft.mybatis.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Carry xie
 * @since 2016-12-27
 */
@TableName("sys_log")
public class SysLog extends Model<SysLog> {

    private static final long serialVersionUID = 1L;

	/**
	 * 日志id
	 */
	@TableId
	private Long id;
	/**
	 * 用户Id
	 */
	@TableField(value="user_id")
	private Long userId;
	/**
	 * 登录帐号
	 */
	@TableField(value="login_name")
	private String loginName;
	/**
	 * 日志类型 0:操作,1:异常
	 */
	private Integer type;
	/**
	 * 操作IP地址
	 */
	@TableField(value="remote_addr")
	private String remoteAddr;
	/**
	 * 请求URI
	 */
	@TableField(value="request_uri")
	private String requestUri;
	/**
	 * 请求客户端
	 */
	@TableField(value="user_agent")
	private String userAgent;
	/**
	 * 日志内容
	 */
	private String params;
	/**
	 * 操作方式
	 */
	private String method;
	/**
	 * 异常信息
	 */
	private String exception;
	/**
	 * 创建时间
	 */
	@TableField(value="create_date")
	private Date createDate;
	/**
	 * 操作方式
	 */
	private String operation;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}