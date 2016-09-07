package com.flyonsky.weixin.data.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 信微自定义菜单项
 * @author Administrator
 *
 */
public class MenuItem {

	@JsonProperty("type")
	private String type;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("sub_button")
	private List<MenuItem> subButton;
	
	@JsonProperty("media_id")
	private String mediaId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuItem> getSubButton() {
		return subButton;
	}

	public void setSubButton(List<MenuItem> subButton) {
		this.subButton = subButton;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
}
