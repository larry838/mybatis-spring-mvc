package com.wshsoft.springmvc.model.system;

import java.io.Serializable;


import com.wshsoft.mybatis.annotations.TableField;
import com.wshsoft.mybatis.annotations.TableId;
import com.wshsoft.mybatis.annotations.TableName;

/**
 *
 * 系统用户表
 *
 */
@TableName("sys_user")
public class User implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 用户ID */
	@TableId(value = "id")
	private Long id;

	/** 用户名 */
	@TableField(value = "name")
	private String name;

	/** 用户年龄 */
	private Integer age;

	/**  */
	@TableField(value = "login_name")
	private String loginName;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
