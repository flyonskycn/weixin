package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;
import com.flyonsky.weixin.data.NoSign;

/**
 * 微信公众号内发起的，网页端调起支付请求数据
 * @author Administrator
 *
 */
public class JSPayData extends AbstractData{
	// 公众号id
	@JsonProperty("appId")
	private String appId;
	
	// 时间戳
	@JsonProperty("timeStamp")
	private String timeStamp;
	
	// 随机字符串
	@JsonProperty("nonceStr")
	private String nonceStr;
	
	// 订单详情扩展字符串
	@JsonProperty("package")
	private String packageInfo;
	
	// 签名方式
	@JsonProperty("signType")
	private String signType;
	
	// 签名
	@NoSign
	@JsonProperty("paySign")
	private String paySign;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPackageInfo() {
		return packageInfo;
	}

	public void setPackageInfo(String packageInfo) {
		this.packageInfo = packageInfo;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
}
