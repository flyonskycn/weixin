package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 回复语音消息
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoiceReply extends AbstractReply{

	@JsonProperty("Voice")
	private VoiceItem voice;

	public VoiceItem getVoice() {
		return voice;
	}

	public void setVoice(VoiceItem voice) {
		this.voice = voice;
	}
}
