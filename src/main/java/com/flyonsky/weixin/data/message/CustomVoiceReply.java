package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服发送的声音消息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomVoiceReply extends AbstractCustomReply{

	@JsonProperty("voice")
	private CustomMediaItem voice;

	public CustomMediaItem getVoice() {
		return voice;
	}

	public void setVoice(CustomMediaItem voice) {
		this.voice = voice;
	}
}
