package com.flyonsky.weixin.data;

/**
 * 消息类型枚举
 * @author Administrator
 *
 */
public enum EnumMsgType {
	/**
	 * 事件消息类型
	 */
	event,
	/**
	 * 文本消息
	 */
	text,
	/**
	 * 图片消息
	 */
	image,
	/**
	 * 语音消息
	 */
	voice,
	/**
	 * 视频消息
	 */
	video,
	/**
	 * 小视频
	 */
	shortvideo,
	/**
	 * 地理位置消息
	 */
	location,
	/**
	 * 链接消息
	 */
	link,
	/**
	 * 音乐消息
	 */
	music,
	/**
	 * 图文消息
	 */
	news,
	/**
	 * 图文消息,客服回复中使用素材中的图文消息
	 */
	mpnews,
	/**
	 * 卡券消息
	 */
	wxcard,
	/**
	 * 消息转发到多客服
	 */
	transfer_customer_service
}
