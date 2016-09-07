package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服发送的音乐消息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomMusicReply extends AbstractCustomReply{

	@JsonProperty("music")
	private CustomMusicItem music;

	public CustomMusicItem getMusic() {
		return music;
	}

	public void setMusic(CustomMusicItem music) {
		this.music = music;
	}
}
