package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服发送的图文消息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomNewsReply extends AbstractCustomReply{

	@JsonProperty("news")
	private CustomNewsItem news;

	public CustomNewsItem getNews() {
		return news;
	}

	public void setNews(CustomNewsItem news) {
		this.news = news;
	}
}
