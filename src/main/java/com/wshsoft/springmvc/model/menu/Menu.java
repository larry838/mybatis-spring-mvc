package com.wshsoft.springmvc.model.menu;

import java.io.Serializable;
import java.util.Date;


import com.wshsoft.mybatis.annotations.TableField;
import com.wshsoft.mybatis.annotations.TableId;
import com.wshsoft.mybatis.annotations.TableName;

/**
 *
 * 资源表
 *
 */
@TableName("tb_menu")
public class Menu implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 资源id */
	@TableId
	private Integer id;

	/** 资源父id */
	@TableField(value = "parent_id")
	private Integer parentId;

	/** 资源名称 */
	private String name;

	/** 资源唯一标识 */
	@TableField(value = "source_key")
	private String sourceKey;

	/** 资源类型,0:目录;1:菜单;2:按钮 */
	private Integer type;

	/** 资源url */
	@TableField(value = "source_url")
	private String sourceUrl;

	/** 层级 */
	private Integer level;

	/** 图标 */
	private String icon;

	/** 是否隐藏 */
	@TableField(value = "is_hide")
	private Integer isHide;

	/** 描述 */
	private String description;

	/** 创建时间 */
	@TableField(value = "create_time")
	private Date createTime;

	/** 更新时间 */
	@TableField(value = "update_time")
	private Date updateTime;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSourceKey() {
		return this.sourceKey;
	}

	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSourceUrl() {
		return this.sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getIsHide() {
		return this.isHide;
	}

	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
