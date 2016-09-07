package com.flyonsky.weixin.data.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服图文消息的图文项
 * @author Administrator
 *
 */
public class CustomNewsItem {

	@JsonProperty("articles")
	private List<CustomPictureItem> articles;

	public List<CustomPictureItem> getArticles() {
		return articles;
	}

	public void setArticles(List<CustomPictureItem> articles) {
		this.articles = articles;
	}
}
