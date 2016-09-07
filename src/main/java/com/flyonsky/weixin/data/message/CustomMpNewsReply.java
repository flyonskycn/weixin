package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服发送的图文消息
 * 图文消息来源于素材库
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomMpNewsReply extends AbstractCustomReply{

	@JsonProperty("mpnews")
	private CustomMediaItem mpnews;

	public CustomMediaItem getMpnews() {
		return mpnews;
	}

	public void setMpnews(CustomMediaItem mpnews) {
		this.mpnews = mpnews;
	}
}
