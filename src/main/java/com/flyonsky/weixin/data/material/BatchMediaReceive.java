package com.flyonsky.weixin.data.material;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 批量获取其他类型（图片、语音、视频）素材的返回结果
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchMediaReceive extends BatchReceive{

	@JsonProperty("item")
	private List<Media> item;

	public List<Media> getItem() {
		return item;
	}

	public void setItem(List<Media> item) {
		this.item = item;
	}
}
