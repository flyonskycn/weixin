package com.flyonsky.weixin.data.pay;

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
public class PayReceive extends AbstractPayData {
	
	// 返回状态码
	@JsonProperty("return_code")
	private String returnCode;
	
	// 返回信息
	@JsonProperty("return_msg")
	private String returnMsg;
	
	// 业务结果
	@JsonProperty("result_code")
	private String resultCode;
	
	// 业务结果描述
	@JsonProperty("result_msg")
	private String resultMsg;
	
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

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
}
