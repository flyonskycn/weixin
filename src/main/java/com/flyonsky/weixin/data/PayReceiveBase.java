package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 支付相关请求接收到的响应数据
 * @author Administrator
 *
 */
public abstract class PayReceiveBase {
	
	@JsonProperty("return_code")
	private String returnCode;
	
	@JsonProperty("return_msg")
	private String returnMsg;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
}
