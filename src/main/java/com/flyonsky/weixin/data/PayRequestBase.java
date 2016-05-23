package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 支付相关请求参数的基类
 * @author Administrator
 *
 */
public abstract class PayRequestBase {
	
	@JsonProperty("appid")
	private String appId;
	
	@JsonProperty("mch_id")
	private String mchId;
	
	@NoSign
	@JsonProperty("sign")
	private String sign;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
}
