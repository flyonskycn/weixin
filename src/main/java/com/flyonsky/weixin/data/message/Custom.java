package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 客服信息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Custom extends AbstractData{

	// 	完整客服账号，格式为：账号前缀@公众号微信号
	@JsonProperty("kf_account")
	private String kfAccount;
	
	// 客服昵称
	@JsonProperty("kf_nick")
	private String kfNick;
	
	// 客服工号
	@JsonProperty("kf_id")
	private String kfId;
	
	// 头象URL
	@JsonProperty("kf_headimgurl")
	private String kfHeadImgUrl;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public String getKfNick() {
		return kfNick;
	}

	public void setKfNick(String kfNick) {
		this.kfNick = kfNick;
	}

	public String getKfId() {
		return kfId;
	}

	public void setKfId(String kfId) {
		this.kfId = kfId;
	}

	public String getKfHeadImgUrl() {
		return kfHeadImgUrl;
	}

	public void setKfHeadImgUrl(String kfHeadImgUrl) {
		this.kfHeadImgUrl = kfHeadImgUrl;
	}
}
