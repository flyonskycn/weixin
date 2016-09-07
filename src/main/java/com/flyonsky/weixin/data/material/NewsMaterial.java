package com.flyonsky.weixin.data.material;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 图文素材
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsMaterial extends ServiceReceive{

	@JsonProperty("news_item")
	private List<NewsMaterialItem> newsItem;

	public List<NewsMaterialItem> getNewsItem() {
		return newsItem;
	}

	public void setNewsItem(List<NewsMaterialItem> newsItem) {
		this.newsItem = newsItem;
	}
}
