package com.flyonsky.weixin.data.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 分组信息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Group extends AbstractData{

	// 分组id，由微信分配
	@JsonProperty("id")
	private int id;
	
	// 分组名字，UTF8编码（30个字符以内）
	@JsonProperty("name")
	private String name;
	
	// 分组内用户数量
	@JsonProperty("count")
	private String count;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
