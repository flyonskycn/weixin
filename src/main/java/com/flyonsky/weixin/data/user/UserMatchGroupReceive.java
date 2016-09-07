package com.flyonsky.weixin.data.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 用户所属分组响应
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserMatchGroupReceive extends ServiceReceive{

	// 用户所属的groupid
	@JsonProperty("groupid")
	private int groupid;

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
}
