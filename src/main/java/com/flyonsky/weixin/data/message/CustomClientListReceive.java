package com.flyonsky.weixin.data.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 获取客服的会话列表响应
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomClientListReceive extends ServiceReceive{

	@JsonProperty("sessionlist")
	private List<CustomClientStatus> sessionList;

	public List<CustomClientStatus> getSessionList() {
		return sessionList;
	}

	public void setSessionList(List<CustomClientStatus> sessionList) {
		this.sessionList = sessionList;
	}
}
