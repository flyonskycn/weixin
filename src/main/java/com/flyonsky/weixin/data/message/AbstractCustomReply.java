package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 抽象客服消息类
 * @author Administrator
 *
 */
public abstract class AbstractCustomReply extends AbstractData{

	// 普通用户openid
	@JsonProperty("touser")
	private String toUser;
	
	// 消息类型
	@JsonProperty("msgtype")
	private String msgType;
	
	@JsonProperty("customservice")
	private Custom customService;

	public String getToUser() {
		return toUser;
	}

	public Custom getCustomService() {
		return customService;
	}

	public void setCustomService(Custom customService) {
		this.customService = customService;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
}
