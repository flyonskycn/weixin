package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 微信支付订单查询接收到的响应数据
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderQueryReceive extends PayReceive{
	
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
	
	// 交易状态
	@JsonProperty("trade_state")
	private String tradeState;
	
	// 付款银行
	@JsonProperty("bank_type")
	private String bankType;
	
	// 订单金额
	@JsonProperty("total_fee")
	private int totalFee;
	
	// 应结订单金额
	@JsonProperty("settlement_total_fee")
	private int settlementTotalFee;
	
	// 货币种类
	@JsonProperty("fee_type")
	private String feeType;
	
	// 现金支付金额
	@JsonProperty("cash_fee")
	private int cashFee;
	
	// 现金支付货币类型
	@JsonProperty("cash_fee_type")
	private String cashFeeType;
	
	// 代金券金额
	@JsonProperty("coupon_fee")
	private int couponFee;
	
	// 代金券使用数量
	@JsonProperty("coupon_count")
	private int couponCount;
	
	// 微信支付订单号
	@JsonProperty("transaction_id")
	private String transactionId;
	
	// 商户订单号
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 附加数据
	@JsonProperty("attach")
	private String attach;
	
	// 支付完成时间
	@JsonProperty("time_end")
	private String timeEnd;
	
	// 交易状态描述
	@JsonProperty("trade_state_desc")
	private String tradeStateDesc;

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

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public int getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(int settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public int getCashFee() {
		return cashFee;
	}

	public void setCashFee(int cashFee) {
		this.cashFee = cashFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public int getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(int couponFee) {
		this.couponFee = couponFee;
	}

	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
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

	public String getTradeStateDesc() {
		return tradeStateDesc;
	}

	public void setTradeStateDesc(String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}
}
