package com.flyonsky.weixin.data.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 测试个性化菜单匹配结果请求参数
 * @author Administrator
 *
 */
public class MatchParam extends AbstractData{

	/**
	 * 粉丝的OpenID
	 */
	@JsonProperty("user_id")
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
