package com.flyonsky.weixin.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 新建分组的请求响应
 * @author Administrator
 *
 */
public class CreateGroupReceive extends ServiceReceive{

	@JsonProperty("group")
	private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
