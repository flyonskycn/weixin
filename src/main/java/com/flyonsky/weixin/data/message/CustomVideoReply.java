package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服发送的视频消息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomVideoReply extends AbstractCustomReply{

	@JsonProperty("video")
	private CustomVideoItem video;

	public CustomVideoItem getVideo() {
		return video;
	}

	public void setVideo(CustomVideoItem video) {
		this.video = video;
	}
}
