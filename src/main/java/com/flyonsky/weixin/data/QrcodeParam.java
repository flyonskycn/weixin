package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 二维码创建的请求参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QrcodeParam {
	
	@JsonProperty("expire_seconds")
	private Long expireSeconds;
	
	@JsonProperty("action_name")
	private String actionName;

	@JsonProperty("action_info")
	private Scene actionInfo;

	public Long getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(long expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public Scene getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(Scene actionInfo) {
		this.actionInfo = actionInfo;
	}
	
}