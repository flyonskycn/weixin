package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.flyonsky.weixin.data.AbstractData;
import com.flyonsky.weixin.data.NoSign;

/**
 * 支付相关请求参数的基类
 * @author Administrator
 *
 */
public abstract class AbstractPayData extends AbstractData {
	
	// 公众账号ID
	@JsonProperty("appid")
	@JacksonXmlCData
	private String appId;
	
	// 商户号
	@JsonProperty("mch_id")
	@JacksonXmlCData
	private String mchId;
	
	// 随机字符串
	@JsonProperty("nonce_str")
	private String nonceStr;
	
	// 签名
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

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
}
