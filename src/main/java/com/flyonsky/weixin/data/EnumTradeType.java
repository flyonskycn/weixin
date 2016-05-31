package com.flyonsky.weixin.data;

/**
 * 微信交易类型
 * @author Administrator
 *
 */
public enum EnumTradeType {
	/**
	 * 公众号支付
	 */
	JSAPI,
	/**
	 * 原生扫码支付
	 */
	NATIVE,
	/**
	 * app支付
	 */
	APP,
	/**
	 * 刷卡支付,不调用统一下单接口
	 */
	MICROPAY
}
