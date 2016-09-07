package com.flyonsky.weixin.data.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 用户所属分组的请求参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroupParam extends AbstractData{

	// 用户的OpenID
	@JsonProperty("openid")
	private String openid;
	
	// 分组id
	@JsonProperty("to_groupid")
	private int toGroupid;

	public String getOpenid() {
		return openid;
	}

	public int getToGroupid() {
		return toGroupid;
	}

	public void setToGroupid(int toGroupid) {
		this.toGroupid = toGroupid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
