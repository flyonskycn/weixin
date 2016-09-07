package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 获取客户的会话状态响应
 * @author Administrator
 *
 */
public class ClientSessionReceive extends ServiceReceive{

	@JsonProperty("createtime")
	private long createTime;
	
	@JsonProperty("kf_account")
	private String kfAccount;

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}
}
