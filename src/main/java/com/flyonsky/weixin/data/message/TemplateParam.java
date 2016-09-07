package com.flyonsky.weixin.data.message;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 模板消息请求参数
 * @author Administrator
 *
 */
public class TemplateParam extends AbstractData{

	@JsonProperty("touser")
	private String touser;
	
	@JsonProperty("template_id")
	private String templateId;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("data")
	private Map<String,TemplateNote> data;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, TemplateNote> getData() {
		return data;
	}

	public void setData(Map<String, TemplateNote> data) {
		this.data = data;
	}
}
