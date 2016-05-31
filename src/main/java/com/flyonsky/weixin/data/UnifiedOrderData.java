package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 统一下单请求参数
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnifiedOrderData extends PayRequestBase{
	
	// 设备号
	@JsonProperty("device_info")
	private String deviceInfo;
	
	// 商品描述
	@JsonProperty("body")
	@JacksonXmlCData
	private String body;
	
	// 商品详情
	@JsonProperty("detail")
	@JacksonXmlCData
	private String detail;
	
	// 附加数据
	@JsonProperty("attach")
	@JacksonXmlCData
	private String attach;
	
	// 商户订单号
	@JsonProperty("out_trade_no")
	@JacksonXmlCData
	private String outTradeNo;
	
	// 货币类型
	@JsonProperty("fee_type")
	private String feeType;
	
	// 总金额
	@JsonProperty("total_fee")
	@JacksonXmlCData
	private int totalFee;
	
	// 终端IP
	@JsonProperty("spbill_create_ip")
	private String spbillCreateIp;
	
	// 交易起始时间
	@JsonProperty("time_start")
	@JacksonXmlCData
	private String timeStart;
	
	// 交易结束时间
	@JsonProperty("time_expire")
	@JacksonXmlCData
	private String timeExpire;
	
	// 商品标记
	@JsonProperty("goods_tag")
	private String goodsTag;
	
	// 通知地址
	@JsonProperty("notify_url")
	@JacksonXmlCData
	private String notifyUrl;
	
	// 交易类型
	@JsonProperty("trade_type")
	private String tradeType;
	
	// 商品ID
	@JsonProperty("product_id")
	private String productId;
	
	// 指定支付方式
	@JsonProperty("limit_pay")
	private String limitPay;
	
	// 用户标识
	@JsonProperty("openid")
	private String openid;

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
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

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
