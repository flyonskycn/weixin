package com.flyonsky.weixin.data.material;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 批量获取图片、语音、视频素材项
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Media extends AbstractData{
	
	// 素材id
	@JsonProperty("media_id")
	private String mediaId;
	
	// 文件名称
	@JsonProperty("name")
	private String name;
	
	// 最后更新时间
	@JsonProperty("update_time")
	private Date updateTime;
	
	// 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
	@JsonProperty("url")
	private String url;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
