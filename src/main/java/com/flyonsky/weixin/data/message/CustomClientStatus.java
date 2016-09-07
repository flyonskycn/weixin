package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服的每个客户状态
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomClientStatus {

	@JsonProperty("createtime")
	private long createTime;
	
	@JsonProperty("openid")
	private String openid;
	
	@JsonProperty("kf_account")
	private String kfAccount;

	public long getCreateTime() {
		return createTime;
	}

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
