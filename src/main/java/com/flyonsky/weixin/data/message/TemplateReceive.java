package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 发送模板消息的响应结果
 * @author Administrator
 *
 */
public class TemplateReceive extends ServiceReceive{

	@JsonProperty("msgid")
	private String msgid;

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
}
