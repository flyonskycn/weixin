package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服消息的媒体项
 * @author Administrator
 *
 */
public class CustomMediaItem {

	@JsonProperty("media_id")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
