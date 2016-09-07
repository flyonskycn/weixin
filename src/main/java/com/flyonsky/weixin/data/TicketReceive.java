package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JS-SDK的获取jsapi_ticket的响应数据
 * @author Administrator
 *
 */
public class TicketReceive extends ServiceReceive{

	// jsapi_ticket
	@JsonProperty("ticket")
	private String ticket;
	
	// 有效时间长
	@JsonProperty("expires_in")
	private long expiresIn;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
}
