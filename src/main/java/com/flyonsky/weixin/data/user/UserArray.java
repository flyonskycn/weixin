package com.flyonsky.weixin.data.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 用户openid列表
 * @author Administrator
 *
 */
public class UserArray {

	@JsonProperty("openid")
	private List<String> openid;

	public List<String> getOpenid() {
		return openid;
	}

	public void setOpenid(List<String> openid) {
		this.openid = openid;
	}
}
