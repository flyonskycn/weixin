package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 视频消息项
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoItem {

	@JsonProperty("MediaId")
	private String mediaId;
	
	// 视频消息的标题
	@JsonProperty("Title")
	private String title;
	
	// 视频消息的描述
	@JsonProperty("Description")
	private String description;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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
