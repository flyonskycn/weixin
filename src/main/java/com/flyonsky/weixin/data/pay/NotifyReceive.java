package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 接收支付结果的异步通知参数
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotifyReceive extends PayReceive{
	
	// 子商户号
	@JsonProperty("sub_mch_id")
	private String subMchId;
	
	// 设备号
	@JsonProperty("device_info")
	private String deviceInfo;
	
	// 用户标识
	@JsonProperty("openid")
	private String openId;
	
	// 是否关注公众账号
	@JsonProperty("is_subscribe")
	private String isSubscribe;
	
	// 交易类型
	@JsonProperty("trade_type")
	private String tradeType;
	
	// 付款银行类型
	@JsonProperty("bank_type")
	private String bankType;
	
	// 订单金额
	@JsonProperty("total_fee")
	private Integer totalFee;
	
	// 货币种类
	@JsonProperty("fee_type")
	private String feeType;
	
	// 现金支付金额
	@JsonProperty("cash_fee")
	private Integer cashFee;
	
	// 现金支付货币类型
	@JsonProperty("cash_fee_type")
	private String cashFeeType;
	
	// 代金券金额
	@JsonProperty("coupon_fee")
	private Integer couponFee;
	
	// 代金券使用数量
	@JsonProperty("coupon_count")
	private Integer coupon_count;
	
	// 微信支付订单号
	@JsonProperty("transaction_id")
	private String transactionId;
	
	// 商户订单号
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 商家数据包
	@JsonProperty("attach")
	private String attach;
	
	// 支付完成时间
	@JsonProperty("time_end")
	private String timeEnd;

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
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

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public Integer getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	public Integer getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(Integer coupon_count) {
		this.coupon_count = coupon_count;
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
