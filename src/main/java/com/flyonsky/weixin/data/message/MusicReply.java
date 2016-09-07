package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 回复音乐消息
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MusicReply extends AbstractReply{

	@JsonProperty("Music")
	private MusicItem music;

	public MusicItem getMusic() {
		return music;
	}

	public void setMusic(MusicItem music) {
		this.music = music;
	}
}
