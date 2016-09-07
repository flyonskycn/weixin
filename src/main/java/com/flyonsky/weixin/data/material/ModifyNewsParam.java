package com.flyonsky.weixin.data.material;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 修改图文素材的请求参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModifyNewsParam extends AbstractData{

	// 要修改的图文消息的id
	@JsonProperty("media_id")
	private String mediaId;
	
	// 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
	@JsonProperty("index")
	private int index;
	
	@JsonProperty("articles")
	private NewsMaterialItem articles;

	public NewsMaterialItem getArticles() {
		return articles;
	}

	public void setArticles(NewsMaterialItem articles) {
		this.articles = articles;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
