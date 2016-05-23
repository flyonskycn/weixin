package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 统一下单响应数据
 * @author Administrator
 *
 */
public class UnifiedOrderReceive extends PayReceiveBase{
	
	// 公众账号ID
	@JsonProperty("appid")
	private String appId;
	
	// 商户号
	@JsonProperty("mch_id")
	private String mchId;
	
	// 设备号
	@JsonProperty("device_info")
	private String deviceInfo;
	
	// 随机字符串
	@JsonProperty("nonce_str")
	private String nonceStr;
	
	// 签名
	@JsonProperty("sign")
	private String sign;
	
	// 业务结果
	@JsonProperty("result_code")
	private String resultCode;
	
	// 错误代码
	@JsonProperty("err_code")
	private String errCode;
	
	// 错误代码描述
	@JsonProperty("err_code_des")
	private String errCodeDes;
	
	// 交易类型
	@JsonProperty("trade_type")
	private String tradeType;
	
	// 预支付交易会话标识
	@JsonProperty("prepay_id")
	private String prepayId;
	
	// 二维码链接
	@JsonProperty("code_url")
	private String codeUrl;

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

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
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
