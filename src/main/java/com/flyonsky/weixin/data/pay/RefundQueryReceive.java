package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 退款查询响应数据
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefundQueryReceive extends PayReceive{

	// 设备号
	@JsonProperty("device_info")
	private String deviceInfo;
	
	// 微信订单号
	@JsonProperty("transaction_id")
	private String transactionId;
	
	// 商户订单号
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
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
	
	// 退款笔数
	@JsonProperty("refund_count")
	private int refundCount;
	
	// 商户退款单号
	@JsonProperty("out_refund_no_0")
	private String outRefundNo;
	
	// 微信退款单号
	@JsonProperty("refund_id_0")
	private String refundId;
	
	// 退款渠道
	@JsonProperty("refund_channel_0")
	private String refundChannel;
	
	// 申请退款金额
	@JsonProperty("refund_fee_0")
	private int refundFee;
	
	// 退款金额
	@JsonProperty("settlement_refund_fee_0")
	private int settlementRefundFee;
	
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
	
	// 退款状态
	@JsonProperty("refund_status_0")
	private String refundStatus;
	
	// 退款入账账户
	@JsonProperty("refund_recv_accout_0")
	private String refundRecvAccout;

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

	public int getRefundCount() {
		return refundCount;
	}

	public void setRefundCount(int refundCount) {
		this.refundCount = refundCount;
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

	public int getSettlementRefundFee() {
		return settlementRefundFee;
	}

	public void setSettlementRefundFee(int settlementRefundFee) {
		this.settlementRefundFee = settlementRefundFee;
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

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getRefundRecvAccout() {
		return refundRecvAccout;
	}

	public void setRefundRecvAccout(String refundRecvAccout) {
		this.refundRecvAccout = refundRecvAccout;
	}
}
