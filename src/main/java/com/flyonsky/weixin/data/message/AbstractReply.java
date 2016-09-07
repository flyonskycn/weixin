package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 被动回复消息的抽象类
 * @author Administrator
 *
 */
public abstract class AbstractReply extends AbstractData{

	@JsonProperty("ToUserName")
	private String toUserName;
	
	@JsonProperty("FromUserName")
	private String fromUserName;
	
	@JsonProperty("CreateTime")
	private long createTime;
	
	@JsonProperty("MsgType")
	private String msgType;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
}
