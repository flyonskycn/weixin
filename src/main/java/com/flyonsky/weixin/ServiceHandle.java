package com.flyonsky.weixin;

import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.EnumQrcodeType;
import com.flyonsky.weixin.data.QrcodeReceive;

/**
 * 微信服务号处理接口
 * @author Administrator
 *
 */
public interface ServiceHandle {
	
	/**
	 * 微信服务号验证服务器地址的有效性
	 * @param token 公众号的token配置数据
	 * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @param echostr 随机字符串
	 * @return false:无效,true:有效
	 */
	boolean checkSignature(String token, String signature,String timestamp,String nonce,String echostr);
	
	/**
	 * 微信服务号获取access token
	 * @param appid 第三方用户唯一凭证
	 * @param secret 第三方用户唯一凭证密钥，即appsecret
	 * @return access_token 
	 */
	AccessToken accessToken(String appid,String secret);
	
	/**
	 * 微信服务号获取access token
	 * @param appid 第三方用户唯一凭证
	 * @param secret 第三方用户唯一凭证密钥，即appsecret
	 * @param isObtain 是否重新向微信服务器获取access token
	 * @return access_token 
	 */
	AccessToken accessToken(String appid,String secret, boolean isObtain);
	
	/**
	 * 获取js-sdk的ticket
	 * @param appid 公众号appid
	 * @param accessToken 对应公从号的 accessToken
	 * @return
	 */
	String ticket(String appid, String accessToken);
	
	/**
	 * 微信二维码生成
	 * @param accessToken 对应公从号的 accessToken
	 * @param qrcodeType 二维码类型
	 * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @param expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 * @return
	 */
	QrcodeReceive createQrcode(String accessToken, EnumQrcodeType qrcodeType, int sceneId, long expireSeconds);
	
	/**
	 * 获取微信显示二维码的URL地址
	 * @param ticket 获取二码是使用的ticket
	 * @return
	 */
	String showQrcode(String ticket);
}
