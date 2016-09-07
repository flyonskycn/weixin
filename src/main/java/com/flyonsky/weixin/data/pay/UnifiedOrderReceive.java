package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 统一下单响应数据
 * @author Administrator
 *
 */
public class UnifiedOrderReceive extends PayReceive{
	
	// 设备号
	@JsonProperty("device_info")
	private String deviceInfo;
	
	// 交易类型
	@JsonProperty("trade_type")
	private String tradeType;
	
	// 预支付交易会话标识
	@JsonProperty("prepay_id")
	private String prepayId;
	
	// 二维码链接
	@JsonProperty("code_url")
	private String codeUrl;

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}
}
