package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 音乐项
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MusicItem {

	// 音乐标题
	@JsonProperty("Title")
	private String title;
	
	// 音乐描述
	@JsonProperty("Description")
	private String description;
	
	// 音乐链接
	@JsonProperty("MusicUrl")
	private String musicUrl;
	
	// 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	@JsonProperty("HQMusicUrl")
	private String hQMusicUrl;
	
	// 缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
	@JsonProperty("ThumbMediaId")
	private String thumbMediaId;

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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String gethQMusicUrl() {
		return hQMusicUrl;
	}

	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
}
