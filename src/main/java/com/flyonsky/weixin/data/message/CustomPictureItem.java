package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服图文消息的图片项
 * @author Administrator
 *
 */
public class CustomPictureItem {

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("picurl")
	private String picUrl;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
