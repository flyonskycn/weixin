package com.flyonsky.weixin.data;

import org.apache.http.entity.ContentType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 获取具体媒体的响应对象
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiMediaReceive extends ServiceReceive{

	// 媒体对象的文件名
	@JsonProperty("fileName")
	private String fileName;

	// 媒体对象的二进制表示
	@JsonProperty("media")
	private byte[] media;
	
	// 媒体的类型
	@JsonProperty("contentType")
	private ContentType contentType;

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getMedia() {
		return media;
	}

	public void setMedia(byte[] media) {
		this.media = media;
	}
}
