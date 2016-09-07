package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服发送的文本消息项
 * @author Administrator
 *
 */
public class CustomTextItem {

	@JsonProperty("content")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
