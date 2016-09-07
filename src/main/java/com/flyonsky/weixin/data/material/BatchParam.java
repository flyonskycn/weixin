package com.flyonsky.weixin.data.material;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 批量获取素材信息请求参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchParam extends AbstractData{
	
	// 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	@JsonProperty("type")
	private String type;
	
	// 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	@JsonProperty("offset")
	private int offset;
	
	// 返回素材的数量，取值在1到20之间
	@JsonProperty("count")
	private int count;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
