package com.flyonsky.weixin;

import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.EnumScope;
import com.flyonsky.weixin.data.UserInfo;

/**
 * 微信的web服务接口
 * @author Administrator
 *
 */
public interface WebHandle {
	
	/**
	 * 微信授权地址
	 * @param appid 公众号的唯一标识
	 * @param scope 应用授权作用域
	 * @param redirectUri 授权后重定向的回调链接地址，请使用urlencode对链接进行处理
	 * @return 微信授权地址
	 */
	String webAuthorize(String appid, EnumScope scope, String redirectUri);
	
	/**
	 * 通过code换取网页授权access_token
	 * @param appid 公众号的唯一标识
	 * @param secret 公众号的appsecret
	 * @param code 微信授权地址回调时返回的code参数
	 * @return 
	 */
	AccessToken accessToken(String appid,String secret,String code);
	
	/**
	 * 刷新access_token
	 * @param appid 公众号的唯一标识
	 * @param refreshToken 填写通过accessToken()获取到的refresh_token参数
	 * @return
	 */
	AccessToken refreshToken(String appid,String refreshToken);
	
	/**
	 * 获取用户信息
	 * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param openid 用户的唯一标识
	 * @return
	 */
	UserInfo userInfo(String accessToken, String openid);
	
	/**
	 * 检验授权凭证（access_token）是否有效
	 * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param openid 用户的唯一标识
	 * @return true:表示有效,false:表示无效
	 */
	boolean accessTokenValid(String accessToken, String openid);
}
