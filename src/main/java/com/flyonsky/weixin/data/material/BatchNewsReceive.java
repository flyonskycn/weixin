package com.flyonsky.weixin.data.material;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 批量获取图文素材结果
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchNewsReceive extends BatchReceive{

	@JsonProperty("item")
	private List<NewsContainer> item;

	public List<NewsContainer> getItem() {
		return item;
	}

	public void setItem(List<NewsContainer> item) {
		this.item = item;
	}
}
