package com.flyonsky.weixin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseData {

	@JsonProperty("errcode")
	private int errCode;
	
	@JsonProperty("errmsg")
	private String errMsg;

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
}
