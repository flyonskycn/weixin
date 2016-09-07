package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 微信客服消息参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomParam extends AbstractData{

	// 完整客服账号，格式为：账号前缀@公众号微信号
	@JsonProperty("kf_account")
	private String kfAccount;
	
	// 客服昵称
	@JsonProperty("nickname")
	private String nickName;
	
	// 客服账号登录密码，格式为密码明文的32位加密MD5值
	@JsonProperty("password")
	private String password;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
