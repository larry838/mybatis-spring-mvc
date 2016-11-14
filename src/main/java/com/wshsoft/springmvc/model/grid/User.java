package com.wshsoft.springmvc.model.grid;

import java.io.Serializable;
import java.util.Date;


import com.wshsoft.mybatis.annotations.TableField;
import com.wshsoft.mybatis.annotations.TableId;

/**
 *
 * TbUser
 *
 */
public class User implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** TbUser Id */
	@TableId(value = "user_id")
	private String userId;

	/** TbUser Code */
	@TableField(value = "user_code")
	private String userCode;

	/** TbUser Name */
	@TableField(value = "user_name")
	private String userName;

	/** Salary */
	private Double salary;

	/** Sex */
	private String sex;

	/** Degree */
	private String degree;

	/** Time */
	private Date time;

	/** Time Stamp(s) */
	@TableField(value = "time_stamp_s")
	private Integer timeStampS;

	/** Time Stamp(ms) */
	@TableField(value = "time_stamp_ms")
	private Double timeStampMs;

	/** Date String */
	@TableField(value = "string_date")
	private String stringDate;

	/** Time String */
	@TableField(value = "string_time")
	private String stringTime;


	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getTimeStampS() {
		return this.timeStampS;
	}

	public void setTimeStampS(Integer timeStampS) {
		this.timeStampS = timeStampS;
	}

	public Double getTimeStampMs() {
		return this.timeStampMs;
	}

	public void setTimeStampMs(Double timeStampMs) {
		this.timeStampMs = timeStampMs;
	}

	public String getStringDate() {
		return this.stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public String getStringTime() {
		return this.stringTime;
	}

	public void setStringTime(String stringTime) {
		this.stringTime = stringTime;
	}

}
