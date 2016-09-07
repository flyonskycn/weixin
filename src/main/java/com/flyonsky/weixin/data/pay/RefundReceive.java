package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 退款申请响应数据
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefundReceive extends PayReceive{

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
	
	// 退款渠道
	@JsonProperty("refund_channel")
	private String refundChannel;
	
	// 申请退款金额
	@JsonProperty("refund_fee")
	private int refundFee;
	
	// 订单金额
	@JsonProperty("total_fee")
	private int totalFee;
	
	// 应结订单金额
	@JsonProperty("settlement_total_fee")
	private int settlementTotalFee;
	
	// 订单金额货币种类
	@JsonProperty("fee_type")
	private String feeType;
	
	// 现金支付金额
	@JsonProperty("cash_fee")
	private int cashFee;
	
	// 现金退款金额
	@JsonProperty("cash_refund_fee")
	private int cashRefundFee;
	
	// 代金券类型
	@JsonProperty("coupon_type_0")
	private String couponType;
	
	// 代金券退款金额
	@JsonProperty("coupon_refund_fee_0")
	private int couponRefundFee;
	
	// 退款代金券使用数量
	@JsonProperty("coupon_refund_count_0")
	private int couponRefundCount;
	
	// 退款代金券批次ID
	@JsonProperty("coupon_refund_batch_id_0_0")
	private String couponRefundBatchId;
	
	// 退款代金券ID
	@JsonProperty("coupon_refund_id_0_0")
	private String couponRefundId;
	
	// 单个退款代金券支付金额
	@JsonProperty("coupon_refund_fee_0_0")
	private int couponRefundSimpleFee;

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

	public String getRefundChannel() {
		return refundChannel;
	}

	public void setRefundChannel(String refundChannel) {
		this.refundChannel = refundChannel;
	}

	public int getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(int refundFee) {
		this.refundFee = refundFee;
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

	public int getCashRefundFee() {
		return cashRefundFee;
	}

	public void setCashRefundFee(int cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public int getCouponRefundFee() {
		return couponRefundFee;
	}

	public void setCouponRefundFee(int couponRefundFee) {
		this.couponRefundFee = couponRefundFee;
	}

	public int getCouponRefundCount() {
		return couponRefundCount;
	}

	public void setCouponRefundCount(int couponRefundCount) {
		this.couponRefundCount = couponRefundCount;
	}

	public String getCouponRefundBatchId() {
		return couponRefundBatchId;
	}

	public void setCouponRefundBatchId(String couponRefundBatchId) {
		this.couponRefundBatchId = couponRefundBatchId;
	}

	public String getCouponRefundId() {
		return couponRefundId;
	}

	public void setCouponRefundId(String couponRefundId) {
		this.couponRefundId = couponRefundId;
	}

	public int getCouponRefundSimpleFee() {
		return couponRefundSimpleFee;
	}

	public void setCouponRefundSimpleFee(int couponRefundSimpleFee) {
		this.couponRefundSimpleFee = couponRefundSimpleFee;
	}
}
