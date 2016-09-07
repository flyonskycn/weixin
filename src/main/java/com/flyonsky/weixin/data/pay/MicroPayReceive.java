package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 刷卡支付API返回的响应
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MicroPayReceive extends PayReceive{

	// 设备号
	@JsonProperty("device_info")
	private String deviceInfo;
	
	// 用户标识
	@JsonProperty("openid")
	private String openid;
	
	// 是否关注公众账号
	@JsonProperty("is_subscribe")
	private String isSubscribe;
	
	// 交易类型
	@JsonProperty("trade_type")
	private String tradeType;
	
	// 付款银行
	@JsonProperty("bank_type")
	private String bankType;
	
	// 货币类型
	@JsonProperty("fee_type")
	private String feeType;
	
	// 订单总金额，单位为分，只能为整数
	@JsonProperty("total_fee")
	private int totalFee;
	
	// 现金支付货币类型
	@JsonProperty("cash_fee_type")
	private String cashFeeType;
	
	// 现金支付金额
	@JsonProperty("cash_fee")
	private int cashFee;
	
	// 微信支付订单号
	@JsonProperty("transaction_id")
	private String transactionId;
	
	// 商户订单号
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 商家数据包
	@JsonProperty("attach")
	private String attach;
	
	// 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
	@JsonProperty("time_end")
	private String timeEnd;

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public int getCashFee() {
		return cashFee;
	}

	public void setCashFee(int cashFee) {
		this.cashFee = cashFee;
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

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
}
