package com.flyonsky.weixin.data;

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
	VIEW,
	/**
	 * 扫码推事件的事件推送
	 */
	scancode_push,
	/**
	 * 扫码推事件且弹出“消息接收中”提示框的事件推送
	 */
	scancode_waitmsg,
	/**
	 * 弹出系统拍照发图的事件推送
	 */
	pic_sysphoto,
	/**
	 * 弹出拍照或者相册发图的事件推送
	 */
	pic_photo_or_album,
	/**
	 * 弹出微信相册发图器的事件推送
	 */
	pic_weixin,
	/**
	 * 弹出地理位置选择器的事件推送
	 */
	location_select,
	/**
	 * 模板消息发送后响应
	 */
	TEMPLATESENDJOBFINISH,
	/**
	 * 客服接入会话
	 */
	kf_create_session,
	/**
	 * 客服关闭会话
	 */
	kf_close_session,
	/**
	 * 客服转接会话
	 */
	kf_switch_session
}
