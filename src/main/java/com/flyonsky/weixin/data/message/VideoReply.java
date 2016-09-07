package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 回复视频消息
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoReply extends AbstractReply{

	@JsonProperty("Video")
	private VideoItem video;

	public VideoItem getVideo() {
		return video;
	}

	public void setVideo(VideoItem video) {
		this.video = video;
	}
}
