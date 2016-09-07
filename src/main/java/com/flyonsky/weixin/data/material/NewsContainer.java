package com.flyonsky.weixin.data.material;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 批量获取图文素材的包装类
 * @author Administrator
 *
 */
public class NewsContainer extends AbstractData{

	@JsonProperty("media_id")
	private String mediaId;
	
	@JsonProperty("content")
	private NewsMaterial content;
	
	@JsonProperty("update_time")
	private Date updateTime;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public NewsMaterial getContent() {
		return content;
	}

	public void setContent(NewsMaterial content) {
		this.content = content;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
