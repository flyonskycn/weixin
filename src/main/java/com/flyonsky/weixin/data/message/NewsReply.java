package com.flyonsky.weixin.data.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 回复图文消息
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsReply extends AbstractReply{

	// 图文消息个数，限制为10条以内
	@JsonProperty("ArticleCount")
	private int articleCount;
	
	@JacksonXmlElementWrapper(localName="Articles")
	@JacksonXmlProperty(localName="item")
	private List<NewsItem> articles;

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public List<NewsItem> getArticles() {
		return articles;
	}

	public void setArticles(List<NewsItem> articles) {
		this.articles = articles;
	}
}
