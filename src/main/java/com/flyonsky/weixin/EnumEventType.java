package com.flyonsky.weixin;

/**
 * 事件类型枚举
 * @author Administrator
 *
 */
public enum EnumEventType {
	/**
	 * 关注事件
	 */
	subscribe,
	/**
	 * 取消关注
	 */
	unsubscribe,
	/**
	 * 用户已关注
	 */
	SCAN,
	/**
	 * 上报地理位置
	 */
	LOCATION,
	/**
	 * 自定义菜单事件
	 */
	CLICK,
	/**
	 * 点击菜单跳转链接
	 */
	VIEW
}
