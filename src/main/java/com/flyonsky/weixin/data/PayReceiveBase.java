package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 支付相关请求接收到的响应数据
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayReceiveBase extends AbstractData {
	
	// 返回状态码
	@JsonProperty("return_code")
	private String returnCode;
	
	// 返回信息
	@JsonProperty("return_msg")
	private String returnMsg;
	
	// 公众账号ID
	@JsonProperty("appid")
	private String appId;
	
	// 商户号
	@JsonProperty("mch_id")
	private String mchId;
	
	// 随机字符串
	@JsonProperty("nonce_str")
	private String nonceStr;
	
	// 签名
	@NoSign
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
}
