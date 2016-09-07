package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 退款单查询参数
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefundQueryParam extends AbstractPayData{

	// 设备号
	@JsonProperty("device_info")
	private String deviceInfo;
	
	// 微信订单号
	@JsonProperty("transaction_id")
	private String transactionId;
	
	// 商户订单号
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 商户退款单号
	@JsonProperty("out_refund_no")
	private String outRefundNo;
	
	// 微信退款单号
	@JsonProperty("refund_id")
	private String refundId;

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}
}
