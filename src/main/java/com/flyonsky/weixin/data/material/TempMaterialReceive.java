package com.flyonsky.weixin.data.material;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 上传临时素材的响应
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TempMaterialReceive extends ServiceReceive{

	// 媒体文件类型
	@JsonProperty("type")
	private String type;
	
	// 媒体文件上传后，获取时的唯一标识
	@JsonProperty("media_id")
	private String mediaId;
	
	// 媒体文件上传时间戳
	@JsonProperty("created_at")
	private long createdAt;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
}
