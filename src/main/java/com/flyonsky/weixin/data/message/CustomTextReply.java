package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服发送的文本消息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomTextReply extends AbstractCustomReply{

	@JsonProperty("text")
	private CustomTextItem text;

	public CustomTextItem getText() {
		return text;
	}

	public void setText(CustomTextItem text) {
		this.text = text;
	}
}
