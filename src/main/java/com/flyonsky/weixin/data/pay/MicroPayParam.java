package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 刷卡支付API请求参数
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MicroPayParam extends AbstractPayData{

	// 终端设备号(商户自定义，如门店编号)
	@JsonProperty("device_info")
	private String deviceInfo;
	
	// 商品简单描述，该字段须严格按照规范传递
	@JsonProperty("body")
	private String body;
	
	// 商品详情OrderGoodsDetail对象的json表示
	@JsonProperty("detail")
	@JacksonXmlCData
	private String detail;
	
	// 附加数据
	@JsonProperty("attach")
	private String attach;
	
	// 商户订单号
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 订单金额,单位为分,只能为整数
	@JsonProperty("total_fee")
	private int totalFee;
	
	// 货币类型
	@JsonProperty("fee_type")
	private String feeType;
	
	// 终端IP
	@JsonProperty("spbill_create_ip")
	private String spbillCreateIp;
	
	// 商品标记
	@JsonProperty("goods_tag")
	private String goodsTag;
	
	// 指定支付方式
	@JsonProperty("limit_pay")
	private String limitPay;
	
	// 授权码
	@JsonProperty("auth_code")
	private String authCode;

	/**
	 * 终端设备号(商户自定义，如门店编号)
	 * @return
	 */
	public String getDeviceInfo() {
		return deviceInfo;
	}

	/**
	 * 终端设备号(商户自定义，如门店编号)
	 * @param deviceInfo
	 */
	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	/**
	 * 商品简单描述，该字段须严格按照规范传递
	 * PC网站:浏览器打开的网站主页title名 -商品概述;样例:腾讯充值中心-QQ会员充值
	 * 微信浏览器:商家名称-销售商品类目;样例:罗辑思维-图书
	 * 门店扫码:店名-销售商品类目;样例:天虹南山店-超市
	 * 门店刷卡:店名-销售商品类目;样例:天虹南山店-超市
	 * 第三方手机浏览器:浏览器打开的移动网页的主页title名-商品概述;样例:腾讯充值中心-QQ会员充值
	 * 第三方APP:应用市场上的APP名字-商品概述;样例:天天爱消除-游戏充值
	 * @return
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 商品简单描述，该字段须严格按照规范传递
	 * PC网站:浏览器打开的网站主页title名 -商品概述;样例:腾讯充值中心-QQ会员充值
	 * 微信浏览器:商家名称-销售商品类目;样例:罗辑思维-图书
	 * 门店扫码:店名-销售商品类目;样例:天虹南山店-超市
	 * 门店刷卡:店名-销售商品类目;样例:天虹南山店-超市
	 * 第三方手机浏览器:浏览器打开的移动网页的主页title名-商品概述;样例:腾讯充值中心-QQ会员充值
	 * 第三方APP:应用市场上的APP名字-商品概述;样例:天天爱消除-游戏充值
	 * @param body 
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 商品详情OrderGoodsDetail对象的json表示
	 * @return
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * 商品详情OrderGoodsDetail对象的json表示
	 * @param detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * 附加数据
	 * @return
	 */
	public String getAttach() {
		return attach;
	}

	/**
	 * 附加数据
	 * @param attach
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}

	/**
	 * 商户订单号
	 * @return
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * 商户订单号
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 订单金额,单位为分,只能为整数
	 * @return
	 */
	public int getTotalFee() {
		return totalFee;
	}

	/**
	 * 订单金额,单位为分,只能为整数
	 * @param totalFee
	 */
	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * 货币类型
	 * @return
	 */
	public String getFeeType() {
		return feeType;
	}

	/**
	 * 货币类型
	 * @param feeType
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	/**
	 * 终端IP
	 * @return
	 */
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	/**
	 * 终端IP
	 * @param spbillCreateIp
	 */
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	/**
	 * 商品标记
	 * @return
	 */
	public String getGoodsTag() {
		return goodsTag;
	}

	/**
	 * 商品标记
	 * @param goodsTag
	 */
	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	/**
	 * 指定支付方式
	 * @return
	 */
	public String getLimitPay() {
		return limitPay;
	}

	/**
	 * 指定支付方式
	 * @param limitPay
	 */
	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	/**
	 * 授权码 扫码支付授权码，设备读取用户微信中的条码或者二维码信息
	 * @return
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * 授权码 扫码支付授权码，设备读取用户微信中的条码或者二维码信息
	 * @param authCode
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
}
