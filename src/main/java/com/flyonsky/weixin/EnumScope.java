package com.flyonsky.weixin;

/**
 * 页面授权类型枚举
 * @author Administrator
 *
 */
public enum EnumScope {
	/**
	 * 基本授权，只能获取openid
	 */
	snsapi_base,
	/**
	 * 弹出授权页面，可以获取用户基本信息
	 */
	snsapi_userinfo,
	/**
	 * 微信扫码授权第三方网站
	 */
	snsapi_login
}
