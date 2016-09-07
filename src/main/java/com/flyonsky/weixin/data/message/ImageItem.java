package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 图片消息项
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageItem {

	@JsonProperty("MediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
