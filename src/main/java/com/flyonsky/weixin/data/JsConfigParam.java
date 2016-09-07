package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsConfigParam extends AbstractData{

	// 服务号appId
	@NoSign
	@JsonProperty("appId")
	private String appId;
	
	// 时间
	@JsonProperty("timestamp")
	private String timestamp;
	
	// 随机字符串
	@JsonProperty("noncestr")
	private String nonceStr;
	
	// sha1签名
	@JsonProperty("signature")
	private String signature;
	
	// 当前网页的URL
	@JsonProperty("url")
	private String url;
	
	// 公众号用于调用微信JS接口的临时票据
	@JsonProperty("jsapi_ticket")
	private String jsapiTicket;
	
	// 分享的URL地址
	@NoSign
	@JsonProperty("link")
	private String link;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getJsapiTicket() {
		return jsapiTicket;
	}

	public void setJsapiTicket(String jsapiTicket) {
		this.jsapiTicket = jsapiTicket;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
