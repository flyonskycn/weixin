package com.flyonsky.weixin.data;

/**
 * 微信请求授权的来源
 * @author Administrator
 *
 */
public enum EnumAuthorizeSource {
	/**
	 * 移动应用开发
	 */
	APP,
	/**
	 * 网站应用开发
	 */
	WEB,
	/**
	 * 公众帐号开发
	 */
	SERVICE,
	/**
	 * 公众号第三方平台开发
	 */
	THIRD_PLATFORM
}
