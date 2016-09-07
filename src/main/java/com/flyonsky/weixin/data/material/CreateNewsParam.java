package com.flyonsky.weixin.data.material;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 新增永久图文素材的请求参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateNewsParam extends AbstractData{

	// 若新增的是多图文素材，则此处应有几段articles结构，最多8段
	@JsonProperty("articles")
	private List<NewsMaterialItem> articles;

	public List<NewsMaterialItem> getArticles() {
		return articles;
	}

	public void setArticles(List<NewsMaterialItem> articles) {
		this.articles = articles;
	}
	
}
