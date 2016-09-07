package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 客服的在线信息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomOnline extends AbstractData{

	@JsonProperty("kf_account")
	private String kfAccount;
	
	@JsonProperty("status")
	private int status;
	
	@JsonProperty("kf_id")
	private String kfId;
	
	@JsonProperty("auto_accept")
	private int autoAccept;
	
	@JsonProperty("accepted_case")
	private int acceptedCase;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getKfId() {
		return kfId;
	}

	public void setKfId(String kfId) {
		this.kfId = kfId;
	}

	public int getAutoAccept() {
		return autoAccept;
	}

	public void setAutoAccept(int autoAccept) {
		this.autoAccept = autoAccept;
	}

	public int getAcceptedCase() {
		return acceptedCase;
	}

	public void setAcceptedCase(int acceptedCase) {
		this.acceptedCase = acceptedCase;
	}
}
