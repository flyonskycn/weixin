package com.flyonsky.weixin.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 查询用户信息的简单参数
 * @author Administrator
 *
 */
public class SimpleParam {

	// 用户的标识，对当前公众号唯一
	@JsonProperty("openid")
	private String openid;
	
	// 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
	@JsonProperty("lang")
	private String lang = "zh-CN";

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
}
