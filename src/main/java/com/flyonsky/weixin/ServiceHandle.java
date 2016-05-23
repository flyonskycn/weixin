package com.flyonsky.weixin;

import org.dom4j.Document;

import com.flyonsky.weixin.data.MessageData;
import com.flyonsky.weixin.data.UserInfo;

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
	 * 微信服务号接收处理
	 * @param doc 微信事件参数
	 * @return 响应消息
	 */
	MessageData receiveHandler(Document doc);
	
	/**
	 * 微信服务号获取access token
	 * @param appid 第三方用户唯一凭证
	 * @param secret 第三方用户唯一凭证密钥，即appsecret
	 * @return access_token 
	 */
	String accessToken(String appid,String secret);
	
	/**
	 * 微信服务号获取access token
	 * @param appid 第三方用户唯一凭证
	 * @param secret 第三方用户唯一凭证密钥，即appsecret
	 * @param isObtain 是否重新向微信服务器获取access token
	 * @return access_token 
	 */
	String accessToken(String appid,String secret, boolean isObtain);
	
	/**
	 * 微信服务号获取用户信息
	 * @param appid 第三方用户唯一凭证
	 * @param secret 第三方用户唯一凭证密钥，即appsecret
	 * @param openid 
	 * @return
	 */
	UserInfo userInfo(String appid,String secret,String openid) throws WeixinException;
}
