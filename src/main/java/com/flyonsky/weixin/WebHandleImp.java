package com.flyonsky.weixin;

import java.text.MessageFormat;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.BaseData;
import com.flyonsky.weixin.data.EnumScope;
import com.flyonsky.weixin.data.UserInfo;

@Service
public class WebHandleImp extends AbstractHandle implements WebHandle{
	
	private static final Logger LOG = LoggerFactory.getLogger(WebHandleImp.class);
	
	// 微信网页授权基本地址
	@Value("${weixin.web.base.url}")
	private String webBaseUrl;
	
	// 微信网页token获取地址
	@Value("${weixin.web.token.url}")
	private String tokenUrl;
	
	// 微信网页token刷新地址
	@Value("${weixin.web.token.refresh.url}")
	private String refreshTokenUrl;
	
	// 微信网页用户信息获取地址
	@Value("${weixin.web.user.url}")
	private String userInfoUrl;
	
	// 微信网页token有效性验证地址
	@Value("${weixin.web.token.valid.url}")
	private String tokenValidUrl;
	
	@Value("${weixin.authorize.base.url}")
	private String authorizeBaseUrl;
	
	// 微信内访问网页登陆授权页,相对于authorizeBaseUrl
	@Value("${weixin.web.authorize.url}")
	private String authorizeUrl;
	
	// 微信授权网站登陆，但并不是在微信内访问的网站,授权地址,相对于authorizeBaseUrl
	@Value("${web.weixin.authorize.url}")
	private String webAuthorizeUrl;

	@Override
	public String authorizeUrl(String appid, EnumScope scope, String redirectUri) {
		Random random = new Random();
		int r = random.nextInt();
		String url = "";
		switch(scope){
		case snsapi_base:
			url = MessageFormat.format(this.getAuthorizeBaseUrl() + this.getAuthorizeUrl(), appid, redirectUri, scope.toString(), String.valueOf(r));
			break;
			default:
				url = MessageFormat.format(this.getAuthorizeBaseUrl() + this.getWebAuthorizeUrl(), appid, redirectUri, scope.toString(), String.valueOf(r));
				break;
		}
		return url;
	}

	@Override
	public AccessToken accessToken(String appid, String secret, String code) {
		String url = this.getWebBaseUrl() + MessageFormat.format(this.getTokenUrl(), appid, secret, code);
		AccessToken tokenBean = this.doGet(url, AccessToken.class);
		return tokenBean;
	}

	@Override
	public AccessToken refreshToken(String appid, String refreshToken) {
		String url = this.getWebBaseUrl() + MessageFormat.format(this.getRefreshTokenUrl(), appid, refreshToken);
		AccessToken tokenBean = this.doGet(url, AccessToken.class);
		return tokenBean;
	}

	@Override
	public UserInfo userInfo(String accessToken, String openid) {
		String url = this.getWebBaseUrl() + MessageFormat.format(this.getUserInfoUrl(), accessToken, openid);
		UserInfo userInfo = this.doGet(url, UserInfo.class);
		return userInfo;
	}

	@Override
	public boolean accessTokenValid(String accessToken, String openid) {
		String url = this.getWebBaseUrl() + MessageFormat.format(this.getTokenValidUrl(), accessToken, openid);
		BaseData base = this.doGet(url, BaseData.class);
		return base.getErrCode() == 0 ? true: false;
	}

	public String getWebBaseUrl() {
		return webBaseUrl;
	}

	public void setWebBaseUrl(String webBaseUrl) {
		this.webBaseUrl = webBaseUrl;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public String getRefreshTokenUrl() {
		return refreshTokenUrl;
	}

	public void setRefreshTokenUrl(String refreshTokenUrl) {
		this.refreshTokenUrl = refreshTokenUrl;
	}

	public String getUserInfoUrl() {
		return userInfoUrl;
	}

	public void setUserInfoUrl(String userInfoUrl) {
		this.userInfoUrl = userInfoUrl;
	}

	public String getTokenValidUrl() {
		return tokenValidUrl;
	}

	public void setTokenValidUrl(String tokenValidUrl) {
		this.tokenValidUrl = tokenValidUrl;
	}

	public String getAuthorizeUrl() {
		return authorizeUrl;
	}

	public void setAuthorizeUrl(String authorizeUrl) {
		this.authorizeUrl = authorizeUrl;
	}

	public String getAuthorizeBaseUrl() {
		return authorizeBaseUrl;
	}

	public void setAuthorizeBaseUrl(String authorizeBaseUrl) {
		this.authorizeBaseUrl = authorizeBaseUrl;
	}

	public String getWebAuthorizeUrl() {
		return webAuthorizeUrl;
	}

	public void setWebAuthorizeUrl(String webAuthorizeUrl) {
		this.webAuthorizeUrl = webAuthorizeUrl;
	}

}
