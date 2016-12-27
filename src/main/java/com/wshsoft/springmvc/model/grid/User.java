package com.wshsoft.springmvc.model.grid;

import com.wshsoft.mybatis.activerecord.Model;
import com.wshsoft.mybatis.annotations.TableId;
import com.wshsoft.mybatis.annotations.TableField;
import com.wshsoft.mybatis.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * User
 * </p>
 *
 * @author Carry xie
 * @since 2016-12-27
 */
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	/**
	 * User Id
	 */
	@TableId(value="user_id")

	private Long userId;
	/**
	 * User Code
	 */
	@TableField(value="user_code")
	private String userCode;
	/**
	 * User Name
	 */
	@TableField(value="user_name")
	private String userName;
	/**
	 * Salary
	 */
	private Double salary;
	/**
	 * Sex
	 */
	private String sex;
	/**
	 * Degree
	 */
	private String degree;
	/**
	 * Time
	 */
	private Date time;
	/**
	 * Time Stamp(s)
	 */
	@TableField(value="time_stamp_s")
	private Integer timeStampS;
	/**
	 * Time Stamp(ms)
	 */
	@TableField(value="time_stamp_ms")
	private Double timeStampMs;
	/**
	 * Date String
	 */
	@TableField(value="string_date")
	private String stringDate;
	/**
	 * Time String
	 */
	@TableField(value="string_time")
	private String stringTime;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getTimeStampS() {
		return timeStampS;
	}

	public void setTimeStampS(Integer timeStampS) {
		this.timeStampS = timeStampS;
	}

	public Double getTimeStampMs() {
		return timeStampMs;
	}

	public void setTimeStampMs(Double timeStampMs) {
		this.timeStampMs = timeStampMs;
	}

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public String getStringTime() {
		return stringTime;
	}

	public void setStringTime(String stringTime) {
		this.stringTime = stringTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

}