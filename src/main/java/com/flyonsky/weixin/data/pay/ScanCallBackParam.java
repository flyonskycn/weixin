package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 扫码支付模式一回调URL的请求参数
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScanCallBackParam extends AbstractPayData{

	// 用户标识
	@JsonProperty("openid")
	private String openid;
	
	// 是否关注公众账号
	@JsonProperty("is_subscribe")
	private String isSubscribe;
	
	// 商户定义的商品id 或者订单号
	@JsonProperty("product_id")
	private String productId;

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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
}
