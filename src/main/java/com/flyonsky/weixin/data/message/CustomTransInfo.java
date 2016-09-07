package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息转发到指定客服时用于指定客户帐号
 * @author Administrator
 *
 */
public class CustomTransInfo {

	// 指定会话接入的客服账号
	@JsonProperty("KfAccount")
	private String kfAccount;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}
}
