package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服消息的视频项
 * @author Administrator
 *
 */
public class CustomVideoItem extends CustomMediaItem{

	@JsonProperty("thumb_media_id")
	private String thumbMediaId;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
