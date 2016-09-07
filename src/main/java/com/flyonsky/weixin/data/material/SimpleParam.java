package com.flyonsky.weixin.data.material;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 删除或查询指定素材的请求参数
 * @author Administrator
 *
 */
public class SimpleParam extends AbstractData{
	
	@JsonProperty("media_id")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
