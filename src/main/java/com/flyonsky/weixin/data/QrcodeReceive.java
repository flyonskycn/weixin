package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QrcodeReceive extends ServiceReceive{

	@JsonProperty("ticket")
	private String ticket;
	
	@JsonProperty("expire_seconds")
	private long expireSeconds;
	
	@JsonProperty("url")
	private String url;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public long getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(long expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
